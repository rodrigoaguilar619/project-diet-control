package project.diet.control.modules.business.diet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.enumerators.CrudOptionsEnum;
import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.persistance.GenericPersistence;
import project.diet.control.app.beans.entity.DietEntity;
import project.diet.control.app.beans.entity.DietFoodEntity;
import project.diet.control.app.beans.entity.NutritionGoalEntity;
import project.diet.control.app.beans.pojos.diet.DietCustomDetailResumePojo;
import project.diet.control.app.beans.pojos.diet.DietDataPojo;
import project.diet.control.app.beans.pojos.diet.DietFoodResumePojo;
import project.diet.control.app.beans.pojos.diet.DietPojo;
import project.diet.control.app.beans.pojos.diet.DietResumePojo;
import project.diet.control.app.beans.pojos.entity.DietEntityPojo;
import project.diet.control.app.beans.pojos.entity.RecipeEntityPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.AddEditDietDataPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietCustomDataPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietCustomDetailDataPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietCustomDetailListDataPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietCustomListDataPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.AddEditDietRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.DeleteDietCustomRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.GetDietCustomDetailListRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.GetDietCustomRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.RegisterDietBaseRequestPojo;
import project.diet.control.app.repository.DietRepositoryImpl;
import project.diet.control.app.vo.catalogs.CatalogsErrorMessage;
import project.diet.control.config.helper.DietHelper;

@Component
public class CrudDietCustomBusiness extends CrudDietBusiness {
	
	@SuppressWarnings("rawtypes")
	public CrudDietCustomBusiness(GenericPersistence genericPersistance, DietRepositoryImpl dietRepository, DietHelper dietHelper) {
		super(genericPersistance, dietRepository, dietHelper);
	}

	@Transactional(rollbackFor = Exception.class)
	public AddEditDietDataPojo executeRegisterDietBase(RegisterDietBaseRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getDiet() == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgDietNotFoundRequest());
		
		requestPojo.getDiet().setIsBase(true);
		
		DietEntity dietBase = dietRepository.getDietBase();
		
		Integer id = setAddEditDiet(dietBase, requestPojo.getDiet(), dietBase == null ? CrudOptionsEnum.SAVE : CrudOptionsEnum.UPDATE);
		
