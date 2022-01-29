package project.diet.control.util;

import project.diet.control.beans.entity.Diet;
import project.diet.control.beans.entity.DietFood;
import project.diet.control.beans.entity.Food;
import project.diet.control.beans.entity.NutritionGoal;
import project.diet.control.beans.entity.Recipe;
import project.diet.control.pojos.diet.DietResumePojo;
import project.diet.control.pojos.entity.DietEntityPojo;
import project.diet.control.pojos.entity.FoodEntityPojo;
import project.diet.control.pojos.entity.NutritionGoalEntityPojo;
import project.diet.control.pojos.entity.RecipeEntityPojo;

public class BuildEntityToPojoUtil {

	public FoodEntityPojo generateFoodPojo(FoodEntityPojo foodEntityPojo, Food foodEntity) {
		
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
		
		return foodEntityPojo;
	}
	
	public FoodEntityPojo generateDietFoodPojo(FoodEntityPojo foodEntityPojo, DietFood dietFoodEntity, boolean mergeUnityGrams) {
		
		if (foodEntityPojo == null)
			foodEntityPojo = new FoodEntityPojo();
		
		foodEntityPojo.setId(dietFoodEntity.getFood().getId());
		foodEntityPojo.setDescription(dietFoodEntity.getFood().getDescription() + (mergeUnityGrams ? " (" + dietFoodEntity.getFood().getUnityGrams().toPlainString() + "gr)" : "" ));
		foodEntityPojo.setCalories(dietFoodEntity.getTotalCalories());
		foodEntityPojo.setCarbohydrates(dietFoodEntity.getTotalCarbohydrates());
		foodEntityPojo.setFat(dietFoodEntity.getTotalFat());
		foodEntityPojo.setProteins(dietFoodEntity.getTotalProteins());
		foodEntityPojo.setQuantityGrams(dietFoodEntity.getTotalQuantityGrams());
		foodEntityPojo.setPrice(dietFoodEntity.getFood().getPrice());
		foodEntityPojo.setCostCalorie(dietFoodEntity.getFood().getCostCalorie());
		foodEntityPojo.setCostProtein(dietFoodEntity.getFood().getCostProtein());
		foodEntityPojo.setUnityGrams(dietFoodEntity.getFood().getUnityGrams());
		
		return foodEntityPojo;
	}
	
	public RecipeEntityPojo generateRecipePojo(RecipeEntityPojo recipeEntityPojo, Recipe recipeEntity) {
		
		if (recipeEntityPojo == null)
			recipeEntityPojo = new RecipeEntityPojo();
		
		recipeEntityPojo.setId(recipeEntity.getId());
		recipeEntityPojo.setInstructions(recipeEntity.getInstructions());
		recipeEntityPojo.setTitle(recipeEntity.getTitle());
		
		return recipeEntityPojo;
	}
	
	public DietEntityPojo generateDietPojo(DietEntityPojo dietEntityPojo, Diet dietEntity) {
		
		if (dietEntityPojo == null)
			dietEntityPojo = new DietEntityPojo();
		
		dietEntityPojo.setIsBase(dietEntity.getIsBase());
		dietEntityPojo.setTotalCalories(dietEntity.getTotalCalories());
		dietEntityPojo.setTotalCarbohydrates(dietEntity.getTotalCarbohydrates());
		dietEntityPojo.setTotalFat(dietEntity.getTotalFat());
		dietEntityPojo.setTotalProteins(dietEntity.getTotalProteins());
		dietEntityPojo.setTotalQuantityGrams(dietEntity.getTotalQuantityGrams());
		
		return dietEntityPojo;
	}
	
	public DietResumePojo generateDietResumePojo(DietResumePojo dietResumePojo, Diet dietEntity) {
		
		if (dietResumePojo == null)
			dietResumePojo = new DietResumePojo();
		
		dietResumePojo = (DietResumePojo) generateDietPojo(dietResumePojo, dietEntity);
		dietResumePojo.setId(dietEntity.getIdRecipe());
		dietResumePojo.setRecipeTitle(dietEntity.getRecipe().getTitle());
		
		return dietResumePojo;
	}
	
	public NutritionGoalEntityPojo generateNutritionGoalEntityPojo(NutritionGoalEntityPojo nutritionGoalEntityPojo, NutritionGoal nutritionGoalEntity) {
		
		if (nutritionGoalEntityPojo == null)
			nutritionGoalEntityPojo = new NutritionGoalEntityPojo();
		
		nutritionGoalEntityPojo.setCalories(nutritionGoalEntity.getCalories());
		nutritionGoalEntityPojo.setCarbohydrates(nutritionGoalEntity.getCarbohydrates());
		nutritionGoalEntityPojo.setFat(nutritionGoalEntity.getFat());
		nutritionGoalEntityPojo.setProteins(nutritionGoalEntity.getProteins());
		
		return nutritionGoalEntityPojo;
	}
}
