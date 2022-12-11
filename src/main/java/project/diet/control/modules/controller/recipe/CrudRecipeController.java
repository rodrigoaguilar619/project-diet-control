package project.diet.control.modules.controller.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.utils.RestUtil;
import project.diet.control.app.beans.pojos.petition.data.recipe.AddEditRecipeDataPojo;
import project.diet.control.app.beans.pojos.petition.data.recipe.GetRecipeDataPojo;
import project.diet.control.app.beans.pojos.petition.data.recipe.GetRecipeListDataPojo;
import project.diet.control.app.beans.pojos.petition.request.recipe.AddEditRecipeRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.recipe.DeleteRecipeRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.recipe.GetRecipeRequestPojo;
import project.diet.control.modules.business.recipe.CrudRecipeBusiness;

@RestController
public class CrudRecipeController {

	@Autowired
	CrudRecipeBusiness crudRecipeBusiness;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/recipe/add", consumes = "application/json", produces = "application/json")
	public ResponseEntity addRecipe(@RequestBody AddEditRecipeRequestPojo requestPojo) throws BusinessException {
		
		AddEditRecipeDataPojo reponsePojo = crudRecipeBusiness.executeAddRecipe(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Recipe added");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/recipe/edit", consumes = "application/json", produces = "application/json")
	public ResponseEntity editRecipe(@RequestBody AddEditRecipeRequestPojo requestPojo) throws BusinessException {
		
		AddEditRecipeDataPojo reponsePojo = crudRecipeBusiness.executeEditRecipe(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Recipe edited");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/recipe/get", consumes = "application/json", produces = "application/json")
	public ResponseEntity getRecipe(@RequestBody GetRecipeRequestPojo requestPojo) throws BusinessException {
		
		GetRecipeDataPojo responsePojo = crudRecipeBusiness.executeGetRecipe(requestPojo);
		return new RestUtil().buildResponseSuccess(responsePojo, "Recipe getted");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/recipe/delete", consumes = "application/json", produces = "application/json")
	public ResponseEntity deleteRecipe(@RequestBody DeleteRecipeRequestPojo requestPojo) throws BusinessException {
		
		crudRecipeBusiness.executeDeleteRecipe(requestPojo);
		return new RestUtil().buildResponseSuccess(null, "Recipe deleted");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/recipe/getAll", consumes = "application/json", produces = "application/json")
	public ResponseEntity getRecipesAll() {
		
		GetRecipeListDataPojo dataPojo = crudRecipeBusiness.executeGetRecipes();
		return new RestUtil().buildResponseSuccess(dataPojo, "list of recipe gotten");
	}
}