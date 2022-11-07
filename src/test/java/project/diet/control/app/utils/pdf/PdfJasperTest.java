package project.diet.control.app.utils.pdf;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lib.base.backend.pojo.pdf.jasper.PdfReportJasperConfigPojo;
import lib.base.backend.utils.ExecuteMethodUtil;
import lib.base.backend.utils.pdf.BuildPdfJasperUtil;
import project.diet.control.config.AppDietControlIindividualTest;

@SpringBootTest(classes = AppDietControlIindividualTest.class)
class PdfJasperTest {

	@Test
	void pdfJasperTest() throws Throwable {
		
		ExecuteMethodUtil.execute("GENERATE JASPER REPORT", () -> {
			
			Map<String, String> dietTotals = new LinkedHashMap<>();
			dietTotals.put("total_grams", "6000");
			
			Map<String, Object> parameters = new LinkedHashMap<>();
			parameters.put("_subtotal_diet_base", dietTotals);
			
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
