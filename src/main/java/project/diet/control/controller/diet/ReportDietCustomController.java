package project.diet.control.controller.diet;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.utils.RestUtil;
import net.sf.jasperreports.engine.JRException;
import project.diet.control.business.diet.ReportDietCustomBusiness;
import project.diet.control.pojos.request.diet.GetDietCustomReportRequestPojo;
import project.diet.control.pojos.response.diet.GetDietCustomReportRespPojo;

@RestController
public class ReportDietCustomController {

	@Autowired
	ReportDietCustomBusiness reportDietCustomBusiness;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/diet/reportDiet", consumes = "application/json", produces = "application/json")
	public ResponseEntity reportDiet(@RequestBody GetDietCustomReportRequestPojo requestPojo) throws BusinessException, FileNotFoundException, JRException {
		
		GetDietCustomReportRespPojo responsePojo = reportDietCustomBusiness.executeGetDietCustomReport(requestPojo);
		return new RestUtil().buildResponseSuccess(responsePojo, "food added");
	}
}
