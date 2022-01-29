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
import project.diet.control.beans.entity.NutritionGoal;
import project.diet.control.pojos.diet.DietCustomDetailResumePojo;
import project.diet.control.pojos.diet.DietCustomResumePojo;
import project.diet.control.pojos.diet.DietDataPojo;
import project.diet.control.pojos.diet.DietFoodResumePojo;
import project.diet.control.pojos.diet.DietResumePojo;
import project.diet.control.pojos.diet.DietPojo;
import project.diet.control.pojos.entity.DietEntityPojo;
import project.diet.control.pojos.entity.RecipeEntityPojo;
import project.diet.control.pojos.request.diet.AddEditDietRequestPojo;
import project.diet.control.pojos.request.diet.GetDietCustomDetailListRequestPojo;
import project.diet.control.pojos.request.diet.GetDietCustomRequestPojo;
import project.diet.control.pojos.request.diet.RegisterDietBaseRequestPojo;
import project.diet.control.pojos.response.diet.AddEditDietRespPojo;
import project.diet.control.pojos.response.diet.GetDietBaseRespPojo;
import project.diet.control.pojos.response.diet.GetDietCustomDetailListRespPojo;
import project.diet.control.pojos.response.diet.GetDietCustomDetailRespPojo;
import project.diet.control.pojos.response.diet.GetDietCustomListRespPojo;
import project.diet.control.pojos.response.diet.GetDietCustomRespPojo;
import project.diet.control.repository.DietRepositoryImpl;

@Component
public class CrudDietCustomBusiness extends CrudDietBusiness {
	
	@Autowired
	DietRepositoryImpl dietRepository;
	
	@Transactional
	public AddEditDietRespPojo executeRegisterDietBase(RegisterDietBaseRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getDiet() == null)
			throw new BusinessException("Diet data not found on request");
		
		requestPojo.getDiet().setIsBase(true);
		
		Diet dietBase = dietRepository.getDietBase();
		
		Integer id = setAddEditDiet(dietBase, requestPojo.getDiet(), dietBase == null ? CrudOptionsEnum.SAVE : CrudOptionsEnum.UPDATE);
		
