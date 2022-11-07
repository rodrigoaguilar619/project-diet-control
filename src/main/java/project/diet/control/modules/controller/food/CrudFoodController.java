package project.diet.control.modules.controller.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.utils.RestUtil;
import project.diet.control.app.beans.pojos.petition.data.food.AddEditFoodDataPojo;
import project.diet.control.app.beans.pojos.petition.data.food.GetFoodDataPojo;
import project.diet.control.app.beans.pojos.petition.data.food.GetFoodListDataPojo;
import project.diet.control.app.beans.pojos.petition.request.food.AddEditFoodRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.food.AddEditFoodsRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.food.DeleteFoodRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.food.GetFoodRequestPojo;
import project.diet.control.modules.business.food.CrudFoodBusiness;

@RestController
public class CrudFoodController {

	@Autowired
	CrudFoodBusiness crudFoodBusiness;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/food/add", consumes = "application/json", produces = "application/json")
	public ResponseEntity addFood(@RequestBody AddEditFoodRequestPojo requestPojo) throws BusinessException {
		
		AddEditFoodDataPojo responsePojo = crudFoodBusiness.executeAddFood(requestPojo);
		return new RestUtil().buildResponseSuccess(responsePojo, "food added");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/food/edit", consumes = "application/json", produces = "application/json")
	public ResponseEntity editFood(@RequestBody AddEditFoodRequestPojo requestPojo) throws BusinessException {
		
		AddEditFoodDataPojo responsePojo = crudFoodBusiness.executeEditFood(requestPojo);
		return new RestUtil().buildResponseSuccess(responsePojo, "food edited");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/food/get", consumes = "application/json", produces = "application/json")
	public ResponseEntity getFood(@RequestBody GetFoodRequestPojo requestPojo) throws BusinessException {
		
		GetFoodDataPojo responsePojo = crudFoodBusiness.executeGetFood(requestPojo);
		return new RestUtil().buildResponseSuccess(responsePojo, "food getted");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/food/delete", consumes = "application/json", produces = "application/json")
	public ResponseEntity deleteFood(@RequestBody DeleteFoodRequestPojo requestPojo) throws BusinessException {
		
		crudFoodBusiness.executeDeleteFood(requestPojo);
		return new RestUtil().buildResponseSuccess(null, "food deleted");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/food/addMultiple", consumes = "application/json", produces = "application/json")
	public ResponseEntity addFoodMultiple(@RequestBody AddEditFoodsRequestPojo addEditFoodsRequestPojo) {
		
		crudFoodBusiness.executeAddFoods(addEditFoodsRequestPojo);
		return new RestUtil().buildResponseSuccess(null, "list of food added");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/food/getAll", consumes = "application/json", produces = "application/json")
	public ResponseEntity getFoodsAll() {
		
		GetFoodListDataPojo dataPojo = crudFoodBusiness.executeGetFoods();
		return new RestUtil().buildResponseSuccess(dataPojo, "list of food gotten");
	}
}
