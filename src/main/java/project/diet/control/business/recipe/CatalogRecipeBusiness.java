package project.diet.control.business.recipe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.exception.BaseException;
import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.persistance.GenericPersistence;
import lib.base.backend.pojo.catalog.CatalogDataPojo;
import lib.base.backend.pojo.catalog.CatalogRequestPojo;
import lib.base.backend.pojo.catalog.CatalogRespPojo;
import lib.base.backend.utils.CatalogUtil;
import lib.base.backend.web.enumeratos.CrudOptionsEnum;
import project.diet.control.beans.entity.Recipe;
import project.diet.control.business.MainBusiness;
import project.diet.control.pojos.entity.RecipeEntityPojo;
import project.diet.control.pojos.request.recipe.AddEditRecipeRequestPojo;
import project.diet.control.pojos.request.recipe.DeleteRecipeRequestPojo;
import project.diet.control.pojos.request.recipe.GetRecipeRequestPojo;
import project.diet.control.pojos.response.recipe.AddEditRecipeRespPojo;
import project.diet.control.pojos.response.recipe.GetRecipeListRespPojo;
import project.diet.control.pojos.response.recipe.GetRecipeRespPojo;
import project.diet.control.util.BuildEntityToPojoUtil;
import project.diet.control.util.BuildPojoToEntityUtil;

@Component
public class CatalogRecipeBusiness extends MainBusiness {
	
	@Autowired
	CatalogUtil catalogUtil;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<CatalogDataPojo> getCatalog() throws BaseException {
		
		List<Recipe> catalogList = genericCustomPersistance.findAll(Recipe.class);
		
		List<CatalogDataPojo> catalogDataPojos = catalogUtil.getCatalog(Recipe.class, catalogList, "id", "title");
		
		return catalogDataPojos;
	}
	
	@Transactional
	public CatalogRespPojo executeGetCatalog() throws BaseException {
		
		List<CatalogDataPojo> catalogListPojo = getCatalog();
		
		CatalogRespPojo responsePojo = new CatalogRespPojo();
		responsePojo.setCatalogs(catalogListPojo);
		
		return responsePojo;
	}
}
