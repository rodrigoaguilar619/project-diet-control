package project.diet.control.modules.business.diet;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.pojo.files.FilePojo;
import lib.base.backend.pojo.pdf.jasper.PdfReportJasperConfigPojo;
import lib.base.backend.utils.pdf.BuildPdfJasperUtil;
import net.sf.jasperreports.engine.JRException;
import project.diet.control.app.beans.entity.Diet;
import project.diet.control.app.beans.entity.NutritionGoal;
import project.diet.control.app.beans.pojos.diet.DietDataPojo;
import project.diet.control.app.beans.pojos.diet.DietFoodResumePojo;
import project.diet.control.app.beans.pojos.entity.DietEntityPojo;
import project.diet.control.app.beans.pojos.entity.RecipeEntityPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietCustomReportDataPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.GetDietCustomReportRequestPojo;
import project.diet.control.app.repository.DietRepositoryImpl;
import project.diet.control.app.util.DietUtil;
import project.diet.control.modules.business.MainBusiness;

@Component
public class ReportDietCustomBusiness extends MainBusiness {
	
	@Autowired
	DietRepositoryImpl dietRepository;
	
	private String setDecimalScale(BigDecimal number) {
		
		if (number != null)
			return number.setScale(2, RoundingMode.HALF_UP).toPlainString();
		else
			return "";
	}
	
	private Map<String, Object> buildParametersDietTotals(DietEntityPojo dietEntityPojo, String description) {
		
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("id", dietEntityPojo.getId() != null ? dietEntityPojo.getId().toString() : "");
		parameters.put("description", description);
		parameters.put("grams", dietEntityPojo.getTotalQuantityGrams() != null ? setDecimalScale(dietEntityPojo.getTotalQuantityGrams()) : "--");
		parameters.put("calories", setDecimalScale(dietEntityPojo.getTotalCalories()));
		parameters.put("proteins", setDecimalScale(dietEntityPojo.getTotalProteins()));
		parameters.put("carbohydrates", setDecimalScale(dietEntityPojo.getTotalCarbohydrates()));
		parameters.put("fat", setDecimalScale(dietEntityPojo.getTotalFat()));
		parameters.put("carb_sugar", setDecimalScale(dietEntityPojo.getTotalCarbSugar()));
		parameters.put("carb_sugar_added", setDecimalScale(dietEntityPojo.getTotalCarbSugarAdded()));
		parameters.put("fat_mono", setDecimalScale(dietEntityPojo.getTotalFatMono()));
		parameters.put("fat_poli", setDecimalScale(dietEntityPojo.getTotalFatPoli()));
		parameters.put("fat_sat", setDecimalScale(dietEntityPojo.getTotalFatSat()));
		parameters.put("fat_trans", setDecimalScale(dietEntityPojo.getTotalFatTrans()));
		parameters.put("fiber", setDecimalScale(dietEntityPojo.getTotalFiber()));
		parameters.put("cholesterol", setDecimalScale(dietEntityPojo.getTotalCholesterol()));
		parameters.put("sodium", setDecimalScale(dietEntityPojo.getTotalSodium()));
		
		return parameters;
	}
	
	private List<Map<String, Object>> buildParametersDietFoodList(List<DietFoodResumePojo> foodResumePojos) {
		
		List<Map<String, Object>> parametersFoodList = new ArrayList<>();
		
		for(DietFoodResumePojo dietFoodResumePojo: foodResumePojos) {
			
			Map<String, Object> parameters = new LinkedHashMap<>();
			parameters.put("id", dietFoodResumePojo.getId().toString());
			parameters.put("description", dietFoodResumePojo.getDescription());
			parameters.put("portions", dietFoodResumePojo.getPortions() != null ? dietFoodResumePojo.getPortions() : "--");
			parameters.put("unities", dietFoodResumePojo.getUnities() != null ? dietFoodResumePojo.getUnities() : "--");
			parameters.put("grams", dietFoodResumePojo.getQuantityGrams() != null ? setDecimalScale(dietFoodResumePojo.getQuantityGrams()) : "--");
			parameters.put("calories", setDecimalScale(dietFoodResumePojo.getCalories()));
			parameters.put("proteins", setDecimalScale(dietFoodResumePojo.getProteins()));
			parameters.put("carbohydrates", setDecimalScale(dietFoodResumePojo.getCarbohydrates()));
			parameters.put("fat", setDecimalScale(dietFoodResumePojo.getFat()));
			parameters.put("carb_sugar", setDecimalScale(dietFoodResumePojo.getCarbSugar()));
			parameters.put("carb_sugar_added", setDecimalScale(dietFoodResumePojo.getCarbSugarAdded()));
			parameters.put("fat_mono", setDecimalScale(dietFoodResumePojo.getFatMono()));
			parameters.put("fat_poli", setDecimalScale(dietFoodResumePojo.getFatPoli()));
			parameters.put("fat_sat", setDecimalScale(dietFoodResumePojo.getFatSat()));
			parameters.put("fat_trans", setDecimalScale(dietFoodResumePojo.getFatTrans()));
			parameters.put("fiber", setDecimalScale(dietFoodResumePojo.getFiber()));
			parameters.put("cholesterol", setDecimalScale(dietFoodResumePojo.getCholesterol()));
			parameters.put("sodium", setDecimalScale(dietFoodResumePojo.getSodium()));
			
			parametersFoodList.add(parameters);
		}
		
		return parametersFoodList;
	}
	
