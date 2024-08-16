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
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietBaseDataPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.GetDietBaseRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.RegisterDietBaseRequestPojo;

@SuppressWarnings("unchecked")
class CrudDietBaseControllerTest extends ProjectIntegrationTest {
	
	@Autowired
	CrudDietBaseController crudDietBaseController;

	@Test
	void testRegisterDietBase() throws BusinessException {
		
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
		dietPojo.setIsBase(true);
		dietPojo.setFoods(foods);

		RegisterDietBaseRequestPojo requestPojo = new RegisterDietBaseRequestPojo();
		requestPojo.setDiet(dietPojo);
		
		ResponseEntity<GenericResponsePojo<AddEditDietDataPojo>> response = crudDietBaseController.registerDietBase(requestPojo);
		
		Assessment.assertResponseData(response);
		assertNotNull(response.getBody().getData().getId());
	}

	@Test
	void testGetDietBase() {

		GetDietBaseRequestPojo requestPojo = new GetDietBaseRequestPojo();
		
		ResponseEntity<GenericResponsePojo<GetDietBaseDataPojo>> response = crudDietBaseController.getDietBase(requestPojo);
		
		Assessment.assertResponseData(response);
		assertNotNull(response.getBody().getData().getRecipe());
	}

}
