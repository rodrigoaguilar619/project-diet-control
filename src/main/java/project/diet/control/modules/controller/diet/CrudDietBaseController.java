package project.diet.control.modules.controller.diet;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.utils.RestUtil;
import project.diet.control.app.beans.pojos.petition.data.diet.AddEditDietDataPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietBaseDataPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.GetDietBaseRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.RegisterDietBaseRequestPojo;
import project.diet.control.app.vo.catalogs.CatalogsUri;
import project.diet.control.modules.business.diet.CrudDietBaseBusiness;

@RestController
public class CrudDietBaseController {

	CrudDietBaseBusiness crudDietBaseBusiness;
	
	public CrudDietBaseController(CrudDietBaseBusiness crudDietBaseBusiness) {
		this.crudDietBaseBusiness = crudDietBaseBusiness;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = CatalogsUri.API_DIET_DIET_BASE_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity registerDietBase(@RequestBody RegisterDietBaseRequestPojo requestPojo) throws BusinessException {
		
		AddEditDietDataPojo reponsePojo = crudDietBaseBusiness.executeRegisterDietBase(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Diet base registered");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = CatalogsUri.API_DIET_DIET_BASE_GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getDietBase(@RequestBody GetDietBaseRequestPojo requestPojo) {
		
		GetDietBaseDataPojo reponsePojo = crudDietBaseBusiness.executeGetDietBase();
		return new RestUtil().buildResponseSuccess(reponsePojo, "Get diet base");
	}
}
