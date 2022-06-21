package test.project.diet.control.diet;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lib.utils.backend.pdf.BuildPdfJasperUtil;
import lib.utils.backend.pojo.pdf.jasper.config.PdfReportJasperConfig;
import project.diet.control.business.diet.ReportDietCustomBusiness;
import project.diet.control.config.starter.Application;

@SpringBootTest(classes = Application.class)
public class DietReportTest {
	
	@Autowired
	ReportDietCustomBusiness reportDietCustomBusiness;

	@Test
	@Transactional
	void generateReportTest() {
		
		try {
			
			Map<String, Object> parameters = reportDietCustomBusiness.getParametersDietCustomReport(2);
			
			PdfReportJasperConfig reportJasperConfig = new PdfReportJasperConfig();
			reportJasperConfig.setConfig(parameters);
			reportJasperConfig.setReportPath("C:/Users/rodri/JaspersoftWorkspace/diet_control/reports/diet_control_resume_totals.jasper");
			
			List<PdfReportJasperConfig> reportJasperConfigs = new ArrayList<>();
			reportJasperConfigs.add(reportJasperConfig);
			
			BuildPdfJasperUtil pdfJasperUtil = new BuildPdfJasperUtil();
			
			byte[] reportByte = pdfJasperUtil.reportPdf(reportJasperConfigs);
			String reportBase64 = Base64.getEncoder().encodeToString(reportByte);
			
			System.out.println("repotor base64: " + reportBase64);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
