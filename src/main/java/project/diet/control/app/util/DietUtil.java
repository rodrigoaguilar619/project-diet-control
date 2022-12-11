package project.diet.control.app.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import project.diet.control.app.beans.entity.Diet;
import project.diet.control.app.beans.entity.DietFood;
import project.diet.control.app.beans.pojos.diet.DietFoodResumePojo;

public class DietUtil {
	
	@Autowired
	protected BuildEntityToPojoUtil buildEntityToPojoUtil;

	public Diet generateDietZeros() {
		
		Diet dietCustom = new Diet();
		dietCustom.setIsBase(false);
		dietCustom.setTotalCalories(BigDecimal.valueOf(0.0));
		dietCustom.setTotalCarbohydrates(BigDecimal.valueOf(0.0));
		dietCustom.setTotalFat(BigDecimal.valueOf(0.0));
		dietCustom.setTotalProteins(BigDecimal.valueOf(0.0));
		dietCustom.setTotalQuantityGrams(BigDecimal.valueOf(0.0));
		dietCustom.setTotalFatMono(BigDecimal.valueOf(0.0));
		dietCustom.setTotalFatPoli(BigDecimal.valueOf(0.0));
		dietCustom.setTotalFatSat(BigDecimal.valueOf(0.0));
		dietCustom.setTotalFatTrans(BigDecimal.valueOf(0.0));
		dietCustom.setTotalCarbSugar(BigDecimal.valueOf(0.0));
		dietCustom.setTotalCarbSugarAdded(BigDecimal.valueOf(0.0));
		dietCustom.setTotalFiber(BigDecimal.valueOf(0.0));
		dietCustom.setTotalSodium(BigDecimal.valueOf(0.0));
		dietCustom.setTotalCholesterol(BigDecimal.valueOf(0.0));
		
		return dietCustom;
	}
	
	public List<DietFoodResumePojo> buildDietFoodsResume(List<DietFood> dietFoods) {
		
		List<DietFoodResumePojo> dietFoodResumeEntityPojos = new ArrayList<>();
		
		for (DietFood dietFood: dietFoods) {
			
			DietFoodResumePojo dietFoodResumeEntityPojo = (DietFoodResumePojo) buildEntityToPojoUtil.generateDietFoodPojo(new DietFoodResumePojo(), dietFood, true);
			dietFoodResumeEntityPojo.setIdDietFood(dietFood.getId());
			dietFoodResumeEntityPojo.setPortions(dietFood.getPortions());
			dietFoodResumeEntityPojo.setUnities(dietFood.getUnities() != null ? dietFood.getUnities() : BigDecimal.valueOf(0.0));
			
			dietFoodResumeEntityPojos.add(dietFoodResumeEntityPojo);
		}
		
		return dietFoodResumeEntityPojos;
	}
	
	public DietFoodResumePojo buildDietFoodTotals(List<DietFood> dietFoods) {
		
		DietFoodResumePojo foodEntityPojo = new DietFoodResumePojo();
		foodEntityPojo.setId(-1);
		foodEntityPojo.setDescription("Totals");
		foodEntityPojo.setCalories(BigDecimal.valueOf(0.0));
		foodEntityPojo.setCarbohydrates(BigDecimal.valueOf(0.0));
		foodEntityPojo.setFat(BigDecimal.valueOf(0.0));
		foodEntityPojo.setProteins(BigDecimal.valueOf(0.0));
		foodEntityPojo.setQuantityGrams(BigDecimal.valueOf(0.0));
		foodEntityPojo.setFatMono(BigDecimal.valueOf(0.0));
		foodEntityPojo.setFatPoli(BigDecimal.valueOf(0.0));
		foodEntityPojo.setFatSat(BigDecimal.valueOf(0.0));
		foodEntityPojo.setFatTrans(BigDecimal.valueOf(0.0));
		foodEntityPojo.setCarbSugar(BigDecimal.valueOf(0.0));
		foodEntityPojo.setCarbSugarAdded(BigDecimal.valueOf(0.0));
		foodEntityPojo.setFiber(BigDecimal.valueOf(0.0));
		foodEntityPojo.setSodium(BigDecimal.valueOf(0.0));
		foodEntityPojo.setCholesterol(BigDecimal.valueOf(0.0));
		
		for (DietFood dietFood: dietFoods) {
			
			foodEntityPojo.setQuantityGrams(foodEntityPojo.getQuantityGrams().add(dietFood.getTotalQuantityGrams()));
			foodEntityPojo.setCalories(foodEntityPojo.getCalories().add(dietFood.getTotalCalories()));
			foodEntityPojo.setProteins(foodEntityPojo.getProteins().add(dietFood.getTotalProteins()));
			foodEntityPojo.setCarbohydrates(foodEntityPojo.getCarbohydrates().add(dietFood.getTotalCarbohydrates()));
			foodEntityPojo.setFat(foodEntityPojo.getFat().add(dietFood.getTotalFat()));
			foodEntityPojo.setFatMono(foodEntityPojo.getFatMono().add(dietFood.getTotalFatMono()));
			foodEntityPojo.setFatPoli(foodEntityPojo.getFatPoli().add(dietFood.getTotalFatPoli()));
			foodEntityPojo.setFatSat(foodEntityPojo.getFatSat().add(dietFood.getTotalFatSat()));
			foodEntityPojo.setFatTrans(foodEntityPojo.getFatTrans().add(dietFood.getTotalFatTrans()));
			foodEntityPojo.setCarbSugar(foodEntityPojo.getCarbSugar().add(dietFood.getTotalCarbSugar()));
			foodEntityPojo.setCarbSugarAdded(foodEntityPojo.getCarbSugarAdded().add(dietFood.getTotalCarbSugarAdded()));
			foodEntityPojo.setFiber(foodEntityPojo.getFiber().add(dietFood.getTotalFiber()));
			foodEntityPojo.setCholesterol(foodEntityPojo.getCholesterol().add(dietFood.getTotalCholesterol()));
			foodEntityPojo.setSodium(foodEntityPojo.getSodium().add(dietFood.getTotalSodium()));
		}
		
		return foodEntityPojo;
	}
}