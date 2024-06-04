package project.diet.control.modules.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lib.base.backend.utils.RestUtil;
import project.diet.control.app.beans.pojos.petition.data.admin.GetNutritionGoalDataPojo;
import project.diet.control.app.beans.pojos.petition.data.admin.RegisterNutritionGoalDataPojo;
import project.diet.control.app.beans.pojos.petition.request.admin.GetNutritionGoalRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.admin.RegisterNutritionGoalRequestPojo;
import project.diet.control.app.vo.catalogs.CatalogsUri;
import project.diet.control.modules.business.admin.NutritionGoalsBusiness;

@RestController
public class NutritionGoalsController {

	@Autowired
	NutritionGoalsBusiness nutritionGoalsBusiness;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = CatalogsUri.API_ADMIN_NUTRITION_GOALS_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity catalogGetAll(@RequestBody RegisterNutritionGoalRequestPojo requestPojo) {
		
		RegisterNutritionGoalDataPojo reponsePojo = nutritionGoalsBusiness.executeRegisterNutritionGoal(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Nutrition goal registered");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = CatalogsUri.API_ADMIN_NUTRITION_GOALS_GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity catalogGetAll(@RequestBody GetNutritionGoalRequestPojo requestPojo) {
		
		GetNutritionGoalDataPojo reponsePojo = nutritionGoalsBusiness.executeGetNutritionGoal(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Nutrition goal getted");
	}
}
