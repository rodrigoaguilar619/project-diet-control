package project.diet.control.business.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.utils.CatalogUtil;
import lib.base.backend.exception.BaseException;
import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.pojo.catalog.CatalogDataPojo;
import lib.base.backend.pojo.catalog.CatalogRequestPojo;
import lib.base.backend.pojo.catalog.CatalogRespPojo;
import project.diet.control.beans.entity.Food;
import project.diet.control.business.MainBusiness;

@Component
public class CatalogBusiness extends MainBusiness {
	
	@Autowired
	CatalogUtil catalogUtil;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<CatalogDataPojo> getCatalog(String catalogName) throws BaseException {
		
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
	public CatalogRespPojo executeGetCatalog(CatalogRequestPojo requestPojo) throws BaseException {
		
		List<CatalogDataPojo> catalogListPojo = getCatalog(requestPojo.getCatalogName());
		
		CatalogRespPojo responsePojo = new CatalogRespPojo();
		responsePojo.setCatalogs(catalogListPojo);
		
		return responsePojo;
	}

}
