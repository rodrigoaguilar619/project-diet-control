package project.diet.control.controller.diet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.utils.RestUtil;
import project.diet.control.business.diet.CrudDietCustomBusiness;
import project.diet.control.pojos.request.diet.AddEditDietRequestPojo;
import project.diet.control.pojos.request.diet.DeleteDietCustomRequestPojo;
import project.diet.control.pojos.request.diet.GetDietCustomDetailListRequestPojo;
import project.diet.control.pojos.request.diet.GetDietCustomListRequestPojo;
import project.diet.control.pojos.request.diet.GetDietCustomRequestPojo;
import project.diet.control.pojos.request.food.DeleteFoodRequestPojo;
import project.diet.control.pojos.response.diet.AddEditDietRespPojo;
import project.diet.control.pojos.response.diet.GetDietCustomDetailListRespPojo;
import project.diet.control.pojos.response.diet.GetDietCustomDetailRespPojo;
import project.diet.control.pojos.response.diet.GetDietCustomListRespPojo;
import project.diet.control.pojos.response.diet.GetDietCustomRespPojo;

@RestController
public class CrudDietCustomController {

	@Autowired
	CrudDietCustomBusiness crudDietCustomBusiness;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/diet/dietCustomAdd", consumes = "application/json", produces = "application/json")
	public ResponseEntity addFood(@RequestBody AddEditDietRequestPojo requestPojo) throws BusinessException {
		
		AddEditDietRespPojo responsePojo = crudDietCustomBusiness.executeAddDiet(requestPojo);
		return new RestUtil().buildResponseSuccess(responsePojo, "food added");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/diet/dietCustomEdit", consumes = "application/json", produces = "application/json")
	public ResponseEntity editFood(@RequestBody AddEditDietRequestPojo requestPojo) throws BusinessException {
		
		AddEditDietRespPojo responsePojo = crudDietCustomBusiness.executeEditDiet(requestPojo);
		return new RestUtil().buildResponseSuccess(responsePojo, "food edited");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/diet/getDietCustomList", consumes = "application/json", produces = "application/json")
	public ResponseEntity getDietCustomList(@RequestBody GetDietCustomListRequestPojo requestPojo) {
		
		GetDietCustomListRespPojo reponsePojo = crudDietCustomBusiness.executeGetDietCustomList();
		return new RestUtil().buildResponseSuccess(reponsePojo, "Get diet custom list");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/diet/getDietCustom", consumes = "application/json", produces = "application/json")
	public ResponseEntity getDietCustom(@RequestBody GetDietCustomRequestPojo requestPojo) {
		
		GetDietCustomRespPojo reponsePojo = crudDietCustomBusiness.executeGetDietCustomInfo(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Get diet custom");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/diet/getDietsCustomDetailList", consumes = "application/json", produces = "application/json")
	public ResponseEntity getDietsCustomDetailList(@RequestBody GetDietCustomDetailListRequestPojo requestPojo) {
		
		GetDietCustomDetailListRespPojo reponsePojo = crudDietCustomBusiness.executeGetDietsCustomDetail(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Get diet custom detail list");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/diet/getDietCustomDetail", consumes = "application/json", produces = "application/json")
	public ResponseEntity getDietCustomDetail(@RequestBody GetDietCustomRequestPojo requestPojo) {
		
		GetDietCustomDetailRespPojo reponsePojo = crudDietCustomBusiness.executeGetDietCustomDetail(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Get diet custom detail");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/diet/deleteDietCustom", consumes = "application/json", produces = "application/json")
	public ResponseEntity deleteDietCustom(@RequestBody DeleteDietCustomRequestPojo requestPojo) throws BusinessException {
		
		crudDietCustomBusiness.executeDeleteDietCustom(requestPojo);
		return new RestUtil().buildResponseSuccess(null, "diet deleted");
	}
}
