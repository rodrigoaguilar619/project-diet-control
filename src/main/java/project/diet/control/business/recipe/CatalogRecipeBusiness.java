package project.diet.control.business.recipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.exception.BaseException;
import lib.base.backend.pojo.catalog.CatalogDataPojo;
import lib.base.backend.pojo.catalog.CatalogRespPojo;
import lib.base.backend.utils.CatalogUtil;
import project.diet.control.beans.entity.Recipe;
import project.diet.control.business.MainBusiness;

@Component
public class CatalogRecipeBusiness extends MainBusiness {
	
	@Autowired
	CatalogUtil catalogUtil;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<CatalogDataPojo> getCatalog() throws BaseException {
		
		List<Recipe> catalogList = genericCustomPersistance.findAll(Recipe.class);
		
		return catalogUtil.getCatalog(Recipe.class, catalogList, "id", "title");
	}
	
	@Transactional
	public CatalogRespPojo executeGetCatalog() throws BaseException {
		
		List<CatalogDataPojo> catalogListPojo = getCatalog();
		
		CatalogRespPojo responsePojo = new CatalogRespPojo();
		responsePojo.setCatalogs(catalogListPojo);
		
		return responsePojo;
	}
}
