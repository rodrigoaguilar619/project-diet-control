package project.diet.control.modules.business.recipe;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.exception.BaseException;
import lib.base.backend.pojo.catalog.CatalogPojo;
import lib.base.backend.pojo.catalog.CatalogDataPojo;
import project.diet.control.app.beans.entity.Recipe;
import project.diet.control.modules.business.MainBusiness;

@Component
public class CatalogRecipeBusiness extends MainBusiness {
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public List<CatalogPojo> getCatalog() throws BaseException {
		
		List<Recipe> catalogList = genericPersistance.findAll(Recipe.class);
		
		return catalogUtil.getCatalog(Recipe.class, catalogList, "id", "title");
	}
	
	@Transactional(rollbackFor = Exception.class)
	public CatalogDataPojo executeGetCatalog() throws BaseException {
		
		List<CatalogPojo> catalogListPojo = getCatalog();
		
		CatalogDataPojo responsePojo = new CatalogDataPojo();
		responsePojo.setCatalogs(catalogListPojo);
		
		return responsePojo;
	}
}
