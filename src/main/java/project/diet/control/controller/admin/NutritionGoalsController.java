package project.diet.control.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lib.base.backend.pojo.catalog.CatalogRequestPojo;
import lib.base.backend.pojo.catalog.CatalogRespPojo;
import lib.base.backend.utils.RestUtil;
import project.diet.control.business.admin.NutritionGoalsBusiness;
import project.diet.control.pojos.request.admin.GetNutritionGoalRequestPojo;
import project.diet.control.pojos.request.admin.RegisterNutritionGoalRequestPojo;
import project.diet.control.pojos.response.admin.GetNutritionGoalRespPojo;
import project.diet.control.pojos.response.admin.RegisterNutritionGoalRespPojo;

@RestController
public class NutritionGoalsController {

	@Autowired
	NutritionGoalsBusiness nutritionGoalsBusiness;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/admin/nutritionGoals/register", consumes = "application/json", produces = "application/json")
	public ResponseEntity catalogGetAll(@RequestBody RegisterNutritionGoalRequestPojo requestPojo) throws Exception {
		
		RegisterNutritionGoalRespPojo reponsePojo = nutritionGoalsBusiness.executeRegisterNutritionGoal(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Nutrition goal registered");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/admin/nutritionGoals/get", consumes = "application/json", produces = "application/json")
	public ResponseEntity catalogGetAll(@RequestBody GetNutritionGoalRequestPojo requestPojo) throws Exception {
		
		GetNutritionGoalRespPojo reponsePojo = nutritionGoalsBusiness.executeGetNutritionGoal(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Nutrition goal getted");
	}
}
