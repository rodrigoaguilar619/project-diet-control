package project.diet.control.modules.business.recipe;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.exception.BaseException;
import lib.base.backend.persistance.GenericPersistence;
import lib.base.backend.pojo.catalog.CatalogPojo;
import lombok.RequiredArgsConstructor;
import lib.base.backend.pojo.catalog.CatalogDataPojo;
import project.diet.control.app.beans.entity.RecipeEntity;
import project.diet.control.modules.business.MainBusiness;

@RequiredArgsConstructor
@Component
public class CatalogRecipeBusiness extends MainBusiness {
	
	@SuppressWarnings("rawtypes")
	private final GenericPersistence genericPersistance;
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public List<CatalogPojo> getCatalog() throws BaseException {
		
		List<RecipeEntity> catalogList = genericPersistance.findAll(RecipeEntity.class);
		
		return catalogUtil.getCatalog(RecipeEntity.class, catalogList, "id", "title");
	}
	
	@Transactional(rollbackFor = Exception.class)
	public CatalogDataPojo executeGetCatalog() throws BaseException {
		
		List<CatalogPojo> catalogListPojo = getCatalog();
		
		CatalogDataPojo responsePojo = new CatalogDataPojo();
		responsePojo.setCatalogs(catalogListPojo);
		
		return responsePojo;
	}
}
