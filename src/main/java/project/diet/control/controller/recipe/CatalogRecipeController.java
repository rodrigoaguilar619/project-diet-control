package project.diet.control.controller.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lib.base.backend.exception.BaseException;
import lib.base.backend.pojo.catalog.CatalogRespPojo;
import lib.base.backend.utils.RestUtil;
import project.diet.control.business.recipe.CatalogRecipeBusiness;
import project.diet.control.pojos.request.GenericRequestPojo;

@RestController
public class CatalogRecipeController {

	@Autowired
	CatalogRecipeBusiness catalogRecipeBusiness;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/recipe/getCatalog", consumes = "application/json", produces = "application/json")
	public ResponseEntity getCatalog(@RequestBody GenericRequestPojo requestPojo) throws BaseException {
		
		CatalogRespPojo reponsePojo = catalogRecipeBusiness.executeGetCatalog();
		return new RestUtil().buildResponseSuccess(reponsePojo, "Recipe catalog added");
	}

}
