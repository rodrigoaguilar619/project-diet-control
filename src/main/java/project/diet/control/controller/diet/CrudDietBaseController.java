package project.diet.control.controller.diet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lib.base.backend.utils.RestUtil;
import project.diet.control.business.diet.CrudDietBaseBusiness;
import project.diet.control.business.diet.CrudDietBusiness;
import project.diet.control.pojos.request.diet.GetDietBaseRequestPojo;
import project.diet.control.pojos.request.diet.RegisterDietBaseRequestPojo;
import project.diet.control.pojos.response.diet.AddEditDietRespPojo;
import project.diet.control.pojos.response.diet.GetDietBaseRespPojo;

@RestController
public class CrudDietBaseController {

	@Autowired
	CrudDietBaseBusiness crudDietBaseBusiness;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/diet/registerDietBase", consumes = "application/json", produces = "application/json")
	public ResponseEntity registerDietBase(@RequestBody RegisterDietBaseRequestPojo requestPojo) throws Exception {
		
		AddEditDietRespPojo reponsePojo = crudDietBaseBusiness.executeRegisterDietBase(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Diet base registered");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/diet/getDietBase", consumes = "application/json", produces = "application/json")
	public ResponseEntity getDietBase(@RequestBody GetDietBaseRequestPojo requestPojo) throws Exception {
		
		GetDietBaseRespPojo reponsePojo = crudDietBaseBusiness.executeGetDietBase();
		return new RestUtil().buildResponseSuccess(reponsePojo, "Get diet base");
	}
}
