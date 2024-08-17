package project.diet.control.modules.controller.diet;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import lib.base.backend.pojo.rest.GenericResponsePojo;
import lib.base.backend.test.assessment.Assessment;
import net.sf.jasperreports.engine.JRException;
import project.diet.control.ProjectIntegrationTest;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietCustomReportDataPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.GetDietCustomReportRequestPojo;

@SuppressWarnings("unchecked")
class ReportDietCustomControllerTest extends ProjectIntegrationTest {
	
	@Autowired
	ReportDietCustomController reportDietCustomController;

	@Test
	void testReportDiet() throws FileNotFoundException, JRException {
		
		GetDietCustomReportRequestPojo requestPojo = new GetDietCustomReportRequestPojo();
		requestPojo.setId(2);

		ResponseEntity<GenericResponsePojo<GetDietCustomReportDataPojo>> response = reportDietCustomController.reportDiet(requestPojo);
		
		Assessment.assertResponseData(response);
		assertNotNull(response.getBody().getData().getFile());
	}

}
