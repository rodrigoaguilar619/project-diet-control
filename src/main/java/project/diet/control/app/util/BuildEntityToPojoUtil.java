package project.diet.control.app.util;

import project.diet.control.app.beans.entity.DietEntity;
import project.diet.control.app.beans.entity.DietFoodEntity;
import project.diet.control.app.beans.entity.FoodEntity;
import project.diet.control.app.beans.entity.NutritionGoalEntity;
import project.diet.control.app.beans.entity.RecipeEntity;
import project.diet.control.app.beans.pojos.diet.DietResumePojo;
import project.diet.control.app.beans.pojos.entity.DietEntityPojo;
import project.diet.control.app.beans.pojos.entity.FoodEntityPojo;
import project.diet.control.app.beans.pojos.entity.NutritionGoalEntityPojo;
import project.diet.control.app.beans.pojos.entity.RecipeEntityPojo;

public class BuildEntityToPojoUtil {

	public FoodEntityPojo generateFoodPojo(FoodEntityPojo foodEntityPojo, FoodEntity foodEntity) {
		
		if (foodEntityPojo == null)
			foodEntityPojo = new FoodEntityPojo();
		
		foodEntityPojo.setId(foodEntity.getId());
		foodEntityPojo.setDescription(foodEntity.getDescription());
		foodEntityPojo.setCalories(foodEntity.getCalories());
		foodEntityPojo.setCarbohydrates(foodEntity.getCarbohydrates());
		foodEntityPojo.setFat(foodEntity.getFat());
		foodEntityPojo.setProteins(foodEntity.getProteins());
		foodEntityPojo.setQuantityGrams(foodEntity.getQuantityGrams());
		foodEntityPojo.setPrice(foodEntity.getPrice());
		foodEntityPojo.setCostCalorie(foodEntity.getCostCalorie());
		foodEntityPojo.setCostProtein(foodEntity.getCostProtein());
		foodEntityPojo.setUnityGrams(foodEntity.getUnityGrams());
		foodEntityPojo.setFatMono(foodEntity.getFatMono());
		foodEntityPojo.setFatPoli(foodEntity.getFatPoli());
		foodEntityPojo.setFatSat(foodEntity.getFatSat());
		foodEntityPojo.setFatTrans(foodEntity.getFatTrans());
		foodEntityPojo.setCarbSugar(foodEntity.getCarbSugar());
		foodEntityPojo.setCarbSugarAdded(foodEntity.getCarbSugarAdded());
		foodEntityPojo.setCholesterol(foodEntity.getCholesterol());
		foodEntityPojo.setSodium(foodEntity.getSodium());
		foodEntityPojo.setFiber(foodEntity.getFiber());
		
		return foodEntityPojo;
	}
	
	public FoodEntityPojo generateDietFoodPojo(FoodEntityPojo foodEntityPojo, DietFoodEntity dietFoodEntity, boolean mergeUnityGrams) {
		
		if (foodEntityPojo == null)
			foodEntityPojo = new FoodEntityPojo();
		
		foodEntityPojo.setId(dietFoodEntity.getFood().getId());
		foodEntityPojo.setDescription(dietFoodEntity.getFood().getDescription() + (mergeUnityGrams ? " (" + dietFoodEntity.getFood().getUnityGrams().toPlainString() + " gr)" : "" ));
		foodEntityPojo.setCalories(dietFoodEntity.getTotalCalories());
		foodEntityPojo.setCarbohydrates(dietFoodEntity.getTotalCarbohydrates());
		foodEntityPojo.setFat(dietFoodEntity.getTotalFat());
		foodEntityPojo.setProteins(dietFoodEntity.getTotalProteins());
		foodEntityPojo.setQuantityGrams(dietFoodEntity.getTotalQuantityGrams());
		foodEntityPojo.setPrice(dietFoodEntity.getFood().getPrice());
		foodEntityPojo.setCostCalorie(dietFoodEntity.getFood().getCostCalorie());
		foodEntityPojo.setCostProtein(dietFoodEntity.getFood().getCostProtein());
		foodEntityPojo.setUnityGrams(dietFoodEntity.getFood().getUnityGrams());
		foodEntityPojo.setFatMono(dietFoodEntity.getTotalFatMono());
		foodEntityPojo.setFatPoli(dietFoodEntity.getTotalFatPoli());
		foodEntityPojo.setFatSat(dietFoodEntity.getTotalFatSat());
		foodEntityPojo.setFatTrans(dietFoodEntity.getTotalFatTrans());
		foodEntityPojo.setCarbSugar(dietFoodEntity.getTotalCarbSugar());
		foodEntityPojo.setCarbSugarAdded(dietFoodEntity.getTotalCarbSugarAdded());
		foodEntityPojo.setCholesterol(dietFoodEntity.getTotalCholesterol());
		foodEntityPojo.setFiber(dietFoodEntity.getTotalFiber());
		foodEntityPojo.setSodium(dietFoodEntity.getTotalSodium());
		
		return foodEntityPojo;
	}
	
	public RecipeEntityPojo generateRecipePojo(RecipeEntityPojo recipeEntityPojo, RecipeEntity recipeEntity) {
		
		if (recipeEntityPojo == null)
			recipeEntityPojo = new RecipeEntityPojo();
		
		recipeEntityPojo.setId(recipeEntity.getId());
		recipeEntityPojo.setInstructions(recipeEntity.getInstructions());
		recipeEntityPojo.setTitle(recipeEntity.getTitle());
		
		return recipeEntityPojo;
	}
	
