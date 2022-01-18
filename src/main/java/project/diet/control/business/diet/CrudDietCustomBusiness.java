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
import project.diet.control.pojos.diet.DietCustomResumePojo;
import project.diet.control.pojos.diet.DietDataPojo;
import project.diet.control.pojos.diet.DietFoodResumePojo;
import project.diet.control.pojos.diet.DietResumePojo;
import project.diet.control.pojos.diet.DietPojo;
import project.diet.control.pojos.entity.DietEntityPojo;
import project.diet.control.pojos.entity.RecipeEntityPojo;
import project.diet.control.pojos.request.diet.AddEditDietRequestPojo;
import project.diet.control.pojos.request.diet.GetDietCustomRequestPojo;
import project.diet.control.pojos.request.diet.RegisterDietBaseRequestPojo;
import project.diet.control.pojos.response.diet.AddEditDietRespPojo;
import project.diet.control.pojos.response.diet.GetDietBaseRespPojo;
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
		
		List<DietFoodResumePojo> dietFoodResumeEntityPojos = new ArrayList<DietFoodResumePojo>();
		
		for (DietFood dietFood: dietBase.getDietFoods()) {
			
			DietFoodResumePojo dietFoodResumeEntityPojo = (DietFoodResumePojo) buildEntityToPojoUtil.generateDietFoodPojo(new DietFoodResumePojo(), dietFood);
			dietFoodResumeEntityPojo.setIdDietFood(dietFood.getId());
			dietFoodResumeEntityPojo.setPortions(dietFood.getPortions());
			
			dietFoodResumeEntityPojos.add(dietFoodResumeEntityPojo);
		}
		
		DietDataPojo dietDataPojo = null;
		
		if (requestPojo.getId() != null) {
			
			RecipeEntityPojo recipeDietCustomEntityPojo = buildEntityToPojoUtil.generateRecipePojo(null, dietCustom.getRecipe());
			DietEntityPojo dietCustomResumePojo = buildEntityToPojoUtil.generateDietPojo(null, dietCustom);
			
			List<DietFoodResumePojo> dietFoodDietCustomResumeEntityPojos = new ArrayList<DietFoodResumePojo>();
			
			for (DietFood dietFood: dietCustom.getDietFoods()) {
				
				DietFoodResumePojo dietFoodResumeEntityPojo = (DietFoodResumePojo) buildEntityToPojoUtil.generateDietFoodPojo(new DietFoodResumePojo(), dietFood);
				dietFoodResumeEntityPojo.setIdDietFood(dietFood.getId());
				dietFoodResumeEntityPojo.setPortions(dietFood.getPortions());
				
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
		responsePojo.setFoodsDietBase(dietFoodResumeEntityPojos);
		responsePojo.setDietCustom(dietDataPojo);
		
		return responsePojo;
	}
}
