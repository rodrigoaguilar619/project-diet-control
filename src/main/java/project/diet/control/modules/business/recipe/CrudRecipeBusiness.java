package project.diet.control.modules.business.recipe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.enumerators.CrudOptionsEnum;
import lib.base.backend.exception.data.BusinessException;
import project.diet.control.app.beans.entity.Recipe;
import project.diet.control.app.beans.pojos.entity.RecipeEntityPojo;
import project.diet.control.app.beans.pojos.petition.data.recipe.AddEditRecipeDataPojo;
import project.diet.control.app.beans.pojos.petition.data.recipe.GetRecipeDataPojo;
import project.diet.control.app.beans.pojos.petition.data.recipe.GetRecipeListDataPojo;
import project.diet.control.app.beans.pojos.petition.request.recipe.AddEditRecipeRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.recipe.DeleteRecipeRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.recipe.GetRecipeRequestPojo;
import project.diet.control.app.repository.DietRepositoryImpl;
import project.diet.control.modules.business.MainBusiness;

@Component
public class CrudRecipeBusiness extends MainBusiness {
	
	@Autowired
	DietRepositoryImpl dietRepository;
	
	private String messageRecipeNotFound(Integer idRecipe) {
		
		return "Recipe id: " + idRecipe + " not found";
	}
	
	@SuppressWarnings("unchecked")
	public Integer setAddEditRecipe(Recipe recipeEntity, RecipeEntityPojo recipeEntityPojo, CrudOptionsEnum crudOptionsEnum) {
		
		buildPojoToEntityUtil.generateRecipeEntity(recipeEntity, recipeEntityPojo);
		
		if (crudOptionsEnum.getId() == CrudOptionsEnum.SAVE.getId()) {
			genericPersistance.save(recipeEntity);
		}
		else if (crudOptionsEnum.getId() == CrudOptionsEnum.UPDATE.getId()) {
			genericPersistance.update(recipeEntity);
		}
		
		return recipeEntity.getId();
	}
	
	@Transactional(rollbackFor = Exception.class)
	public AddEditRecipeDataPojo executeAddRecipe(AddEditRecipeRequestPojo addEditRecipeRequestPojo) throws BusinessException {
		
		if (addEditRecipeRequestPojo.getRecipe() == null)
			throw new BusinessException("Recipe data not found on request");
			
		Integer id = setAddEditRecipe(new Recipe(), addEditRecipeRequestPojo.getRecipe(), CrudOptionsEnum.SAVE);
		
		AddEditRecipeDataPojo responsePojo = new AddEditRecipeDataPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public AddEditRecipeDataPojo executeEditRecipe(AddEditRecipeRequestPojo addEditRecipeRequestPojo) throws BusinessException {
		
		RecipeEntityPojo recipeEntityPojo = addEditRecipeRequestPojo.getRecipe();
		
		if (recipeEntityPojo == null)
			throw new BusinessException("Recipe data not found on request");
		
		if (recipeEntityPojo.getId() == null)
			throw new BusinessException("Recipe id is null");
		
		Recipe recipe = (Recipe) genericPersistance.findById(Recipe.class, recipeEntityPojo.getId());
		
		if (recipe == null)
			throw new BusinessException(messageRecipeNotFound(recipeEntityPojo.getId()));
			
		Integer id = setAddEditRecipe(recipe, addEditRecipeRequestPojo.getRecipe(), CrudOptionsEnum.UPDATE);
		
		AddEditRecipeDataPojo responsePojo = new AddEditRecipeDataPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public void executeDeleteRecipe(DeleteRecipeRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getId() == null)
			throw new BusinessException("Id can´t be null");
		
		Recipe recipe = (Recipe) genericPersistance.findById(Recipe.class, requestPojo.getId());
		
		if (recipe == null)
			throw new BusinessException(messageRecipeNotFound(requestPojo.getId()));
		
		if (dietRepository.countRegisterDiet(requestPojo.getId()) > 0)
			throw new BusinessException("Recipe is use on a diet");
		
		genericPersistance.delete(recipe);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public GetRecipeDataPojo executeGetRecipe(GetRecipeRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getId() == null)
			throw new BusinessException("Id can´t be null");
		
		Recipe recipe = (Recipe) genericPersistance.findById(Recipe.class, requestPojo.getId());
		
		if (recipe == null)
			throw new BusinessException(messageRecipeNotFound(requestPojo.getId()));
		
		RecipeEntityPojo recipeEntityPojo = buildEntityToPojoUtil.generateRecipePojo(new RecipeEntityPojo(), recipe);
		
		GetRecipeDataPojo responsePojo = new GetRecipeDataPojo();
		responsePojo.setRecipe(recipeEntityPojo);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public GetRecipeListDataPojo executeGetRecipes() {
		
		List<Recipe> recipes = genericPersistance.findAll(Recipe.class);
		List<RecipeEntityPojo> recipeEntityPojos = new ArrayList<>();
		
		for (Recipe recipe: recipes) {
			
			recipeEntityPojos.add(buildEntityToPojoUtil.generateRecipePojo(new RecipeEntityPojo(), recipe));
		}
		
		GetRecipeListDataPojo responsePojo = new GetRecipeListDataPojo();
		responsePojo.setRecipes(recipeEntityPojos);
		
		return responsePojo;
	}
}
