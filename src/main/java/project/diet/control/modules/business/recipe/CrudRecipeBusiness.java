package project.diet.control.modules.business.recipe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.persistance.GenericPersistence;
import lib.base.backend.vo.CrudOptionsEnum;
import lombok.RequiredArgsConstructor;
import project.diet.control.app.beans.entity.RecipeEntity;
import project.diet.control.app.beans.pojos.entity.RecipeEntityPojo;
import project.diet.control.app.beans.pojos.petition.data.recipe.AddEditRecipeDataPojo;
import project.diet.control.app.beans.pojos.petition.data.recipe.GetRecipeDataPojo;
import project.diet.control.app.beans.pojos.petition.data.recipe.GetRecipeListDataPojo;
import project.diet.control.app.beans.pojos.petition.request.recipe.AddEditRecipeRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.recipe.DeleteRecipeRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.recipe.GetRecipeRequestPojo;
import project.diet.control.app.repository.DietRepositoryImpl;
import project.diet.control.app.vo.catalogs.CatalogsErrorMessage;
import project.diet.control.modules.business.MainBusiness;

@RequiredArgsConstructor
@Component
public class CrudRecipeBusiness extends MainBusiness {
	
	@SuppressWarnings("rawtypes")
	private final GenericPersistence genericPersistance;
	private final DietRepositoryImpl dietRepository;
	
	@SuppressWarnings("unchecked")
	public Integer setAddEditRecipe(RecipeEntity recipeEntity, RecipeEntityPojo recipeEntityPojo, CrudOptionsEnum crudOptionsEnum) {
		
		buildPojoToEntityUtil.generateRecipeEntity(recipeEntity, recipeEntityPojo);
		
		if (crudOptionsEnum == CrudOptionsEnum.SAVE) {
			genericPersistance.save(recipeEntity);
		}
		else if (crudOptionsEnum == CrudOptionsEnum.UPDATE) {
			genericPersistance.update(recipeEntity);
		}
		
		return recipeEntity.getId();
	}
	
	@Transactional(rollbackFor = Exception.class)
	public AddEditRecipeDataPojo executeAddRecipe(AddEditRecipeRequestPojo addEditRecipeRequestPojo) throws BusinessException {
		
		if (addEditRecipeRequestPojo.getRecipe() == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgRecipeNotFoundRequest());
			
		Integer id = setAddEditRecipe(new RecipeEntity(), addEditRecipeRequestPojo.getRecipe(), CrudOptionsEnum.SAVE);
		
		AddEditRecipeDataPojo responsePojo = new AddEditRecipeDataPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public AddEditRecipeDataPojo executeEditRecipe(AddEditRecipeRequestPojo addEditRecipeRequestPojo) throws BusinessException {
		
		RecipeEntityPojo recipeEntityPojo = addEditRecipeRequestPojo.getRecipe();
		
		if (recipeEntityPojo == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgRecipeNotFoundRequest());
		
		if (recipeEntityPojo.getId() == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgRecipeIdIsNull());
		
		RecipeEntity recipe = (RecipeEntity) genericPersistance.findById(RecipeEntity.class, recipeEntityPojo.getId());
		
		if (recipe == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgRecipeIdNotFound(recipeEntityPojo.getId()));
			
		Integer id = setAddEditRecipe(recipe, addEditRecipeRequestPojo.getRecipe(), CrudOptionsEnum.UPDATE);
		
		AddEditRecipeDataPojo responsePojo = new AddEditRecipeDataPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public void executeDeleteRecipe(DeleteRecipeRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getId() == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgRecipeIdIsNull());
		
		RecipeEntity recipe = (RecipeEntity) genericPersistance.findById(RecipeEntity.class, requestPojo.getId());
		
		if (recipe == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgRecipeIdNotFound(requestPojo.getId()));
		
		if (dietRepository.countRegisterDiet(requestPojo.getId()) > 0)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgRecipeIdUsedOnDietCustom());
		
		genericPersistance.delete(recipe);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public GetRecipeDataPojo executeGetRecipe(GetRecipeRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getId() == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgRecipeIdIsNull());
		
		RecipeEntity recipe = (RecipeEntity) genericPersistance.findById(RecipeEntity.class, requestPojo.getId());
		
		if (recipe == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgRecipeIdNotFound(requestPojo.getId()));
		
		RecipeEntityPojo recipeEntityPojo = buildEntityToPojoUtil.generateRecipePojo(new RecipeEntityPojo(), recipe);
		
		GetRecipeDataPojo responsePojo = new GetRecipeDataPojo();
		responsePojo.setRecipe(recipeEntityPojo);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public GetRecipeListDataPojo executeGetRecipes() {
		
		List<RecipeEntity> recipes = genericPersistance.findAll(RecipeEntity.class);
		List<RecipeEntityPojo> recipeEntityPojos = new ArrayList<>();
		
		for (RecipeEntity recipe: recipes) {
			
			recipeEntityPojos.add(buildEntityToPojoUtil.generateRecipePojo(new RecipeEntityPojo(), recipe));
		}
		
		GetRecipeListDataPojo responsePojo = new GetRecipeListDataPojo();
		responsePojo.setRecipes(recipeEntityPojos);
		
		return responsePojo;
	}
}
