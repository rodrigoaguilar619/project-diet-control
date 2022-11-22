package project.diet.control.modules.business.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.enumerators.CrudOptionsEnum;
import lib.base.backend.persistance.GenericPersistence;
import project.diet.control.app.beans.entity.NutritionGoal;
import project.diet.control.app.beans.pojos.entity.NutritionGoalEntityPojo;
import project.diet.control.app.beans.pojos.petition.data.admin.GetNutritionGoalDataPojo;
import project.diet.control.app.beans.pojos.petition.data.admin.RegisterNutritionGoalDataPojo;
import project.diet.control.app.beans.pojos.petition.request.admin.GetNutritionGoalRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.admin.RegisterNutritionGoalRequestPojo;
import project.diet.control.app.util.BuildEntityToPojoUtil;
import project.diet.control.app.util.BuildPojoToEntityUtil;

@Component
public class NutritionGoalsBusiness {
	
	@SuppressWarnings("rawtypes")
	@Autowired
	GenericPersistence genericCustomPersistance;
	
	@Autowired
	BuildPojoToEntityUtil buildPojoToEntityUtil;
	
	@Autowired
	BuildEntityToPojoUtil buildEntityToPojoUtil;

	@SuppressWarnings("unchecked")
	public Integer setAddEditNutritionGoal(NutritionGoal nutritionGoalEntity, NutritionGoalEntityPojo nutritionGoalEntityPojo, CrudOptionsEnum crudOptionsEnum) {
		
		nutritionGoalEntity = buildPojoToEntityUtil.generateNutritionGoalEntity(nutritionGoalEntity, nutritionGoalEntityPojo);
		
		if (crudOptionsEnum.getId() == CrudOptionsEnum.SAVE.getId()) {
			genericCustomPersistance.save(nutritionGoalEntity);
		}
		else if (crudOptionsEnum.getId() == CrudOptionsEnum.UPDATE.getId()) {
			genericCustomPersistance.update(nutritionGoalEntity);
		}
		
		return nutritionGoalEntity.getId();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public RegisterNutritionGoalDataPojo executeRegisterNutritionGoal(RegisterNutritionGoalRequestPojo requestPojo) {
		
		List<NutritionGoal> nutritionGoals = genericCustomPersistance.findAll(NutritionGoal.class);
		NutritionGoal nutritionGoal = nutritionGoals != null && !nutritionGoals.isEmpty() ? nutritionGoals.get(0) : null;
			
		Integer id = setAddEditNutritionGoal(nutritionGoal, requestPojo.getNutritionGoal(), nutritionGoal == null ? CrudOptionsEnum.SAVE : CrudOptionsEnum.UPDATE);
		
		RegisterNutritionGoalDataPojo responsePojo = new RegisterNutritionGoalDataPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public GetNutritionGoalDataPojo executeGetNutritionGoal(GetNutritionGoalRequestPojo requestPojo) {
		
		List<NutritionGoal> nutritionGoals = genericCustomPersistance.findAll(NutritionGoal.class);
		NutritionGoal nutritionGoal = nutritionGoals != null && !nutritionGoals.isEmpty() ? nutritionGoals.get(0) : null;
		
		NutritionGoalEntityPojo nutritionGoalEntityPojo = nutritionGoal != null ? buildEntityToPojoUtil.generateNutritionGoalEntityPojo(null, nutritionGoal): null;
		
		GetNutritionGoalDataPojo responsePojo = new GetNutritionGoalDataPojo();
		responsePojo.setNutritionGoal(nutritionGoalEntityPojo);
		
		return responsePojo;
	}
}
