package project.diet.control.modules.business.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.utils.CatalogUtil;
import lib.base.backend.exception.BaseException;
import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.pojo.catalog.CatalogPojo;
import lib.base.backend.pojo.catalog.CatalogRequestPojo;
import lib.base.backend.pojo.catalog.CatalogDataPojo;
import project.diet.control.app.beans.entity.Food;
import project.diet.control.modules.business.MainBusiness;

@Component
public class CatalogBusiness extends MainBusiness {
	
	@Autowired
	CatalogUtil catalogUtil;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<CatalogPojo> getCatalog(String catalogName) throws BaseException {
		
		Class clazz = null;
		
		switch (catalogName) {
		case "food":
			clazz = Food.class;
			break;
		default:
			clazz = null;
			break;
		}
		
		if (clazz == null)
			throw new BusinessException("Catalog " + catalogName + " not found");
		
		List<?> catalogList = genericCustomPersistance.findAll(clazz);
		
		return catalogUtil.getCatalog(clazz, catalogList);
	}
	
	@Transactional
	public CatalogDataPojo executeGetCatalog(CatalogRequestPojo requestPojo) throws BaseException {
		
		List<CatalogPojo> catalogListPojo = getCatalog(requestPojo.getCatalogName());
		
		CatalogDataPojo responsePojo = new CatalogDataPojo();
		responsePojo.setCatalogs(catalogListPojo);
		
		return responsePojo;
	}

}
