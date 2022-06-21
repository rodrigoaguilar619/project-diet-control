package test.project.diet.control.pdf;

import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lib.utils.backend.pdf.BuildPdfJasperUtil;
import lib.utils.backend.pojo.pdf.jasper.config.PdfReportJasperConfig;
import project.diet.control.config.starter.Application;

@SpringBootTest(classes = Application.class)
public class PdfJasperTest {

	@Test
	void pdfJasperTest() {
		
		try {
			
			Map<String, String> dietTotals = new LinkedHashMap<>();
			dietTotals.put("total_grams", "6000");
			
			Map<String, Object> parameters = new LinkedHashMap<>();
			parameters.put("_subtotal_diet_base", dietTotals);
			
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
