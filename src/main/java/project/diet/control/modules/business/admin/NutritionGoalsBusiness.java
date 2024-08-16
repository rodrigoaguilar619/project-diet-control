package project.diet.control.modules.business.admin;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.enumerators.CrudOptionsEnum;
import lib.base.backend.persistance.GenericPersistence;
import lombok.RequiredArgsConstructor;
import project.diet.control.app.beans.entity.NutritionGoalEntity;
import project.diet.control.app.beans.pojos.entity.NutritionGoalEntityPojo;
import project.diet.control.app.beans.pojos.petition.data.admin.GetNutritionGoalDataPojo;
import project.diet.control.app.beans.pojos.petition.data.admin.RegisterNutritionGoalDataPojo;
import project.diet.control.app.beans.pojos.petition.request.admin.GetNutritionGoalRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.admin.RegisterNutritionGoalRequestPojo;
import project.diet.control.modules.business.MainBusiness;

@RequiredArgsConstructor
@Component
public class NutritionGoalsBusiness extends MainBusiness {
	
	@SuppressWarnings("rawtypes")
	private final GenericPersistence genericPersistance;

	@SuppressWarnings("unchecked")
	public Integer setAddEditNutritionGoal(NutritionGoalEntity nutritionGoalEntity, NutritionGoalEntityPojo nutritionGoalEntityPojo, CrudOptionsEnum crudOptionsEnum) {
		
		nutritionGoalEntity = buildPojoToEntityUtil.generateNutritionGoalEntity(nutritionGoalEntity, nutritionGoalEntityPojo);
		
		if (crudOptionsEnum.getId() == CrudOptionsEnum.SAVE.getId()) {
			genericPersistance.save(nutritionGoalEntity);
		}
		else if (crudOptionsEnum.getId() == CrudOptionsEnum.UPDATE.getId()) {
			genericPersistance.update(nutritionGoalEntity);
		}
		
		return nutritionGoalEntity.getId();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public RegisterNutritionGoalDataPojo executeRegisterNutritionGoal(RegisterNutritionGoalRequestPojo requestPojo) {
		
		List<NutritionGoalEntity> nutritionGoals = genericPersistance.findAll(NutritionGoalEntity.class);
		NutritionGoalEntity nutritionGoal = nutritionGoals != null && !nutritionGoals.isEmpty() ? nutritionGoals.get(0) : null;
			
		Integer id = setAddEditNutritionGoal(nutritionGoal, requestPojo.getNutritionGoal(), nutritionGoal == null ? CrudOptionsEnum.SAVE : CrudOptionsEnum.UPDATE);
		
		RegisterNutritionGoalDataPojo responsePojo = new RegisterNutritionGoalDataPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public GetNutritionGoalDataPojo executeGetNutritionGoal(GetNutritionGoalRequestPojo requestPojo) {
		
		List<NutritionGoalEntity> nutritionGoals = genericPersistance.findAll(NutritionGoalEntity.class);
		NutritionGoalEntity nutritionGoal = nutritionGoals != null && !nutritionGoals.isEmpty() ? nutritionGoals.get(0) : null;
		
		NutritionGoalEntityPojo nutritionGoalEntityPojo = nutritionGoal != null ? buildEntityToPojoUtil.generateNutritionGoalEntityPojo(null, nutritionGoal): null;
		
		GetNutritionGoalDataPojo responsePojo = new GetNutritionGoalDataPojo();
		responsePojo.setNutritionGoal(nutritionGoalEntityPojo);
		
		return responsePojo;
	}
}
