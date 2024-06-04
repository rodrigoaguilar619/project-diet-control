package test.diet.control.modules.business.diet;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lib.base.backend.pojo.pdf.jasper.PdfReportJasperConfigPojo;
import lib.base.backend.utils.ExecuteMethodUtil;
import lib.base.backend.utils.pdf.BuildPdfJasperUtil;
import project.diet.control.modules.business.diet.ReportDietCustomBusiness;
import test.diet.control.config.AppDietControlTest;

@SpringBootTest(classes = AppDietControlTest.class)
class DietReportTest {
	
	@Autowired
	ReportDietCustomBusiness reportDietCustomBusiness;

	@Test
	@Transactional
	void generateReportTest() throws Throwable {
		
		ExecuteMethodUtil.execute("GENERATE DIET REPORT", () -> {
			
			Map<String, Object> parameters = reportDietCustomBusiness.getParametersDietCustomReport(2);
			
			PdfReportJasperConfigPojo reportJasperConfig = new PdfReportJasperConfigPojo();
			reportJasperConfig.setConfig(parameters);
			reportJasperConfig.setReportPath("C:/Users/rodri/JaspersoftWorkspace/diet_control/reports/diet_control_resume_totals.jasper");
			
			List<PdfReportJasperConfigPojo> reportJasperConfigs = new ArrayList<>();
			reportJasperConfigs.add(reportJasperConfig);
			
			BuildPdfJasperUtil pdfJasperUtil = new BuildPdfJasperUtil();
			
			byte[] reportByte = pdfJasperUtil.reportPdf(reportJasperConfigs);
			String reportBase64 = Base64.getEncoder().encodeToString(reportByte);
			
			System.out.println("repotor base64: " + reportBase64);
			
			assertTrue(true);

		});
	}
}
