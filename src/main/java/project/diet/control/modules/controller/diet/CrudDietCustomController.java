package project.diet.control.modules.controller.diet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import project.diet.control.app.vo.catalogs.CatalogsUri;
import project.diet.control.modules.business.diet.CrudDietCustomBusiness;

@RestController
public class CrudDietCustomController {

	CrudDietCustomBusiness crudDietCustomBusiness;
	
	@Autowired
	public CrudDietCustomController(CrudDietCustomBusiness crudDietCustomBusiness) {
		this.crudDietCustomBusiness = crudDietCustomBusiness;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = CatalogsUri.API_DIET_DIET_CUSTOM_ADD, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity addDietCustom(@RequestBody AddEditDietRequestPojo requestPojo) throws BusinessException  {
		
		AddEditDietDataPojo responsePojo = crudDietCustomBusiness.executeAddDiet(requestPojo);
		return new RestUtil().buildResponseSuccess(responsePojo, "food added");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = CatalogsUri.API_DIET_DIET_CUSTOM_EDIT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity editDietCustom(@RequestBody AddEditDietRequestPojo requestPojo) throws BusinessException {
		
		AddEditDietDataPojo responsePojo = crudDietCustomBusiness.executeEditDiet(requestPojo);
		return new RestUtil().buildResponseSuccess(responsePojo, "food edited");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = CatalogsUri.API_DIET_DIET_CUSTOM_LIST_GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getDietCustomList(@RequestBody GetDietCustomListRequestPojo requestPojo) {
		
		GetDietCustomListDataPojo reponsePojo = crudDietCustomBusiness.executeGetDietCustomList();
		return new RestUtil().buildResponseSuccess(reponsePojo, "Get diet custom list");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = CatalogsUri.API_DIET_DIET_CUSTOM_GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getDietCustom(@RequestBody GetDietCustomRequestPojo requestPojo) {
		
		GetDietCustomDataPojo reponsePojo = crudDietCustomBusiness.executeGetDietCustomInfo(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Get diet custom");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = CatalogsUri.API_DIET_DIET_CUSTOM_DETAIL_LIST_GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getDietsCustomDetailList(@RequestBody GetDietCustomDetailListRequestPojo requestPojo) {
		
		GetDietCustomDetailListDataPojo reponsePojo = crudDietCustomBusiness.executeGetDietsCustomDetail(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Get diet custom detail list");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = CatalogsUri.API_DIET_DIET_CUSTOM_DETAIL_GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getDietCustomDetail(@RequestBody GetDietCustomRequestPojo requestPojo) {
		
		GetDietCustomDetailDataPojo reponsePojo = crudDietCustomBusiness.executeGetDietCustomDetail(requestPojo);
		return new RestUtil().buildResponseSuccess(reponsePojo, "Get diet custom detail");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = CatalogsUri.API_DIET_DIET_CUSTOM_DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteDietCustom(@RequestBody DeleteDietCustomRequestPojo requestPojo) {
		
		crudDietCustomBusiness.executeDeleteDietCustom(requestPojo);
		return new RestUtil().buildResponseSuccess(null, "diet deleted");
	}
}
