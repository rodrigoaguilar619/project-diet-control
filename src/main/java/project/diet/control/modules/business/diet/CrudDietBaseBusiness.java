package project.diet.control.modules.business.diet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.enumerators.CrudOptionsEnum;
import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.persistance.GenericPersistence;
import project.diet.control.app.beans.entity.DietEntity;
import project.diet.control.app.beans.entity.DietFoodEntity;
import project.diet.control.app.beans.pojos.diet.DietFoodResumePojo;
import project.diet.control.app.beans.pojos.entity.DietEntityPojo;
import project.diet.control.app.beans.pojos.entity.RecipeEntityPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.AddEditDietDataPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietBaseDataPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.RegisterDietBaseRequestPojo;
import project.diet.control.app.repository.DietRepositoryImpl;
import project.diet.control.app.vo.catalogs.CatalogsErrorMessage;
import project.diet.control.config.helper.DietHelper;

@Component
public class CrudDietBaseBusiness extends CrudDietBusiness {
	
	
	
	@SuppressWarnings("rawtypes")
	public CrudDietBaseBusiness(GenericPersistence genericPersistance, DietRepositoryImpl dietRepository, DietHelper dietHelper) {
		super(genericPersistance, dietRepository, dietHelper);
	}

	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public AddEditDietDataPojo executeRegisterDietBase(RegisterDietBaseRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getDiet() == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgDietNotFoundRequest());
		
		requestPojo.getDiet().setIsBase(true);
		
		DietEntity dietBase = dietRepository.getDietBase();
		deleteDiet(dietBase);
		
		if  (dietBase != null && requestPojo.getDiet().getIdRecipe() != dietBase.getRecipe().getId()) {
			
			DietEntity diet = (DietEntity) genericPersistance.findById(DietEntity.class, requestPojo.getDiet().getIdRecipe());
			
			if (diet != null)
				throw new BusinessException(CatalogsErrorMessage.getErrorMsgDietBaseExist(diet.getIdRecipe(), diet.getRecipe().getTitle()));
		}
		
		Integer id = setAddEditDiet(null, requestPojo.getDiet(), CrudOptionsEnum.SAVE);
		
		AddEditDietDataPojo responsePojo = new AddEditDietDataPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public GetDietBaseDataPojo executeGetDietBase() {
		
		DietEntity dietBase = dietRepository.getDietBase();
		
		if (dietBase == null)
			return null;
		
		RecipeEntityPojo recipeEntityPojo = buildEntityToPojoUtil.generateRecipePojo(null, dietBase.getRecipe());
		DietEntityPojo dietResumePojo = buildEntityToPojoUtil.generateDietPojo(null, dietBase);
		
		List<DietFoodResumePojo> dietFoodResumeEntityPojos = new ArrayList<>();
		
		for (DietFoodEntity dietFood: dietBase.getDietFoods()) {
			
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
