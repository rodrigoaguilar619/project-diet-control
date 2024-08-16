package project.diet.control.modules.controller.diet;

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
import project.diet.control.app.beans.pojos.diet.DietPojo;
import project.diet.control.app.beans.pojos.entity.DietFoodEntityPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.AddEditDietDataPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietCustomDataPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietCustomDetailDataPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietCustomDetailListDataPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietCustomListDataPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.AddEditDietRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.DeleteDietCustomRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.GetDietCustomDetailListRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.GetDietCustomListRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.GetDietCustomRequestPojo;

@SuppressWarnings("unchecked")
class CrudDietCustomControllerTest extends ProjectIntegrationTest {
	
	@Autowired
	CrudDietCustomController crudDietCustomController;

	@Test
	void testAddFood() throws BusinessException {
		
		DietFoodEntityPojo dietFoodEntityPojo1 = new DietFoodEntityPojo();
		dietFoodEntityPojo1.setId(1);
		dietFoodEntityPojo1.setPortions(new BigDecimal(2));
		dietFoodEntityPojo1.setUnities(new BigDecimal(2));
		
		DietFoodEntityPojo dietFoodEntityPojo2 = new DietFoodEntityPojo();
		dietFoodEntityPojo2.setId(2);
		dietFoodEntityPojo2.setPortions(new BigDecimal(2));
		dietFoodEntityPojo2.setUnities(new BigDecimal(2));
		
		List<DietFoodEntityPojo> foods = new ArrayList<>(Arrays.asList(dietFoodEntityPojo1, dietFoodEntityPojo2));
		
		DietPojo dietPojo = new DietPojo();
		dietPojo.setIdRecipe(14);
		dietPojo.setIsBase(false);
		dietPojo.setFoods(foods);

		AddEditDietRequestPojo requestPojo = new AddEditDietRequestPojo();
		requestPojo.setDiet(dietPojo);
		
		ResponseEntity<GenericResponsePojo<AddEditDietDataPojo>> response = crudDietCustomController.addDietCustom(requestPojo);
		
		Assessment.assertResponseData(response);
		assertNotNull(response.getBody().getData().getId());
	}
	
	@Test
	void testAddFood_ExceptionDietBaseExists() throws BusinessException {
		
		DietFoodEntityPojo dietFoodEntityPojo1 = new DietFoodEntityPojo();
		dietFoodEntityPojo1.setId(1);
		dietFoodEntityPojo1.setPortions(new BigDecimal(2));
		dietFoodEntityPojo1.setUnities(new BigDecimal(2));
		
		DietFoodEntityPojo dietFoodEntityPojo2 = new DietFoodEntityPojo();
		dietFoodEntityPojo2.setId(2);
		dietFoodEntityPojo2.setPortions(new BigDecimal(2));
		dietFoodEntityPojo2.setUnities(new BigDecimal(2));
		
		List<DietFoodEntityPojo> foods = new ArrayList<>(Arrays.asList(dietFoodEntityPojo1, dietFoodEntityPojo2));
		
		DietPojo dietPojo = new DietPojo();
		dietPojo.setIdRecipe(1);
		dietPojo.setIsBase(false);
		dietPojo.setFoods(foods);

		AddEditDietRequestPojo requestPojo = new AddEditDietRequestPojo();
		requestPojo.setDiet(dietPojo);
		
		BusinessException exception = assertThrows(BusinessException.class, () -> {
			crudDietCustomController.addDietCustom(requestPojo);
		});
		
		assertEquals(exception.getMessage(), "Diet custom already exist id: 1 title: Diet Base"); //TODO: change message from static param
	}

	@Test
	void testEditFood() throws BusinessException {

		DietFoodEntityPojo dietFoodEntityPojo1 = new DietFoodEntityPojo();
		dietFoodEntityPojo1.setId(1);
		dietFoodEntityPojo1.setPortions(new BigDecimal(2));
		dietFoodEntityPojo1.setUnities(new BigDecimal(2));
		
		DietFoodEntityPojo dietFoodEntityPojo2 = new DietFoodEntityPojo();
		dietFoodEntityPojo2.setId(2);
		dietFoodEntityPojo2.setPortions(new BigDecimal(2));
		dietFoodEntityPojo2.setUnities(new BigDecimal(2));
		
		List<DietFoodEntityPojo> foods = new ArrayList<>(Arrays.asList(dietFoodEntityPojo1, dietFoodEntityPojo2));
		
		DietPojo dietPojo = new DietPojo();
		dietPojo.setIdRecipe(2);
		dietPojo.setIsBase(false);
		dietPojo.setFoods(foods);

		AddEditDietRequestPojo requestPojo = new AddEditDietRequestPojo();
		requestPojo.setDiet(dietPojo);
		
		ResponseEntity<GenericResponsePojo<AddEditDietDataPojo>> response = crudDietCustomController.editDietCustom(requestPojo);
		
		Assessment.assertResponseData(response);
		assertNotNull(response.getBody().getData().getId());
	}

	@Test
	void testGetDietCustomList() {

		GetDietCustomListRequestPojo requestPojo = new GetDietCustomListRequestPojo();

		ResponseEntity<GenericResponsePojo<GetDietCustomListDataPojo>> response = crudDietCustomController.getDietCustomList(requestPojo);
		
		Assessment.assertResponseData(response);
		Assessment.assertDataList(response.getBody().getData().getDiets());
	}

	@Test
	void testGetDietCustom() {

		GetDietCustomRequestPojo requestPojo = new GetDietCustomRequestPojo();
		requestPojo.setId(2);
		
		ResponseEntity<GenericResponsePojo<GetDietCustomDataPojo>> response = crudDietCustomController.getDietCustom(requestPojo);
		
		Assessment.assertResponseData(response);
		assertNotNull(response.getBody().getData().getDietCustom());
	}

	@Test
	void testGetDietsCustomDetailList() {

		GetDietCustomDetailListRequestPojo requestPojo = new GetDietCustomDetailListRequestPojo();
		
		ResponseEntity<GenericResponsePojo<GetDietCustomDetailListDataPojo>> response = crudDietCustomController.getDietsCustomDetailList(requestPojo);
		
		Assessment.assertResponseData(response);
		Assessment.assertDataList(response.getBody().getData().getDietCustomDetailList());
	}

	@Test
	void testGetDietCustomDetail() {

		GetDietCustomRequestPojo requestPojo = new GetDietCustomRequestPojo();
		requestPojo.setId(2);
		
		ResponseEntity<GenericResponsePojo<GetDietCustomDetailDataPojo>> response = crudDietCustomController.getDietCustomDetail(requestPojo);
		
		Assessment.assertResponseData(response);
		assertNotNull(response.getBody().getData().getRecipe());
	}

	@Test
	void testDeleteDietCustom() {

		DeleteDietCustomRequestPojo requestPojo = new DeleteDietCustomRequestPojo();
		requestPojo.setId(2);
		
		ResponseEntity<GenericResponsePojo<Void>> response = crudDietCustomController.deleteDietCustom(requestPojo);
		
		Assessment.assertResponseData(response);
	}

}