		AddEditDietDataPojo responsePojo = new AddEditDietDataPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public GetDietCustomListDataPojo executeGetDietCustomList() {
		
		List<DietEntity> dietBases = dietRepository.getDietCustomList();
		
		List<DietResumePojo> dietResumePojos = new ArrayList<>(); 
		
		for(DietEntity diet: dietBases) {
			DietResumePojo dietResumePojo = buildEntityToPojoUtil.generateDietResumePojo(null, diet);
			
			dietResumePojos.add(dietResumePojo);
		}
		
		GetDietCustomListDataPojo responsePojo = new GetDietCustomListDataPojo();
		responsePojo.setDiets(dietResumePojos);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	@Override
	public AddEditDietDataPojo executeAddDiet(AddEditDietRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getDiet() == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgDietCustomDataNotFoundRequest());
		
		DietEntity diet = (DietEntity) genericPersistance.findById(DietEntity.class, requestPojo.getDiet().getIdRecipe());
		
		if (diet != null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgDietCustomExist(diet.getIdRecipe(), diet.getRecipe().getTitle()));
		
		requestPojo.getDiet().setIsBase(false);
		
		Integer id = setAddEditDiet(new DietEntity(), requestPojo.getDiet(), CrudOptionsEnum.SAVE);
		
		AddEditDietDataPojo responsePojo = new AddEditDietDataPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	@Override
	public AddEditDietDataPojo executeEditDiet(AddEditDietRequestPojo requestPojo) throws BusinessException {
		
		DietPojo dietPojo = requestPojo.getDiet();
		
		if (dietPojo == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgDietCustomDataNotFoundRequest());
		
		if (dietPojo.getIdRecipe() == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgDietIdIsNull());
		
		requestPojo.getDiet().setIsBase(false);
		
		DietEntity diet = (DietEntity) genericPersistance.findById(DietEntity.class, dietPojo.getIdRecipe());
		
		if (diet == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgDietIdNotFound(dietPojo.getIdRecipe()));
		
		if (Boolean.TRUE.equals(diet.getIsBase()))
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgDietIsDateBase(dietPojo.getIdRecipe()));
			
		Integer id = setAddEditDiet(diet, dietPojo, CrudOptionsEnum.UPDATE);
		
		AddEditDietDataPojo responsePojo = new AddEditDietDataPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public GetDietCustomDataPojo executeGetDietCustomInfo(GetDietCustomRequestPojo requestPojo) {
		
		DietEntity dietBase = dietRepository.getDietBase();
		DietEntity dietCustom = requestPojo.getId() != null ? (DietEntity) genericPersistance.findById(DietEntity.class, requestPojo.getId()) : new DietEntity();

		List<NutritionGoalEntity> nutritionGoals = genericPersistance.findAll(NutritionGoalEntity.class);
		NutritionGoalEntity nutritionGoal = nutritionGoals != null && !nutritionGoals.isEmpty() ? nutritionGoals.get(0) : null;
		
		if (requestPojo.getId() == null)
			dietCustom = dietUtil.generateDietZeros();
		
		DietEntityPojo dietBaseDataPojo = buildEntityToPojoUtil.generateDietPojo(null, dietBase);
		DietEntityPojo dietCustomDataPojo = buildEntityToPojoUtil.generateDietPojo(null, dietCustom);
		DietEntityPojo nutritionalGoalsDataPojo = (nutritionGoal != null) ? buildEntityToPojoUtil.generateNutritionalGoalPojo(null, nutritionGoal) : null;
		
		List<DietFoodResumePojo> dietFoodResumeEntityPojos = dietUtil.buildDietFoodsResume(dietBase.getDietFoods());
		
		DietDataPojo dietDataPojo = null;
		
		if (requestPojo.getId() != null) {
			
			RecipeEntityPojo recipeDietCustomEntityPojo = buildEntityToPojoUtil.generateRecipePojo(null, dietCustom.getRecipe());
			DietEntityPojo dietCustomResumePojo = buildEntityToPojoUtil.generateDietPojo(null, dietCustom);
			
			List<DietFoodResumePojo> dietFoodDietCustomResumeEntityPojos = dietUtil.buildDietFoodsResume(dietCustom.getDietFoods());
			
			dietDataPojo = new DietDataPojo();
			dietDataPojo.setRecipe(recipeDietCustomEntityPojo);
			dietDataPojo.setDiet(dietCustomResumePojo);
			dietDataPojo.setFoods(dietFoodDietCustomResumeEntityPojos);
		}
		
		GetDietCustomDataPojo responsePojo = new GetDietCustomDataPojo();
		responsePojo.setSubTotalDietBase(dietBaseDataPojo);
		responsePojo.setSubTotalDietCustom(dietCustomDataPojo);
		responsePojo.setNutritionalGoals(nutritionalGoalsDataPojo);
		responsePojo.setFoodsDietBase(dietFoodResumeEntityPojos);
		responsePojo.setDietCustom(dietDataPojo);
		
		return responsePojo;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public GetDietCustomDetailListDataPojo executeGetDietsCustomDetail(GetDietCustomDetailListRequestPojo requestPojo) {
		
		List<DietCustomDetailResumePojo> dietCustomDetailPojos = new ArrayList<>();
		
		DietEntity dietBase = dietRepository.getDietBase();
		List<DietEntity> dietCustomList = dietRepository.getDietCustomList();
		
		DietEntityPojo dietBaseDataPojo = buildEntityToPojoUtil.generateDietPojo(null, dietBase);
		
		for (DietEntity dietCustom: dietCustomList) {
			
			RecipeEntityPojo recipeDietCustomEntityPojo = buildEntityToPojoUtil.generateRecipePojo(null, dietCustom.getRecipe());
			
			List<DietFoodResumePojo> dietFoodDietCustomResumeEntityPojos = new ArrayList<>();
			
			for (DietFoodEntity dietFood: dietCustom.getDietFoods()) {
				
				DietFoodResumePojo dietFoodResumeEntityPojo = (DietFoodResumePojo) buildEntityToPojoUtil.generateDietFoodPojo(new DietFoodResumePojo(), dietFood, true);
				dietFoodResumeEntityPojo.setPortions(dietFood.getPortions());
				dietFoodResumeEntityPojo.setIdDietFood(dietFood.getId());
				
				dietFoodDietCustomResumeEntityPojos.add(dietFoodResumeEntityPojo);
			}
			
			
			DietEntityPojo dietCustomDataPojo = buildEntityToPojoUtil.generateDietPojo(null, dietCustom);
			
			DietEntityPojo totalDiet = new DietEntityPojo();
			totalDiet.setTotalCalories(dietCustomDataPojo.getTotalCalories().add(dietBaseDataPojo.getTotalCalories()));
			totalDiet.setTotalQuantityGrams(dietCustomDataPojo.getTotalQuantityGrams().add(dietBaseDataPojo.getTotalQuantityGrams()));
			totalDiet.setTotalCarbohydrates(dietCustomDataPojo.getTotalCarbohydrates().add(dietBaseDataPojo.getTotalCarbohydrates()));
			totalDiet.setTotalFat(dietCustomDataPojo.getTotalFat().add(dietBaseDataPojo.getTotalFat()));
			totalDiet.setTotalProteins(dietCustomDataPojo.getTotalProteins().add(dietBaseDataPojo.getTotalProteins()));
			
			DietCustomDetailResumePojo dietDataPojo = new DietCustomDetailResumePojo();
			dietDataPojo.setIdDietCustom(dietCustom.getIdRecipe());
			dietDataPojo.setRecipe(recipeDietCustomEntityPojo);
			dietDataPojo.setFoods(dietFoodDietCustomResumeEntityPojos);
			dietDataPojo.setSubTotalDietBase(dietBaseDataPojo);
			dietDataPojo.setSubTotalDietCustom(dietCustomDataPojo);
			dietDataPojo.setTotalDiet(totalDiet);
			
			dietCustomDetailPojos.add(dietDataPojo);
		}
		
		GetDietCustomDetailListDataPojo responsePojo = new GetDietCustomDetailListDataPojo();
		responsePojo.setDietCustomDetailList(dietCustomDetailPojos);
		
		return responsePojo;
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public GetDietCustomDetailDataPojo executeGetDietCustomDetail(GetDietCustomRequestPojo requestPojo) {
		
		DietEntity dietBase = dietRepository.getDietBase();
		DietEntity dietCustom = (DietEntity) genericPersistance.findById(DietEntity.class, requestPojo.getId());
		
		DietEntityPojo dietBaseDataPojo = buildEntityToPojoUtil.generateDietPojo(null, dietBase);
		RecipeEntityPojo recipeDietCustomEntityPojo = buildEntityToPojoUtil.generateRecipePojo(null, dietCustom.getRecipe());
		
		List<DietFoodResumePojo> dietFoodDietCustomResumeEntityPojos = new ArrayList<>();
		
		for (DietFoodEntity dietFood: dietCustom.getDietFoods()) {
			
			DietFoodResumePojo dietFoodResumeEntityPojo = (DietFoodResumePojo) buildEntityToPojoUtil.generateDietFoodPojo(new DietFoodResumePojo(), dietFood, true);
			dietFoodResumeEntityPojo.setIdDietFood(dietFood.getId());
			dietFoodResumeEntityPojo.setPortions(dietFood.getPortions());
			
			dietFoodDietCustomResumeEntityPojos.add(dietFoodResumeEntityPojo);
		}
			
			
		DietEntityPojo dietCustomDataPojo = buildEntityToPojoUtil.generateDietPojo(null, dietCustom);
		
		DietEntityPojo totalDiet = new DietEntityPojo();
		totalDiet.setTotalCalories(dietCustomDataPojo.getTotalCalories().add(dietBaseDataPojo.getTotalCalories()));
		totalDiet.setTotalCarbohydrates(dietCustomDataPojo.getTotalCarbohydrates().add(dietBaseDataPojo.getTotalCarbohydrates()));
		totalDiet.setTotalFat(dietCustomDataPojo.getTotalFat().add(dietBaseDataPojo.getTotalFat()));
		totalDiet.setTotalProteins(dietCustomDataPojo.getTotalProteins().add(dietBaseDataPojo.getTotalProteins()));
		totalDiet.setTotalQuantityGrams(dietCustomDataPojo.getTotalQuantityGrams().add(dietBaseDataPojo.getTotalQuantityGrams()));
		
		GetDietCustomDetailDataPojo responsePojo = new GetDietCustomDetailDataPojo();
		responsePojo.setIdDietCustom(dietCustom.getIdRecipe());
		responsePojo.setRecipe(recipeDietCustomEntityPojo);
		responsePojo.setFoods(dietFoodDietCustomResumeEntityPojos);
		responsePojo.setSubTotalDietBase(dietBaseDataPojo);
		responsePojo.setSubTotalDietCustom(dietCustomDataPojo);
		responsePojo.setTotalDiet(totalDiet);
		
		return responsePojo;
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public void executeDeleteDietCustom(DeleteDietCustomRequestPojo requestPojo) {
		
		DietEntity dietCustom = (DietEntity) genericPersistance.findById(DietEntity.class, requestPojo.getId());
		deleteDiet(dietCustom);
		
	}

}
