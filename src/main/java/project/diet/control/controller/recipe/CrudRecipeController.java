package project.diet.control.controller.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lib.base.backend.utils.RestUtil;
import project.diet.control.business.recipe.CrudRecipeBusiness;
import project.diet.control.pojos.request.recipe.AddEditRecipeRequestPojo;
import project.diet.control.pojos.request.recipe.DeleteRecipeRequestPojo;
import project.diet.control.pojos.request.recipe.GetRecipeRequestPojo;
import project.diet.control.pojos.response.recipe.AddEditRecipeRespPojo;
import project.diet.control.pojos.response.recipe.GetRecipeListRespPojo;
import project.diet.control.pojos.response.recipe.GetRecipeRespPojo;

@RestController
public class CrudRecipeController {

	@Autowired
	CrudRecipeBusiness crudRecipeBusiness;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/recipe/add", consumes = "application/json", produces = "application/json")
	public ResponseEntity addRecipe(@RequestBody AddEditRecipeRequestPojo requestPojo) throws Exception {
		
		AddEditRecipeRespPojo reponsePojo = crudRecipeBusiness.executeAddRecipe(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Recipe added");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/recipe/edit", consumes = "application/json", produces = "application/json")
	public ResponseEntity editRecipe(@RequestBody AddEditRecipeRequestPojo requestPojo) throws Exception {
		
		AddEditRecipeRespPojo reponsePojo = crudRecipeBusiness.executeEditRecipe(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Recipe edited");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/recipe/get", consumes = "application/json", produces = "application/json")
	public ResponseEntity getRecipe(@RequestBody GetRecipeRequestPojo requestPojo) throws Exception {
		
		GetRecipeRespPojo responsePojo = crudRecipeBusiness.executeGetRecipe(requestPojo);
		return new RestUtil().buildResponseSuccess(responsePojo, "Recipe getted");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/recipe/delete", consumes = "application/json", produces = "application/json")
	public ResponseEntity deleteRecipe(@RequestBody DeleteRecipeRequestPojo requestPojo) throws Exception {
		
		crudRecipeBusiness.executeDeleteRecipe(requestPojo);
		return new RestUtil().buildResponseSuccess(null, "Recipe deleted");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/recipe/getAll", consumes = "application/json", produces = "application/json")
	public ResponseEntity getRecipesAll() {
		
		//return new ResponseEntity(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
		
		GetRecipeListRespPojo dataPojo = crudRecipeBusiness.executeGetRecipes();
		return new RestUtil().buildResponseSuccess(dataPojo, "list of recipe gotten");
	}
}
