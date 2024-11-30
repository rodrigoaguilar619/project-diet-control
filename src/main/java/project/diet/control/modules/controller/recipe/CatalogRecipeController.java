package project.diet.control.modules.controller.recipe;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lib.base.backend.exception.BaseException;
import lib.base.backend.pojo.catalog.CatalogDataPojo;
import lib.base.backend.utils.RestUtil;
import project.diet.control.app.beans.pojos.petition.request.GenericRequestPojo;
import project.diet.control.app.vo.catalogs.CatalogsUri;
import project.diet.control.modules.business.recipe.CatalogRecipeBusiness;

@RestController
public class CatalogRecipeController {

	CatalogRecipeBusiness catalogRecipeBusiness;
	
	public CatalogRecipeController(CatalogRecipeBusiness catalogRecipeBusiness) {
		this.catalogRecipeBusiness = catalogRecipeBusiness;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = CatalogsUri.API_RECIPE_CATALOG_GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getCatalog(@RequestBody GenericRequestPojo requestPojo) throws BaseException {
		
		CatalogDataPojo reponsePojo = catalogRecipeBusiness.executeGetCatalog();
		return new RestUtil().buildResponseSuccess(reponsePojo, "Recipe catalog added");
	}

}
