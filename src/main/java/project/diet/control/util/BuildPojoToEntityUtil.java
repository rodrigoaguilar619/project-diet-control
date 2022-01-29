package project.diet.control.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;

import lib.base.backend.persistance.GenericPersistence;
import project.diet.control.beans.entity.Diet;
import project.diet.control.beans.entity.DietFood;
import project.diet.control.beans.entity.Food;
import project.diet.control.beans.entity.NutritionGoal;
import project.diet.control.beans.entity.Recipe;
import project.diet.control.pojos.diet.DietPojo;
import project.diet.control.pojos.entity.DietFoodEntityPojo;
import project.diet.control.pojos.entity.FoodEntityPojo;
import project.diet.control.pojos.entity.NutritionGoalEntityPojo;
import project.diet.control.pojos.entity.RecipeEntityPojo;

public class BuildPojoToEntityUtil {
	
	@SuppressWarnings("rawtypes")
	@Autowired
	GenericPersistence genericCustomPersistance;

	public Food generateFoodEntity(Food foodEntity, FoodEntityPojo foodEntityPojo) {
		
		if (foodEntity == null)
			foodEntity = new Food();
		
		foodEntity.setCalories(foodEntityPojo.getCalories());
		foodEntity.setCarbohydrates(foodEntityPojo.getCarbohydrates());
		foodEntity.setDescription(foodEntityPojo.getDescription());
		foodEntity.setFat(foodEntityPojo.getFat());
		foodEntity.setId(foodEntityPojo.getId());
		foodEntity.setProteins(foodEntityPojo.getProteins());
		foodEntity.setQuantityGrams(foodEntityPojo.getQuantityGrams());
		foodEntity.setPrice(foodEntityPojo.getPrice());
		foodEntity.setCostCalorie(foodEntityPojo.getPrice().divide(foodEntityPojo.getCalories(), 2, RoundingMode.HALF_UP));
		foodEntity.setCostProtein(foodEntityPojo.getProteins().compareTo(new BigDecimal(0.0)) == 0 ? new BigDecimal(0.0) : foodEntityPojo.getPrice().divide(foodEntityPojo.getProteins(), 2, RoundingMode.HALF_UP));
		foodEntity.setUnityGrams(foodEntityPojo.getUnityGrams());
		
		return foodEntity;
	}
	
	public Recipe generateRecipeEntity(Recipe recipeEntity, RecipeEntityPojo recipeEntityPojo) {
		
		if (recipeEntity == null)
			recipeEntity = new Recipe();
		
		recipeEntity.setInstructions(recipeEntityPojo.getInstructions());
		recipeEntity.setTitle(recipeEntityPojo.getTitle());
		
		return recipeEntity;
	}
	
	@SuppressWarnings("unchecked")
	public Diet generateDietEntity(Diet dietEntity, DietPojo dietEntityPojo) {
		
		if(dietEntity == null)
			dietEntity = new Diet();
		
		BigDecimal totalCalories = new BigDecimal(0.0);
		BigDecimal totalProteins = new BigDecimal(0.0);
		BigDecimal totalCarbohydrates = new BigDecimal(0.0);
		BigDecimal totalFats = new BigDecimal(0.0);
		BigDecimal totalGrams = new BigDecimal(0.0);
		
		for (DietFoodEntityPojo dietFoodEntityPojo: dietEntityPojo.getFoods()) {
			
			Food food = (Food) genericCustomPersistance.findById(Food.class, dietFoodEntityPojo.getId());
			BigDecimal portions = dietFoodEntityPojo.getPortions();
			
			totalCalories = totalCalories.add(food.getCalories().multiply(portions));
			totalProteins = totalProteins.add(food.getProteins().multiply(portions));
			totalCarbohydrates = totalCarbohydrates.add(food.getCarbohydrates().multiply(portions));
			totalFats = totalFats.add(food.getFat().multiply(portions));
			totalGrams = totalGrams.add(food.getQuantityGrams().multiply(portions));
		}
		
		dietEntity.setIsBase(dietEntityPojo.getIsBase());
		dietEntity.setIdRecipe(dietEntityPojo.getIdRecipe());
		dietEntity.setTotalCalories(totalCalories);
		dietEntity.setTotalProteins(totalProteins);
		dietEntity.setTotalCarbohydrates(totalCarbohydrates);
		dietEntity.setTotalFat(totalFats);
		dietEntity.setTotalQuantityGrams(totalGrams);
		
		return dietEntity;
	}
	
	@SuppressWarnings("unchecked")
	public DietFood generateDietFoodEntity(DietFood dietFoodEntity, DietFoodEntityPojo dietFoodEntityPojo, Integer idRecipe) {
		
		if(dietFoodEntity == null)
			dietFoodEntity = new DietFood();
		
		BigDecimal totalCalories = new BigDecimal(0.0);
		BigDecimal totalProteins = new BigDecimal(0.0);
		BigDecimal totalCarbohydrates = new BigDecimal(0.0);
		BigDecimal totalFats = new BigDecimal(0.0);
		BigDecimal totalGrams = new BigDecimal(0.0);
		
		Food food = (Food) genericCustomPersistance.findById(Food.class, dietFoodEntityPojo.getId());
		BigDecimal portions = dietFoodEntityPojo.getPortions();
		
		totalCalories = totalCalories.add(food.getCalories().multiply(portions));
		totalProteins = totalProteins.add(food.getProteins().multiply(portions));
		totalCarbohydrates = totalCarbohydrates.add(food.getCarbohydrates().multiply(portions));
		totalFats = totalFats.add(food.getFat().multiply(portions));
		totalGrams = totalGrams.add(food.getQuantityGrams().multiply(portions));
		
		dietFoodEntity.setFood(food);
		dietFoodEntity.setDiet(new Diet(idRecipe));
		dietFoodEntity.setPortions(dietFoodEntityPojo.getPortions());
		dietFoodEntity.setTotalCalories(totalCalories);
		dietFoodEntity.setTotalProteins(totalProteins);
		dietFoodEntity.setTotalCarbohydrates(totalCarbohydrates);
		dietFoodEntity.setTotalFat(totalFats);
		dietFoodEntity.setTotalQuantityGrams(totalGrams);
		dietFoodEntity.setUnities(dietFoodEntityPojo.getUnities() != null ? dietFoodEntityPojo.getUnities() : new BigDecimal(0.0));
		//dietFoodEntity.setUnities(food.getUnityGrams().compareTo(new BigDecimal(0.0)) != 0 ? (portions.multiply(food.getQuantityGrams())).divide(food.getUnityGrams(), 2) : new BigDecimal(0.0));
		
		return dietFoodEntity;
	}
	
	public NutritionGoal generateNutritionGoalEntity(NutritionGoal nutritionGoalEntity, NutritionGoalEntityPojo nutritionGoalEntityPojo) {
		
		if (nutritionGoalEntity == null)
			nutritionGoalEntity = new NutritionGoal();
		
		nutritionGoalEntity.setCalories(nutritionGoalEntityPojo.getCalories());
		nutritionGoalEntity.setCarbohydrates(nutritionGoalEntityPojo.getCarbohydrates());
		nutritionGoalEntity.setFat(nutritionGoalEntityPojo.getFat());
		nutritionGoalEntity.setProteins(nutritionGoalEntityPojo.getProteins());
		
		return nutritionGoalEntity;
	}
}
