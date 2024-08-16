package project.diet.control.modules.controller.admin;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import lib.base.backend.pojo.rest.GenericResponsePojo;
import lib.base.backend.test.assessment.Assessment;
import project.diet.control.ProjectIntegrationTest;
import project.diet.control.app.beans.pojos.entity.NutritionGoalEntityPojo;
import project.diet.control.app.beans.pojos.petition.data.admin.RegisterNutritionGoalDataPojo;
import project.diet.control.app.beans.pojos.petition.request.admin.GetNutritionGoalRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.admin.RegisterNutritionGoalRequestPojo;

@SuppressWarnings("unchecked")
class NutritionGoalsControllerTest extends ProjectIntegrationTest {

	@Autowired
	NutritionGoalsController nutritionGoalsController;
	
	@Test
	void testNutritionGoalsRegister() {
		
		NutritionGoalEntityPojo nutritionGoalEntityPojo = new NutritionGoalEntityPojo();
		nutritionGoalEntityPojo.setCalories(new BigDecimal(1000));
		nutritionGoalEntityPojo.setCarbohydrates(new BigDecimal(100));
		nutritionGoalEntityPojo.setFat(new BigDecimal(110));
		nutritionGoalEntityPojo.setProteins(new BigDecimal(120));
		nutritionGoalEntityPojo.setSodium(new BigDecimal(130));
		nutritionGoalEntityPojo.setCarbSugar(new BigDecimal(140));
		nutritionGoalEntityPojo.setFiber(new BigDecimal(150));
		nutritionGoalEntityPojo.setFatMono(new BigDecimal(160));
		nutritionGoalEntityPojo.setFatPoli(new BigDecimal(170));
		nutritionGoalEntityPojo.setFatSat(new BigDecimal(180));
		nutritionGoalEntityPojo.setFatTrans(new BigDecimal(190));
		
		
		RegisterNutritionGoalRequestPojo requestPojo = new RegisterNutritionGoalRequestPojo();
		requestPojo.setNutritionGoal(nutritionGoalEntityPojo);
		
		ResponseEntity<GenericResponsePojo<RegisterNutritionGoalDataPojo>> response = nutritionGoalsController.registerNutritionGoals(requestPojo);
		
		Assessment.assertResponseData(response);
		assertNotNull(response.getBody().getData().getId());
	}

	@Test
	void testGetNutritionGoal() {

		GetNutritionGoalRequestPojo requestPojo = new GetNutritionGoalRequestPojo();
		
		ResponseEntity<GenericResponsePojo<NutritionGoalEntityPojo>> response = nutritionGoalsController.getNutritionGoal(requestPojo);
		
		Assessment.assertResponseData(response);
		assertNotNull(response.getBody().getData());
	}

}
