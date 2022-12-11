package project.diet.control.modules.controller.diet;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lib.base.backend.utils.RestUtil;
import net.sf.jasperreports.engine.JRException;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietCustomReportDataPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.GetDietCustomReportRequestPojo;
import project.diet.control.modules.business.diet.ReportDietCustomBusiness;

@RestController
public class ReportDietCustomController {

	@Autowired
	ReportDietCustomBusiness reportDietCustomBusiness;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/api/diet/reportDiet", consumes = "application/json", produces = "application/json")
	public ResponseEntity reportDiet(@RequestBody GetDietCustomReportRequestPojo requestPojo) throws FileNotFoundException, JRException {
		
		GetDietCustomReportDataPojo responsePojo = reportDietCustomBusiness.executeGetDietCustomReport(requestPojo);
		return new RestUtil().buildResponseSuccess(responsePojo, "food added");
	}
}