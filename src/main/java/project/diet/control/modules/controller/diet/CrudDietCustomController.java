package project.diet.control.modules.controller.diet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.utils.RestUtil;
import project.diet.control.app.beans.pojos.petition.data.diet.AddEditDietDataPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietCustomDataPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietCustomDetailDataPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietCustomDetailListDataPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietCustomListDataPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.AddEditDietRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.DeleteDietCustomRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.GetDietCustomDetailListRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.GetDietCustomListRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.GetDietCustomRequestPojo;
import project.diet.control.modules.business.diet.CrudDietCustomBusiness;

@RestController
public class CrudDietCustomController {

	@Autowired
	CrudDietCustomBusiness crudDietCustomBusiness;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/diet/dietCustomAdd", consumes = "application/json", produces = "application/json")
	public ResponseEntity addFood(@RequestBody AddEditDietRequestPojo requestPojo) throws BusinessException  {
		
		AddEditDietDataPojo responsePojo = crudDietCustomBusiness.executeAddDiet(requestPojo);
		return new RestUtil().buildResponseSuccess(responsePojo, "food added");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/diet/dietCustomEdit", consumes = "application/json", produces = "application/json")
	public ResponseEntity editFood(@RequestBody AddEditDietRequestPojo requestPojo) throws BusinessException {
		
		AddEditDietDataPojo responsePojo = crudDietCustomBusiness.executeEditDiet(requestPojo);
		return new RestUtil().buildResponseSuccess(responsePojo, "food edited");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/diet/getDietCustomList", consumes = "application/json", produces = "application/json")
	public ResponseEntity getDietCustomList(@RequestBody GetDietCustomListRequestPojo requestPojo) {
		
		GetDietCustomListDataPojo reponsePojo = crudDietCustomBusiness.executeGetDietCustomList();
		return new RestUtil().buildResponseSuccess(reponsePojo, "Get diet custom list");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/diet/getDietCustom", consumes = "application/json", produces = "application/json")
	public ResponseEntity getDietCustom(@RequestBody GetDietCustomRequestPojo requestPojo) {
		
		GetDietCustomDataPojo reponsePojo = crudDietCustomBusiness.executeGetDietCustomInfo(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Get diet custom");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/diet/getDietsCustomDetailList", consumes = "application/json", produces = "application/json")
	public ResponseEntity getDietsCustomDetailList(@RequestBody GetDietCustomDetailListRequestPojo requestPojo) {
		
		GetDietCustomDetailListDataPojo reponsePojo = crudDietCustomBusiness.executeGetDietsCustomDetail(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Get diet custom detail list");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/diet/getDietCustomDetail", consumes = "application/json", produces = "application/json")
	public ResponseEntity getDietCustomDetail(@RequestBody GetDietCustomRequestPojo requestPojo) {
		
		GetDietCustomDetailDataPojo reponsePojo = crudDietCustomBusiness.executeGetDietCustomDetail(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Get diet custom detail");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/diet/deleteDietCustom", consumes = "application/json", produces = "application/json")
	public ResponseEntity deleteDietCustom(@RequestBody DeleteDietCustomRequestPojo requestPojo) {
		
		crudDietCustomBusiness.executeDeleteDietCustom(requestPojo);
		return new RestUtil().buildResponseSuccess(null, "diet deleted");
	}
}
