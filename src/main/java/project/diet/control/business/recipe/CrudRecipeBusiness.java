package project.diet.control.business.recipe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.persistance.GenericPersistence;
import lib.base.backend.web.enumeratos.CrudOptionsEnum;
import project.diet.control.beans.entity.Recipe;
import project.diet.control.pojos.entity.RecipeEntityPojo;
import project.diet.control.pojos.request.recipe.AddEditRecipeRequestPojo;
import project.diet.control.pojos.request.recipe.DeleteRecipeRequestPojo;
import project.diet.control.pojos.request.recipe.GetRecipeRequestPojo;
import project.diet.control.pojos.response.recipe.AddEditRecipeRespPojo;
import project.diet.control.pojos.response.recipe.GetRecipeListRespPojo;
import project.diet.control.pojos.response.recipe.GetRecipeRespPojo;
import project.diet.control.repository.DietRepositoryImpl;
import project.diet.control.util.BuildEntityToPojoUtil;
import project.diet.control.util.BuildPojoToEntityUtil;

@Component
public class CrudRecipeBusiness {

	@SuppressWarnings("rawtypes")
	@Autowired
	GenericPersistence genericCustomPersistance;
	
	@Autowired
	BuildPojoToEntityUtil buildPojoToEntityUtil;
	
	@Autowired
	BuildEntityToPojoUtil buildEntityToPojoUtil;
	
	@Autowired
	DietRepositoryImpl dietRepository;
	
	private String messageRecipeNotFound(Integer idRecipe) {
		
		return "Recipe id: " + idRecipe + " not found";
	}
	
	@SuppressWarnings("unchecked")
	public Integer setAddEditRecipe(Recipe recipeEntity, RecipeEntityPojo recipeEntityPojo, CrudOptionsEnum crudOptionsEnum) {
		
		buildPojoToEntityUtil.generateRecipeEntity(recipeEntity, recipeEntityPojo);
		
		if (crudOptionsEnum.getId() == CrudOptionsEnum.SAVE.getId()) {
			genericCustomPersistance.save(recipeEntity);
		}
		else if (crudOptionsEnum.getId() == CrudOptionsEnum.UPDATE.getId()) {
			genericCustomPersistance.update(recipeEntity);
		}
		
		return recipeEntity.getId();
	}
	
	@Transactional
	public AddEditRecipeRespPojo executeAddRecipe(AddEditRecipeRequestPojo addEditRecipeRequestPojo) throws BusinessException {
		
		if (addEditRecipeRequestPojo.getRecipe() == null)
			throw new BusinessException("Recipe data not found on request");
			
		Integer id = setAddEditRecipe(new Recipe(), addEditRecipeRequestPojo.getRecipe(), CrudOptionsEnum.SAVE);
		
		AddEditRecipeRespPojo responsePojo = new AddEditRecipeRespPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public AddEditRecipeRespPojo executeEditRecipe(AddEditRecipeRequestPojo addEditRecipeRequestPojo) throws BusinessException {
		
		RecipeEntityPojo recipeEntityPojo = addEditRecipeRequestPojo.getRecipe();
		
		if (recipeEntityPojo == null)
			throw new BusinessException("Recipe data not found on request");
		
		if (recipeEntityPojo.getId() == null)
			throw new BusinessException("Recipe id is null");
		
		Recipe recipe = (Recipe) genericCustomPersistance.findById(Recipe.class, recipeEntityPojo.getId());
		
		if (recipe == null)
			throw new BusinessException(messageRecipeNotFound(recipeEntityPojo.getId()));
			
		Integer id = setAddEditRecipe(recipe, addEditRecipeRequestPojo.getRecipe(), CrudOptionsEnum.UPDATE);
		
		AddEditRecipeRespPojo responsePojo = new AddEditRecipeRespPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public void executeDeleteRecipe(DeleteRecipeRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getId() == null)
			throw new BusinessException("Id can´t be null");
		
		Recipe recipe = (Recipe) genericCustomPersistance.findById(Recipe.class, requestPojo.getId());
		
		if (recipe == null)
			throw new BusinessException(messageRecipeNotFound(requestPojo.getId()));
		
		if (dietRepository.countRegisterDiet(requestPojo.getId()) > 0)
			throw new BusinessException("Recipe is use on a diet");
		
		genericCustomPersistance.delete(recipe);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public GetRecipeRespPojo executeGetRecipe(GetRecipeRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getId() == null)
			throw new BusinessException("Id can´t be null");
		
		Recipe recipe = (Recipe) genericCustomPersistance.findById(Recipe.class, requestPojo.getId());
		
		if (recipe == null)
			throw new BusinessException(messageRecipeNotFound(requestPojo.getId()));
		
		RecipeEntityPojo recipeEntityPojo = buildEntityToPojoUtil.generateRecipePojo(new RecipeEntityPojo(), recipe);
		
		GetRecipeRespPojo responsePojo = new GetRecipeRespPojo();
		responsePojo.setRecipe(recipeEntityPojo);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public GetRecipeListRespPojo executeGetRecipes() {
		
		List<Recipe> recipes = genericCustomPersistance.findAll(Recipe.class);
		List<RecipeEntityPojo> recipeEntityPojos = new ArrayList<>();
		
		for (Recipe recipe: recipes) {
			
			recipeEntityPojos.add(buildEntityToPojoUtil.generateRecipePojo(new RecipeEntityPojo(), recipe));
		}
		
		GetRecipeListRespPojo responsePojo = new GetRecipeListRespPojo();
		responsePojo.setRecipes(recipeEntityPojos);
		
		return responsePojo;
	}
}