	private Map<String, Object> buildParametersDietFoods(List<DietFoodResumePojo> foodBaseResumePojos, List<DietFoodResumePojo> foodCustomResumePojos) {
		
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("_foods_diet_base_list", buildParametersDietFoodList(foodBaseResumePojos));
		parameters.put("_foods_diet_custom_list", buildParametersDietFoodList(foodCustomResumePojos));
		
		return parameters;
	}
	
	private Map<String, Object> buildParametersDietCustomReport(DietEntityPojo dietTotalsDataPojo, DietEntityPojo dietBaseDataPojo, DietEntityPojo dietCustomDataPojo, DietEntityPojo nutritionalGoalsDataPojo) {
		
		nutritionalGoalsDataPojo.setId(-1);
		dietTotalsDataPojo.setId(-1);
		
		List<Map<String, Object>> parametersDietTotals = new ArrayList<>();
		parametersDietTotals.add(buildParametersDietTotals(dietBaseDataPojo, "subTotal diet base"));
		parametersDietTotals.add(buildParametersDietTotals(dietCustomDataPojo, "subTotal diet custom"));
		parametersDietTotals.add(buildParametersDietTotals(dietTotalsDataPojo, "Totals"));
		parametersDietTotals.add(buildParametersDietTotals(nutritionalGoalsDataPojo, "Nutritional Goals"));
		
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("_diet_totals_list", parametersDietTotals);
		
		return parameters;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getParametersDietCustomReport(Integer id) {
		
		Diet dietBase = dietRepository.getDietBase();
		Diet dietCustom = id != null ? (Diet) genericCustomPersistance.findById(Diet.class, id) : new Diet();

		List<NutritionGoal> nutritionGoals = genericCustomPersistance.findAll(NutritionGoal.class);
		NutritionGoal nutritionGoal = nutritionGoals != null && !nutritionGoals.isEmpty() ? nutritionGoals.get(0) : null;
		
		if (id == null)
			dietCustom = dietUtil.generateDietZeros();
		
		DietEntityPojo dietTotalsDataPojo = new DietEntityPojo();
		dietTotalsDataPojo.setId(-1);
		dietTotalsDataPojo.setTotalCalories(dietBase.getTotalCalories().add(dietCustom.getTotalCalories()));
		dietTotalsDataPojo.setTotalQuantityGrams(dietBase.getTotalQuantityGrams().add(dietCustom.getTotalQuantityGrams()));
		dietTotalsDataPojo.setTotalProteins(dietBase.getTotalProteins().add(dietCustom.getTotalProteins()));
		dietTotalsDataPojo.setTotalCarbohydrates(dietBase.getTotalCarbohydrates().add(dietCustom.getTotalCarbohydrates()));
		dietTotalsDataPojo.setTotalCarbSugar(dietBase.getTotalCarbSugar().add(dietCustom.getTotalCarbSugar()));
		dietTotalsDataPojo.setTotalCarbSugarAdded(dietBase.getTotalCarbSugarAdded().add(dietCustom.getTotalCarbSugarAdded()));
		dietTotalsDataPojo.setTotalFat(dietBase.getTotalFat().add(dietCustom.getTotalFat()));
		dietTotalsDataPojo.setTotalFatMono(dietBase.getTotalFatMono().add(dietCustom.getTotalFatMono()));
		dietTotalsDataPojo.setTotalFatPoli(dietBase.getTotalFatPoli().add(dietCustom.getTotalFatPoli()));
		dietTotalsDataPojo.setTotalFatSat(dietBase.getTotalFatSat().add(dietCustom.getTotalFatSat()));
		dietTotalsDataPojo.setTotalFatTrans(dietBase.getTotalFatTrans().add(dietCustom.getTotalFatTrans()));
		dietTotalsDataPojo.setTotalCholesterol(dietBase.getTotalCholesterol().add(dietCustom.getTotalCholesterol()));
		dietTotalsDataPojo.setTotalFiber(dietBase.getTotalFiber().add(dietCustom.getTotalFiber()));
		dietTotalsDataPojo.setTotalSodium(dietBase.getTotalSodium().add(dietCustom.getTotalSodium()));
		
		DietEntityPojo dietBaseDataPojo = buildEntityToPojoUtil.generateDietPojo(null, dietBase);
		DietEntityPojo dietCustomDataPojo = buildEntityToPojoUtil.generateDietPojo(null, dietCustom);
		DietEntityPojo nutritionalGoalsDataPojo = (nutritionGoal != null) ? buildEntityToPojoUtil.generateNutritionalGoalPojo(null, nutritionGoal) : new DietEntityPojo();
		
		List<DietFoodResumePojo> dietFoodResumeEntityPojos = dietUtil.buildDietFoodsResume(dietBase.getDietFoods());
		dietFoodResumeEntityPojos.add(dietUtil.buildDietFoodTotals(dietBase.getDietFoods()));
		
		DietDataPojo dietDataPojo = null;
		List<DietFoodResumePojo> dietFoodDietCustomResumeEntityPojos = new ArrayList<>();
		
		if (id != null) {
			
			RecipeEntityPojo recipeDietCustomEntityPojo = buildEntityToPojoUtil.generateRecipePojo(null, dietCustom.getRecipe());
			DietEntityPojo dietCustomResumePojo = buildEntityToPojoUtil.generateDietPojo(null, dietCustom);
			
			dietFoodDietCustomResumeEntityPojos = dietUtil.buildDietFoodsResume(dietCustom.getDietFoods());
			dietFoodDietCustomResumeEntityPojos.add(dietUtil.buildDietFoodTotals(dietCustom.getDietFoods()));
			
			dietDataPojo = new DietDataPojo();
			dietDataPojo.setRecipe(recipeDietCustomEntityPojo);
			dietDataPojo.setDiet(dietCustomResumePojo);
			dietDataPojo.setFoods(dietFoodDietCustomResumeEntityPojos);
		}
		
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.putAll(buildParametersDietCustomReport(dietTotalsDataPojo, dietBaseDataPojo, dietCustomDataPojo, nutritionalGoalsDataPojo));
		parameters.putAll(buildParametersDietFoods(dietFoodResumeEntityPojos, dietFoodDietCustomResumeEntityPojos));
		
		parameters.put("_diet_title", dietCustom.getRecipe().getTitle());
		parameters.put("_recipe_instructions", dietCustom.getRecipe().getInstructions());
		
		return parameters;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public GetDietCustomReportDataPojo executeGetDietCustomReport(GetDietCustomReportRequestPojo requestPojo) throws FileNotFoundException, JRException {
		
		Map<String, Object> parameters = getParametersDietCustomReport(requestPojo.getId());
		
		PdfReportJasperConfigPojo reportJasperConfig = new PdfReportJasperConfigPojo();
		reportJasperConfig.setConfig(parameters);
		reportJasperConfig.setFullPath(false);
		reportJasperConfig.setReportPath("/_reports/diet/diet_control_resume_totals.jasper");
		
		List<PdfReportJasperConfigPojo> reportJasperConfigs = new ArrayList<>();
		reportJasperConfigs.add(reportJasperConfig);
		
		BuildPdfJasperUtil pdfJasperUtil = new BuildPdfJasperUtil();
		
		byte[] reportByte = pdfJasperUtil.reportPdf(reportJasperConfigs);
		String reportBase64 = Base64.getEncoder().encodeToString(reportByte);
		
		FilePojo filePojo = new FilePojo();
		filePojo.setFileBase64(reportBase64);
		
		GetDietCustomReportDataPojo responsePojo = new GetDietCustomReportDataPojo();
		responsePojo.setFile(filePojo);
		
		return responsePojo;
	}
}