	public DietEntityPojo generateDietPojo(DietEntityPojo dietEntityPojo, DietEntity dietEntity) {
		
		if (dietEntityPojo == null)
			dietEntityPojo = new DietEntityPojo();
		
		dietEntityPojo.setIsBase(dietEntity.getIsBase());
		dietEntityPojo.setTotalCalories(dietEntity.getTotalCalories());
		dietEntityPojo.setTotalCarbohydrates(dietEntity.getTotalCarbohydrates());
		dietEntityPojo.setTotalFat(dietEntity.getTotalFat());
		dietEntityPojo.setTotalProteins(dietEntity.getTotalProteins());
		dietEntityPojo.setTotalQuantityGrams(dietEntity.getTotalQuantityGrams());
		dietEntityPojo.setTotalFatMono(dietEntity.getTotalFatMono());
		dietEntityPojo.setTotalFatPoli(dietEntity.getTotalFatPoli());
		dietEntityPojo.setTotalFatSat(dietEntity.getTotalFatSat());
		dietEntityPojo.setTotalFatTrans(dietEntity.getTotalFatTrans());
		dietEntityPojo.setTotalCarbSugar(dietEntity.getTotalCarbSugar());
		dietEntityPojo.setTotalCarbSugarAdded(dietEntity.getTotalCarbSugarAdded());
		dietEntityPojo.setTotalCholesterol(dietEntity.getTotalCholesterol());
		dietEntityPojo.setTotalFiber(dietEntity.getTotalFiber());
		dietEntityPojo.setTotalSodium(dietEntity.getTotalSodium());
		
		return dietEntityPojo;
	}
	
	public DietResumePojo generateDietResumePojo(DietResumePojo dietResumePojo, DietEntity dietEntity) {
		
		if (dietResumePojo == null)
			dietResumePojo = new DietResumePojo();
		
		dietResumePojo = (DietResumePojo) generateDietPojo(dietResumePojo, dietEntity);
		dietResumePojo.setId(dietEntity.getIdRecipe());
		dietResumePojo.setRecipeTitle(dietEntity.getRecipe().getTitle());
		
		return dietResumePojo;
	}
	
	public NutritionGoalEntityPojo generateNutritionGoalEntityPojo(NutritionGoalEntityPojo nutritionGoalEntityPojo, NutritionGoalEntity nutritionGoalEntity) {
		
		if (nutritionGoalEntityPojo == null)
			nutritionGoalEntityPojo = new NutritionGoalEntityPojo();
		
		nutritionGoalEntityPojo.setCalories(nutritionGoalEntity.getCalories());
		nutritionGoalEntityPojo.setCarbohydrates(nutritionGoalEntity.getCarbohydrates());
		nutritionGoalEntityPojo.setFat(nutritionGoalEntity.getFat());
		nutritionGoalEntityPojo.setProteins(nutritionGoalEntity.getProteins());
		nutritionGoalEntityPojo.setFatMono(nutritionGoalEntity.getFatMono());
		nutritionGoalEntityPojo.setFatPoli(nutritionGoalEntity.getFatPoli());
		nutritionGoalEntityPojo.setFatSat(nutritionGoalEntity.getFatSat());
		nutritionGoalEntityPojo.setFatTrans(nutritionGoalEntity.getFatTrans());
		nutritionGoalEntityPojo.setCarbSugar(nutritionGoalEntity.getCarbSugar());
		nutritionGoalEntityPojo.setCarbSugarAdded(nutritionGoalEntity.getCarbSugarAdded());
		nutritionGoalEntityPojo.setCholesterol(nutritionGoalEntity.getCholesterol());
		nutritionGoalEntityPojo.setFiber(nutritionGoalEntity.getFiber());
		nutritionGoalEntityPojo.setSodium(nutritionGoalEntity.getSodium());
		
		return nutritionGoalEntityPojo;
	}
	
	public DietEntityPojo generateNutritionalGoalPojo(DietEntityPojo nutritionalGoalsDataPojo, NutritionGoalEntity nutritionGoalEntity) {
		
		if (nutritionalGoalsDataPojo == null)
			nutritionalGoalsDataPojo = new DietEntityPojo();
		
		nutritionalGoalsDataPojo.setTotalCalories(nutritionGoalEntity.getCalories());
		nutritionalGoalsDataPojo.setTotalCarbohydrates(nutritionGoalEntity.getCarbohydrates());
		nutritionalGoalsDataPojo.setTotalFat(nutritionGoalEntity.getFat());
		nutritionalGoalsDataPojo.setTotalProteins(nutritionGoalEntity.getProteins());
		nutritionalGoalsDataPojo.setTotalFatMono(nutritionGoalEntity.getFatMono());
		nutritionalGoalsDataPojo.setTotalFatPoli(nutritionGoalEntity.getFatPoli());
		nutritionalGoalsDataPojo.setTotalFatSat(nutritionGoalEntity.getFatSat());
		nutritionalGoalsDataPojo.setTotalFatTrans(nutritionGoalEntity.getFatTrans());
		nutritionalGoalsDataPojo.setTotalCarbSugar(nutritionGoalEntity.getCarbSugar());
		nutritionalGoalsDataPojo.setTotalCarbSugarAdded(nutritionGoalEntity.getCarbSugarAdded());
		nutritionalGoalsDataPojo.setTotalFiber(nutritionGoalEntity.getFiber());
		nutritionalGoalsDataPojo.setTotalCholesterol(nutritionGoalEntity.getCholesterol());
		nutritionalGoalsDataPojo.setTotalSodium(nutritionGoalEntity.getSodium());
		
		return nutritionalGoalsDataPojo;
	}
}
