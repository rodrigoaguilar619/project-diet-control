package project.diet.control.business.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.persistance.GenericPersistence;
import lib.base.backend.web.enumeratos.CrudOptionsEnum;
import project.diet.control.beans.entity.NutritionGoal;
import project.diet.control.pojos.entity.NutritionGoalEntityPojo;
import project.diet.control.pojos.request.admin.GetNutritionGoalRequestPojo;
import project.diet.control.pojos.request.admin.RegisterNutritionGoalRequestPojo;
import project.diet.control.pojos.response.admin.GetNutritionGoalRespPojo;
import project.diet.control.pojos.response.admin.RegisterNutritionGoalRespPojo;
import project.diet.control.util.BuildEntityToPojoUtil;
import project.diet.control.util.BuildPojoToEntityUtil;

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
	@Transactional
	public RegisterNutritionGoalRespPojo executeRegisterNutritionGoal(RegisterNutritionGoalRequestPojo requestPojo) throws BusinessException {
		
		List<NutritionGoal> nutritionGoals = genericCustomPersistance.findAll(NutritionGoal.class);
		NutritionGoal nutritionGoal = nutritionGoals != null && nutritionGoals.size() > 0 ? nutritionGoals.get(0) : null;
			
		Integer id = setAddEditNutritionGoal(nutritionGoal, requestPojo.getNutritionGoal(), nutritionGoal == null ? CrudOptionsEnum.SAVE : CrudOptionsEnum.UPDATE);
		
		RegisterNutritionGoalRespPojo responsePojo = new RegisterNutritionGoalRespPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public GetNutritionGoalRespPojo executeGetNutritionGoal(GetNutritionGoalRequestPojo requestPojo) throws BusinessException {
		
		List<NutritionGoal> nutritionGoals = genericCustomPersistance.findAll(NutritionGoal.class);
		NutritionGoal nutritionGoal = nutritionGoals != null && nutritionGoals.size() > 0 ? nutritionGoals.get(0) : null;
		
		NutritionGoalEntityPojo nutritionGoalEntityPojo = nutritionGoal != null ? buildEntityToPojoUtil.generateNutritionGoalEntityPojo(null, nutritionGoal): null;
		
		GetNutritionGoalRespPojo responsePojo = new GetNutritionGoalRespPojo();
		responsePojo.setNutritionGoal(nutritionGoalEntityPojo);
		
		return responsePojo;
	}
}
