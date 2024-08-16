package project.diet.control.modules.controller.recipe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.pojo.rest.GenericResponsePojo;
import lib.base.backend.test.assessment.Assessment;
import project.diet.control.ProjectIntegrationTest;
import project.diet.control.app.beans.pojos.entity.RecipeEntityPojo;
import project.diet.control.app.beans.pojos.petition.data.recipe.AddEditRecipeDataPojo;
import project.diet.control.app.beans.pojos.petition.data.recipe.GetRecipeDataPojo;
import project.diet.control.app.beans.pojos.petition.request.recipe.AddEditRecipeRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.recipe.DeleteRecipeRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.recipe.GetRecipeRequestPojo;

@SuppressWarnings("unchecked")
class CrudRecipeControllerTest extends ProjectIntegrationTest {
	
	@Autowired
	CrudRecipeController crudRecipeController;

	@Test
	void testAddRecipe() throws BusinessException {
		
		RecipeEntityPojo recipeEntityPojo = new RecipeEntityPojo();
		recipeEntityPojo.setInstructions("Instructions test");
		recipeEntityPojo.setTitle("Title test");

		AddEditRecipeRequestPojo requestPojo = new AddEditRecipeRequestPojo();
		requestPojo.setRecipe(recipeEntityPojo);
		
		ResponseEntity<GenericResponsePojo<AddEditRecipeDataPojo>> response = crudRecipeController.addRecipe(requestPojo);
		
		Assessment.assertResponseData(response);
		assertNotNull(response.getBody().getData().getId());
	}

	@Test
	void testEditRecipe() throws BusinessException {

		RecipeEntityPojo recipeEntityPojo = new RecipeEntityPojo();
		recipeEntityPojo.setInstructions("Instructions test");
		recipeEntityPojo.setTitle("Title test");
		recipeEntityPojo.setId(2);

		AddEditRecipeRequestPojo requestPojo = new AddEditRecipeRequestPojo();
		requestPojo.setRecipe(recipeEntityPojo);
		
		ResponseEntity<GenericResponsePojo<AddEditRecipeDataPojo>> response = crudRecipeController.editRecipe(requestPojo);
		
		Assessment.assertResponseData(response);
		assertNotNull(response.getBody().getData().getId());
	}

	@Test
	void testGetRecipe() throws BusinessException {

		GetRecipeRequestPojo requestPojo = new GetRecipeRequestPojo();
		requestPojo.setId(2);
		
		ResponseEntity<GenericResponsePojo<GetRecipeDataPojo>> response = crudRecipeController.getRecipe(requestPojo);
		
		Assessment.assertResponseData(response);
		assertNotNull(response.getBody().getData().getRecipe());
	}

	@Test
	void testDeleteRecipe() throws BusinessException {

		DeleteRecipeRequestPojo requestPojo = new DeleteRecipeRequestPojo();
		requestPojo.setId(14);
		
		ResponseEntity<GenericResponsePojo<Void>> response = crudRecipeController.deleteRecipe(requestPojo);
		
		Assessment.assertResponseData(response);
	}

	@Test
	void testGetRecipesAll() {

		ResponseEntity<GenericResponsePojo<Void>> response = crudRecipeController.getRecipesAll();
		
		Assessment.assertResponseData(response);
	}

}