		AddEditDietRespPojo responsePojo = new AddEditDietRespPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@Transactional
	public GetDietCustomListRespPojo executeGetDietCustomList() {
		
		List<Diet> dietBases = dietRepository.getDietCustomList();
		
		List<DietResumePojo> dietResumePojos = new ArrayList<DietResumePojo>(); 
		
		for(Diet diet: dietBases) {
			DietResumePojo dietResumePojo = (DietResumePojo) buildEntityToPojoUtil.generateDietResumePojo(null, diet);
			
			dietResumePojos.add(dietResumePojo);
		}
		
		GetDietCustomListRespPojo responsePojo = new GetDietCustomListRespPojo();
		responsePojo.setDiets(dietResumePojos);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public AddEditDietRespPojo executeAddDiet(AddEditDietRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getDiet() == null)
			throw new BusinessException("Diet custom data not found on request");
		
		Diet diet = (Diet) genericCustomPersistance.findById(Diet.class, requestPojo.getDiet().getIdRecipe());
		
		if (diet != null)
			throw new BusinessException("Diet custom already exist id: " + diet.getIdRecipe() + " title: " + diet.getRecipe().getTitle());
		
		requestPojo.getDiet().setIsBase(false);
		
		Integer id = setAddEditDiet(new Diet(), requestPojo.getDiet(), CrudOptionsEnum.SAVE);
		
		AddEditDietRespPojo responsePojo = new AddEditDietRespPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public AddEditDietRespPojo executeEditDiet(AddEditDietRequestPojo requestPojo) throws BusinessException {
		
		DietPojo dietPojo = requestPojo.getDiet();
		
		if (dietPojo == null)
			throw new BusinessException("Diet custom data not found on request");
		
		if (dietPojo.getIdRecipe() == null)
			throw new BusinessException("Diet id is null");
		
		requestPojo.getDiet().setIsBase(false);
		
		Diet diet = (Diet) genericCustomPersistance.findById(Diet.class, dietPojo.getIdRecipe());
		
		if (diet == null)
			throw new BusinessException("Diet id: " + dietPojo.getIdRecipe() + " not found");
		
		if (diet.getIsBase() == true)
			throw new BusinessException("Diet id: " + dietPojo.getIdRecipe() + " is a base diet, can be edited as custom");
			
		Integer id = setAddEditDiet(diet, dietPojo, CrudOptionsEnum.UPDATE);
		
		AddEditDietRespPojo responsePojo = new AddEditDietRespPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public GetDietCustomRespPojo executeGetDietCustomInfo(GetDietCustomRequestPojo requestPojo) throws BusinessException {
		
		Diet dietBase = dietRepository.getDietBase();
		Diet dietCustom = requestPojo.getId() != null ? (Diet) genericCustomPersistance.findById(Diet.class, requestPojo.getId()) : new Diet();

		List<NutritionGoal> nutritionGoals = genericCustomPersistance.findAll(NutritionGoal.class);
		NutritionGoal nutritionGoal = nutritionGoals != null && nutritionGoals.size() > 0 ? nutritionGoals.get(0) : null;
		
		if (requestPojo.getId() == null) {
			
			dietCustom = new Diet();
			dietCustom.setIsBase(false);
			dietCustom.setTotalCalories(new BigDecimal(0.0));
			dietCustom.setTotalCarbohydrates(new BigDecimal(0.0));
			dietCustom.setTotalFat(new BigDecimal(0.0));
			dietCustom.setTotalProteins(new BigDecimal(0.0));
			dietCustom.setTotalQuantityGrams(new BigDecimal(0.0));
		}
		
		DietEntityPojo dietBaseDataPojo = buildEntityToPojoUtil.generateDietPojo(null, dietBase);
		DietEntityPojo dietCustomDataPojo = buildEntityToPojoUtil.generateDietPojo(null, dietCustom);
		DietEntityPojo nutritionalGoalsDataPojo = null;
		
		if (nutritionGoal != null) {
			nutritionalGoalsDataPojo = new DietEntityPojo();
			nutritionalGoalsDataPojo.setTotalCalories(nutritionGoal.getCalories());
			nutritionalGoalsDataPojo.setTotalCarbohydrates(nutritionGoal.getCarbohydrates());
			nutritionalGoalsDataPojo.setTotalFat(nutritionGoal.getFat());
			nutritionalGoalsDataPojo.setTotalProteins(nutritionGoal.getProteins());
		}
		
		List<DietFoodResumePojo> dietFoodResumeEntityPojos = new ArrayList<DietFoodResumePojo>();
		
		for (DietFood dietFood: dietBase.getDietFoods()) {
			
			DietFoodResumePojo dietFoodResumeEntityPojo = (DietFoodResumePojo) buildEntityToPojoUtil.generateDietFoodPojo(new DietFoodResumePojo(), dietFood, true);
			dietFoodResumeEntityPojo.setIdDietFood(dietFood.getId());
			dietFoodResumeEntityPojo.setPortions(dietFood.getPortions());
			dietFoodResumeEntityPojo.setUnities(dietFood.getUnities() != null ? dietFood.getUnities() : new BigDecimal(0.0));
			
			dietFoodResumeEntityPojos.add(dietFoodResumeEntityPojo);
		}
		
		DietDataPojo dietDataPojo = null;
		
		if (requestPojo.getId() != null) {
			
			RecipeEntityPojo recipeDietCustomEntityPojo = buildEntityToPojoUtil.generateRecipePojo(null, dietCustom.getRecipe());
			DietEntityPojo dietCustomResumePojo = buildEntityToPojoUtil.generateDietPojo(null, dietCustom);
			
			List<DietFoodResumePojo> dietFoodDietCustomResumeEntityPojos = new ArrayList<DietFoodResumePojo>();
			
			for (DietFood dietFood: dietCustom.getDietFoods()) {
				
				DietFoodResumePojo dietFoodResumeEntityPojo = (DietFoodResumePojo) buildEntityToPojoUtil.generateDietFoodPojo(new DietFoodResumePojo(), dietFood, true);
				dietFoodResumeEntityPojo.setIdDietFood(dietFood.getId());
				dietFoodResumeEntityPojo.setPortions(dietFood.getPortions());
				dietFoodResumeEntityPojo.setUnities(dietFood.getUnities() != null ? dietFood.getUnities() : new BigDecimal(0.0));
				
				dietFoodDietCustomResumeEntityPojos.add(dietFoodResumeEntityPojo);
			}
			
			dietDataPojo = new DietDataPojo();
			dietDataPojo.setRecipe(recipeDietCustomEntityPojo);
			dietDataPojo.setDiet(dietCustomResumePojo);
			dietDataPojo.setFoods(dietFoodDietCustomResumeEntityPojos);
		}
		
		GetDietCustomRespPojo responsePojo = new GetDietCustomRespPojo();
		responsePojo.setSubTotalDietBase(dietBaseDataPojo);
		responsePojo.setSubTotalDietCustom(dietCustomDataPojo);
		responsePojo.setNutritionalGoals(nutritionalGoalsDataPojo);
		responsePojo.setFoodsDietBase(dietFoodResumeEntityPojos);
		responsePojo.setDietCustom(dietDataPojo);
		
		return responsePojo;
	}
	
	@Transactional
	public GetDietCustomDetailListRespPojo executeGetDietsCustomDetail(GetDietCustomDetailListRequestPojo requestPojo) {
		
		List<DietCustomDetailResumePojo> dietCustomDetailPojos = new ArrayList<DietCustomDetailResumePojo>();
		
		Diet dietBase = dietRepository.getDietBase();
		List<Diet> dietCustomList = dietRepository.getDietCustomList();
		
		DietEntityPojo dietBaseDataPojo = buildEntityToPojoUtil.generateDietPojo(null, dietBase);
		
		for (Diet dietCustom: dietCustomList) {
			
			RecipeEntityPojo recipeDietCustomEntityPojo = buildEntityToPojoUtil.generateRecipePojo(null, dietCustom.getRecipe());
			DietEntityPojo dietCustomResumePojo = buildEntityToPojoUtil.generateDietPojo(null, dietCustom);
			
			List<DietFoodResumePojo> dietFoodDietCustomResumeEntityPojos = new ArrayList<DietFoodResumePojo>();
			
			for (DietFood dietFood: dietCustom.getDietFoods()) {
				
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
			
			DietCustomDetailResumePojo dietDataPojo = new DietCustomDetailResumePojo();
			dietDataPojo.setIdDietCustom(dietCustom.getIdRecipe());
			dietDataPojo.setRecipe(recipeDietCustomEntityPojo);
			dietDataPojo.setFoods(dietFoodDietCustomResumeEntityPojos);
			dietDataPojo.setSubTotalDietBase(dietBaseDataPojo);
			dietDataPojo.setSubTotalDietCustom(dietCustomDataPojo);
			dietDataPojo.setTotalDiet(totalDiet);
			
			dietCustomDetailPojos.add(dietDataPojo);
		}
		
		GetDietCustomDetailListRespPojo responsePojo = new GetDietCustomDetailListRespPojo();
		responsePojo.setDietCustomDetailList(dietCustomDetailPojos);
		
		return responsePojo;
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public GetDietCustomDetailRespPojo executeGetDietCustomDetail(GetDietCustomRequestPojo requestPojo) {
		
		Diet dietBase = dietRepository.getDietBase();
		Diet dietCustom = (Diet) genericCustomPersistance.findById(Diet.class, requestPojo.getId());
		
		DietEntityPojo dietBaseDataPojo = buildEntityToPojoUtil.generateDietPojo(null, dietBase);
		RecipeEntityPojo recipeDietCustomEntityPojo = buildEntityToPojoUtil.generateRecipePojo(null, dietCustom.getRecipe());
		DietEntityPojo dietCustomResumePojo = buildEntityToPojoUtil.generateDietPojo(null, dietCustom);
		
		List<DietFoodResumePojo> dietFoodDietCustomResumeEntityPojos = new ArrayList<DietFoodResumePojo>();
		
		for (DietFood dietFood: dietCustom.getDietFoods()) {
			
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
		
		GetDietCustomDetailRespPojo responsePojo = new GetDietCustomDetailRespPojo();
		responsePojo.setIdDietCustom(dietCustom.getIdRecipe());
		responsePojo.setRecipe(recipeDietCustomEntityPojo);
		responsePojo.setFoods(dietFoodDietCustomResumeEntityPojos);
		responsePojo.setSubTotalDietBase(dietBaseDataPojo);
		responsePojo.setSubTotalDietCustom(dietCustomDataPojo);
		responsePojo.setTotalDiet(totalDiet);
		
		return responsePojo;
		
	}
}
