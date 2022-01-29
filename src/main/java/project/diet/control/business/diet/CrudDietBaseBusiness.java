package project.diet.control.business.diet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.web.enumeratos.CrudOptionsEnum;
import project.diet.control.beans.entity.Diet;
import project.diet.control.beans.entity.DietFood;
import project.diet.control.pojos.diet.DietFoodResumePojo;
import project.diet.control.pojos.entity.DietEntityPojo;
import project.diet.control.pojos.entity.RecipeEntityPojo;
import project.diet.control.pojos.request.diet.RegisterDietBaseRequestPojo;
import project.diet.control.pojos.response.diet.AddEditDietRespPojo;
import project.diet.control.pojos.response.diet.GetDietBaseRespPojo;
import project.diet.control.repository.DietRepositoryImpl;

@Component
public class CrudDietBaseBusiness extends CrudDietBusiness {
	
	@Autowired
	DietRepositoryImpl dietRepository;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public AddEditDietRespPojo executeRegisterDietBase(RegisterDietBaseRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getDiet() == null)
			throw new BusinessException("Diet data not found on request");
		
		requestPojo.getDiet().setIsBase(true);
		
		Diet dietBase = dietRepository.getDietBase();
		deleteDiet(dietBase);
		
		if  (dietBase != null && requestPojo.getDiet().getIdRecipe() != dietBase.getRecipe().getId()) {
			
			Diet diet = (Diet) genericCustomPersistance.findById(Diet.class, requestPojo.getDiet().getIdRecipe());
			
			if (diet != null)
				throw new BusinessException("Diet custom already exist id: " + diet.getIdRecipe() + " title: " + diet.getRecipe().getTitle());
		}
		
		Integer id = setAddEditDiet(null, requestPojo.getDiet(), CrudOptionsEnum.SAVE);
		
		AddEditDietRespPojo responsePojo = new AddEditDietRespPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@Transactional
	public GetDietBaseRespPojo executeGetDietBase() {
		
		Diet dietBase = dietRepository.getDietBase();
		
		if (dietBase == null)
			return null;
		
		RecipeEntityPojo recipeEntityPojo = buildEntityToPojoUtil.generateRecipePojo(null, dietBase.getRecipe());
		DietEntityPojo dietResumePojo = buildEntityToPojoUtil.generateDietPojo(null, dietBase);
		
		List<DietFoodResumePojo> dietFoodResumeEntityPojos = new ArrayList<DietFoodResumePojo>();
		
		for (DietFood dietFood: dietBase.getDietFoods()) {
			
			DietFoodResumePojo dietFoodResumeEntityPojo = (DietFoodResumePojo) buildEntityToPojoUtil.generateDietFoodPojo(new DietFoodResumePojo(), dietFood, true);
			dietFoodResumeEntityPojo.setIdDietFood(dietFood.getId());
			dietFoodResumeEntityPojo.setPortions(dietFood.getPortions());
			dietFoodResumeEntityPojo.setUnities(dietFood.getUnities() != null ? dietFood.getUnities() : new BigDecimal(0.0));
			
			dietFoodResumeEntityPojos.add(dietFoodResumeEntityPojo);
		}
		
		GetDietBaseRespPojo responsePojo = new GetDietBaseRespPojo();
		responsePojo.setRecipe(recipeEntityPojo);
		responsePojo.setDiet(dietResumePojo);
		responsePojo.setFoods(dietFoodResumeEntityPojos);
		
		return responsePojo;
	}
}
