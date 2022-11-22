package project.diet.control.modules.business.diet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.enumerators.CrudOptionsEnum;
import lib.base.backend.exception.data.BusinessException;
import project.diet.control.app.beans.entity.Diet;
import project.diet.control.app.beans.entity.DietFood;
import project.diet.control.app.beans.pojos.diet.DietFoodResumePojo;
import project.diet.control.app.beans.pojos.entity.DietEntityPojo;
import project.diet.control.app.beans.pojos.entity.RecipeEntityPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.AddEditDietDataPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietBaseDataPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.RegisterDietBaseRequestPojo;

@Component
public class CrudDietBaseBusiness extends CrudDietBusiness {
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public AddEditDietDataPojo executeRegisterDietBase(RegisterDietBaseRequestPojo requestPojo) throws BusinessException {
		
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
		
		AddEditDietDataPojo responsePojo = new AddEditDietDataPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public GetDietBaseDataPojo executeGetDietBase() {
		
		Diet dietBase = dietRepository.getDietBase();
		
		if (dietBase == null)
			return null;
		
		RecipeEntityPojo recipeEntityPojo = buildEntityToPojoUtil.generateRecipePojo(null, dietBase.getRecipe());
		DietEntityPojo dietResumePojo = buildEntityToPojoUtil.generateDietPojo(null, dietBase);
		
		List<DietFoodResumePojo> dietFoodResumeEntityPojos = new ArrayList<>();
		
		for (DietFood dietFood: dietBase.getDietFoods()) {
			
			DietFoodResumePojo dietFoodResumeEntityPojo = (DietFoodResumePojo) buildEntityToPojoUtil.generateDietFoodPojo(new DietFoodResumePojo(), dietFood, true);
			dietFoodResumeEntityPojo.setIdDietFood(dietFood.getId());
			dietFoodResumeEntityPojo.setPortions(dietFood.getPortions());
			dietFoodResumeEntityPojo.setUnities(dietFood.getUnities() != null ? dietFood.getUnities() : BigDecimal.valueOf(0.0));
			
			dietFoodResumeEntityPojos.add(dietFoodResumeEntityPojo);
		}
		
		GetDietBaseDataPojo responsePojo = new GetDietBaseDataPojo();
		responsePojo.setRecipe(recipeEntityPojo);
		responsePojo.setDiet(dietResumePojo);
		responsePojo.setFoods(dietFoodResumeEntityPojos);
		
		return responsePojo;
	}
}
