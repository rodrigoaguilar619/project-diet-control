package project.diet.control.modules.controller.diet;

import java.io.FileNotFoundException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lib.base.backend.utils.RestUtil;
import net.sf.jasperreports.engine.JRException;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietCustomReportDataPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.GetDietCustomReportRequestPojo;
import project.diet.control.app.vo.catalogs.CatalogsUri;
import project.diet.control.modules.business.diet.ReportDietCustomBusiness;

@RestController
public class ReportDietCustomController {

	ReportDietCustomBusiness reportDietCustomBusiness;
	
	public ReportDietCustomController(ReportDietCustomBusiness reportDietCustomBusiness) {
		this.reportDietCustomBusiness = reportDietCustomBusiness;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = CatalogsUri.API_DIET_DIET_REPORT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity reportDiet(@RequestBody GetDietCustomReportRequestPojo requestPojo) throws FileNotFoundException, JRException {
		
		GetDietCustomReportDataPojo responsePojo = reportDietCustomBusiness.executeGetDietCustomReport(requestPojo);
		return new RestUtil().buildResponseSuccess(responsePojo, "food added");
	}
}
