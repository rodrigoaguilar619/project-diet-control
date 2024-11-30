package project.diet.control.modules.controller.food;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.pojo.rest.GenericResponsePojo;
import lib.base.backend.test.assessment.Assessment;
import project.diet.control.ProjectIntegrationTest;
import project.diet.control.app.beans.pojos.entity.FoodEntityPojo;
import project.diet.control.app.beans.pojos.petition.data.food.AddEditFoodDataPojo;
import project.diet.control.app.beans.pojos.petition.data.food.GetFoodDataPojo;
import project.diet.control.app.beans.pojos.petition.data.food.GetFoodListDataPojo;
import project.diet.control.app.beans.pojos.petition.request.food.AddEditFoodRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.food.AddEditFoodsRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.food.DeleteFoodRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.food.GetFoodRequestPojo;

@SuppressWarnings("unchecked")
class CrudFoodControllerTest extends ProjectIntegrationTest {
	
	@Autowired
	CrudFoodController crudFoodController;

	@Test
	void testAddFood() throws BusinessException {
		
		FoodEntityPojo foodEntityPojo = new FoodEntityPojo();
		foodEntityPojo.setCalories(new BigDecimal(5));
		foodEntityPojo.setCarbohydrates(new BigDecimal(6));
		foodEntityPojo.setFat(new BigDecimal(7));
		foodEntityPojo.setFatMono(new BigDecimal(8));
		foodEntityPojo.setFatPoli(new BigDecimal(9));
		foodEntityPojo.setFatSat(new BigDecimal(10));
		foodEntityPojo.setFatTrans(new BigDecimal(11));
		foodEntityPojo.setProteins(new BigDecimal(12));
		foodEntityPojo.setCholesterol(new BigDecimal(13));
		foodEntityPojo.setUnityGrams(new BigDecimal(120));
		foodEntityPojo.setQuantityGrams(new BigDecimal(110));
		foodEntityPojo.setDescription("Food test");

		AddEditFoodRequestPojo requestPojo = new AddEditFoodRequestPojo();
		requestPojo.setFood(foodEntityPojo);
		
		ResponseEntity<GenericResponsePojo<AddEditFoodDataPojo>> response = crudFoodController.addFood(requestPojo);
		
		Assessment.assertResponseData(response);
		assertNotNull(response.getBody().getData().getId());
	}

	@Test
	void testEditFood() throws BusinessException {

		FoodEntityPojo foodEntityPojo = new FoodEntityPojo();
		foodEntityPojo.setId(2);
		foodEntityPojo.setCalories(new BigDecimal(5));
		foodEntityPojo.setCarbohydrates(new BigDecimal(6));
		foodEntityPojo.setFat(new BigDecimal(7));
		foodEntityPojo.setFatMono(new BigDecimal(8));
		foodEntityPojo.setFatPoli(new BigDecimal(9));
		foodEntityPojo.setFatSat(new BigDecimal(10));
		foodEntityPojo.setFatTrans(new BigDecimal(11));
		foodEntityPojo.setProteins(new BigDecimal(12));
		foodEntityPojo.setCholesterol(new BigDecimal(13));
		foodEntityPojo.setUnityGrams(new BigDecimal(120));
		foodEntityPojo.setQuantityGrams(new BigDecimal(110));
		foodEntityPojo.setDescription("Food test");

		AddEditFoodRequestPojo requestPojo = new AddEditFoodRequestPojo();
		requestPojo.setFood(foodEntityPojo);
		
		ResponseEntity<GenericResponsePojo<AddEditFoodDataPojo>> response = crudFoodController.editFood(requestPojo);
		
		Assessment.assertResponseData(response);
		assertNotNull(response.getBody().getData().getId());
	}

	@Test
	void testGetFood() throws BusinessException {

		GetFoodRequestPojo requestPojo = new GetFoodRequestPojo();
		requestPojo.setId(2);
		
		ResponseEntity<GenericResponsePojo<GetFoodDataPojo>> response = crudFoodController.getFood(requestPojo);
		
		Assessment.assertResponseData(response);
		assertNotNull(response.getBody().getData().getFood());
	}

	@Test
	void testDeleteFood() throws BusinessException {

		DeleteFoodRequestPojo requestPojo = new DeleteFoodRequestPojo();
		requestPojo.setId(31);
		
		ResponseEntity<GenericResponsePojo<Void>> response = crudFoodController.deleteFood(requestPojo);
		
		Assessment.assertResponseData(response);
	}

	@Test
	void testAddFoodMultiple() {
		
		FoodEntityPojo foodEntityPojo1 = new FoodEntityPojo();;
		foodEntityPojo1.setCalories(new BigDecimal(5));
		foodEntityPojo1.setCarbohydrates(new BigDecimal(6));
		foodEntityPojo1.setFat(new BigDecimal(7));
		foodEntityPojo1.setFatMono(new BigDecimal(8));
		foodEntityPojo1.setFatPoli(new BigDecimal(9));
		foodEntityPojo1.setFatSat(new BigDecimal(10));
		foodEntityPojo1.setFatTrans(new BigDecimal(11));
		foodEntityPojo1.setProteins(new BigDecimal(12));
		foodEntityPojo1.setCholesterol(new BigDecimal(13));
		foodEntityPojo1.setUnityGrams(new BigDecimal(120));
		foodEntityPojo1.setQuantityGrams(new BigDecimal(110));
		foodEntityPojo1.setDescription("Food test");
		
		FoodEntityPojo foodEntityPojo2 = new FoodEntityPojo();;
		foodEntityPojo2.setCalories(new BigDecimal(5));
		foodEntityPojo2.setCarbohydrates(new BigDecimal(6));
		foodEntityPojo2.setFat(new BigDecimal(7));
		foodEntityPojo2.setFatMono(new BigDecimal(8));
		foodEntityPojo2.setFatPoli(new BigDecimal(9));
		foodEntityPojo2.setFatSat(new BigDecimal(10));
		foodEntityPojo2.setFatTrans(new BigDecimal(11));
		foodEntityPojo2.setProteins(new BigDecimal(12));
		foodEntityPojo2.setCholesterol(new BigDecimal(13));
		foodEntityPojo2.setUnityGrams(new BigDecimal(120));
		foodEntityPojo2.setQuantityGrams(new BigDecimal(110));
		foodEntityPojo2.setDescription("Food test 2");
		
		List<FoodEntityPojo> foods = new ArrayList<>(Arrays.asList(foodEntityPojo1, foodEntityPojo2));

		AddEditFoodsRequestPojo addEditFoodsRequestPojo = new AddEditFoodsRequestPojo();
		addEditFoodsRequestPojo.setFoods(foods);
		
		ResponseEntity<GenericResponsePojo<Void>> response = crudFoodController.addFoodMultiple(addEditFoodsRequestPojo);
		
		Assessment.assertResponseData(response);
	}

	@Test
	void testGetFoodsAll() {

		ResponseEntity<GenericResponsePojo<GetFoodListDataPojo>> response = crudFoodController.getFoodsAll();
		
		Assessment.assertResponseData(response);
		assertNotNull(response.getBody().getData().getFoods());
	}

}
