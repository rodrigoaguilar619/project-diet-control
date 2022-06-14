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
		foodEntity.setCostCalorie(foodEntityPojo.getCalories().compareTo(BigDecimal.valueOf(0.0)) == 0 ? BigDecimal.valueOf(0.0) : foodEntityPojo.getPrice().divide(foodEntityPojo.getCalories(), 2, RoundingMode.HALF_UP));
		foodEntity.setCostProtein(foodEntityPojo.getProteins().compareTo(BigDecimal.valueOf(0.0)) == 0 ? BigDecimal.valueOf(0.0) : foodEntityPojo.getPrice().divide(foodEntityPojo.getProteins(), 2, RoundingMode.HALF_UP));
		foodEntity.setUnityGrams(foodEntityPojo.getUnityGrams());
		foodEntity.setFatMono(foodEntityPojo.getFatMono());
		foodEntity.setFatPoli(foodEntityPojo.getFatPoli());
		foodEntity.setFatSat(foodEntityPojo.getFatSat());
		foodEntity.setFatTrans(foodEntityPojo.getFatTrans());
		foodEntity.setCarbSugar(foodEntityPojo.getCarbSugar());
		foodEntity.setCarbSugarAdded(foodEntityPojo.getCarbSugarAdded());
		foodEntity.setCholesterol(foodEntityPojo.getCholesterol());
		foodEntity.setSodium(foodEntityPojo.getSodium());
		foodEntity.setFiber(foodEntityPojo.getFiber());
		
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
		
		BigDecimal totalCalories = BigDecimal.valueOf(0.0);
		BigDecimal totalProteins = BigDecimal.valueOf(0.0);
		BigDecimal totalCarbohydrates = BigDecimal.valueOf(0.0);
		BigDecimal totalFats = BigDecimal.valueOf(0.0);
		BigDecimal totalGrams = BigDecimal.valueOf(0.0);
		BigDecimal totalFatMonos = BigDecimal.valueOf(0.0);
		BigDecimal totalFatPolis = BigDecimal.valueOf(0.0);
		BigDecimal totalFatSats = BigDecimal.valueOf(0.0);
		BigDecimal totalFatTrans = BigDecimal.valueOf(0.0);
		BigDecimal totalCarbSugars = BigDecimal.valueOf(0.0);
		BigDecimal totalCarbSugarAddeds = BigDecimal.valueOf(0.0);
		BigDecimal totalFiber = BigDecimal.valueOf(0.0);
		BigDecimal totalCholesterols = BigDecimal.valueOf(0.0);
		BigDecimal totalSodium = BigDecimal.valueOf(0.0);
		
		for (DietFoodEntityPojo dietFoodEntityPojo: dietEntityPojo.getFoods()) {
			
			Food food = (Food) genericCustomPersistance.findById(Food.class, dietFoodEntityPojo.getId());
			BigDecimal portions = dietFoodEntityPojo.getPortions();
			
			totalCalories = totalCalories.add(food.getCalories().multiply(portions));
			totalProteins = totalProteins.add(food.getProteins().multiply(portions));
			totalCarbohydrates = totalCarbohydrates.add(food.getCarbohydrates().multiply(portions));
			totalFats = totalFats.add(food.getFat().multiply(portions));
			totalGrams = totalGrams.add(food.getQuantityGrams().multiply(portions));
			totalFatMonos = totalFatMonos.add(food.getFatMono().multiply(portions));
			System.out.println("food " + food.getDescription());
			totalFatPolis = totalFatPolis.add(food.getFatPoli().multiply(portions));
			totalFatSats = totalFatSats.add(food.getFatSat().multiply(portions));
			totalFatTrans = totalFatTrans.add(food.getFatTrans().multiply(portions));
			totalCarbSugars =totalCarbSugars.add(food.getCarbSugar().multiply(portions));
			totalCarbSugarAddeds = totalCarbSugarAddeds.add(food.getCarbSugarAdded().multiply(portions));
			totalFiber = totalFiber.add(food.getFiber().multiply(portions));
			totalCholesterols = totalCholesterols.add(food.getCholesterol().multiply(portions));
			totalSodium = totalSodium.add(food.getSodium().multiply(portions));
		}
		
		dietEntity.setIsBase(dietEntityPojo.getIsBase());
		dietEntity.setIdRecipe(dietEntityPojo.getIdRecipe());
		dietEntity.setTotalCalories(totalCalories);
		dietEntity.setTotalProteins(totalProteins);
		dietEntity.setTotalCarbohydrates(totalCarbohydrates);
		dietEntity.setTotalFat(totalFats);
		dietEntity.setTotalQuantityGrams(totalGrams);
		dietEntity.setTotalFatMono(totalFatMonos);
		dietEntity.setTotalFatPoli(totalFatPolis);
		dietEntity.setTotalFatSat(totalFatSats);
		dietEntity.setTotalFatTrans(totalFatTrans);
		dietEntity.setTotalCarbSugar(totalCarbSugars);
		dietEntity.setTotalCarbSugarAdded(totalCarbSugarAddeds);
		dietEntity.setTotalCholesterol(totalCholesterols);
		dietEntity.setTotalFiber(totalFiber);
		dietEntity.setTotalSodium(totalSodium);
		
		return dietEntity;
	}
	
	@SuppressWarnings("unchecked")
	public DietFood generateDietFoodEntity(DietFood dietFoodEntity, DietFoodEntityPojo dietFoodEntityPojo, Integer idRecipe) {
		
		if(dietFoodEntity == null)
			dietFoodEntity = new DietFood();
		
		BigDecimal totalCalories = BigDecimal.valueOf(0.0);
		BigDecimal totalProteins = BigDecimal.valueOf(0.0);
		BigDecimal totalCarbohydrates = BigDecimal.valueOf(0.0);
		BigDecimal totalFats = BigDecimal.valueOf(0.0);
		BigDecimal totalGrams = BigDecimal.valueOf(0.0);
		BigDecimal totalFatMonos = BigDecimal.valueOf(0.0);
		BigDecimal totalFatPolis = BigDecimal.valueOf(0.0);
		BigDecimal totalFatSats = BigDecimal.valueOf(0.0);
		BigDecimal totalFatTrans = BigDecimal.valueOf(0.0);
		BigDecimal totalCarbSugars = BigDecimal.valueOf(0.0);
		BigDecimal totalCarbSugarAddeds = BigDecimal.valueOf(0.0);
		BigDecimal totalFiber = BigDecimal.valueOf(0.0);
		BigDecimal totalCholesterols = BigDecimal.valueOf(0.0);
		BigDecimal totalSodium = BigDecimal.valueOf(0.0);
		
		Food food = (Food) genericCustomPersistance.findById(Food.class, dietFoodEntityPojo.getId());
		BigDecimal portions = dietFoodEntityPojo.getPortions();
		
		totalCalories = totalCalories.add(food.getCalories().multiply(portions));
		totalProteins = totalProteins.add(food.getProteins().multiply(portions));
		totalCarbohydrates = totalCarbohydrates.add(food.getCarbohydrates().multiply(portions));
		totalFats = totalFats.add(food.getFat().multiply(portions));
		totalGrams = totalGrams.add(food.getQuantityGrams().multiply(portions));
		totalFatMonos = totalFatMonos.add(food.getFatMono().multiply(portions));
		totalFatPolis = totalFatPolis.add(food.getFatPoli().multiply(portions));
		totalFatSats = totalFatSats.add(food.getFatSat().multiply(portions));
		totalFatTrans = totalFatTrans.add(food.getFatTrans().multiply(portions));
		totalCarbSugars =totalCarbSugars.add(food.getCarbSugar().multiply(portions));
		totalCarbSugarAddeds = totalCarbSugarAddeds.add(food.getCarbSugarAdded().multiply(portions));
		totalFiber = totalFiber.add(food.getFiber().multiply(portions));
		totalCholesterols = totalCholesterols.add(food.getCholesterol().multiply(portions));
		totalSodium = totalSodium.add(food.getSodium().multiply(portions));
		
		dietFoodEntity.setFood(food);
		dietFoodEntity.setDiet(new Diet(idRecipe));
		dietFoodEntity.setPortions(dietFoodEntityPojo.getPortions());
		dietFoodEntity.setTotalCalories(totalCalories);
		dietFoodEntity.setTotalProteins(totalProteins);
		dietFoodEntity.setTotalCarbohydrates(totalCarbohydrates);
		dietFoodEntity.setTotalFat(totalFats);
		dietFoodEntity.setTotalQuantityGrams(totalGrams);
		dietFoodEntity.setUnities(dietFoodEntityPojo.getUnities() != null ? dietFoodEntityPojo.getUnities() : BigDecimal.valueOf(0.0));
		dietFoodEntity.setTotalFatMono(totalFatMonos);
		dietFoodEntity.setTotalFatPoli(totalFatPolis);
		dietFoodEntity.setTotalFatSat(totalFatSats);
		dietFoodEntity.setTotalFatTrans(totalFatTrans);
		dietFoodEntity.setTotalCarbSugar(totalCarbSugars);
		dietFoodEntity.setTotalCarbSugarAdded(totalCarbSugarAddeds);
		dietFoodEntity.setTotalCholesterol(totalCholesterols);
		dietFoodEntity.setTotalFiber(totalFiber);
		dietFoodEntity.setTotalSodium(totalSodium);
		
		return dietFoodEntity;
	}
	
	public NutritionGoal generateNutritionGoalEntity(NutritionGoal nutritionGoalEntity, NutritionGoalEntityPojo nutritionGoalEntityPojo) {
		
		if (nutritionGoalEntity == null)
			nutritionGoalEntity = new NutritionGoal();
		
		nutritionGoalEntity.setCalories(nutritionGoalEntityPojo.getCalories());
		nutritionGoalEntity.setCarbohydrates(nutritionGoalEntityPojo.getCarbohydrates());
		nutritionGoalEntity.setFat(nutritionGoalEntityPojo.getFat());
		nutritionGoalEntity.setProteins(nutritionGoalEntityPojo.getProteins());
		nutritionGoalEntity.setFatMono(nutritionGoalEntityPojo.getFatMono());
		nutritionGoalEntity.setFatPoli(nutritionGoalEntityPojo.getFatPoli());
		nutritionGoalEntity.setFatSat(nutritionGoalEntityPojo.getFatSat());
		nutritionGoalEntity.setFatTrans(nutritionGoalEntityPojo.getFatTrans());
		nutritionGoalEntity.setCarbSugar(nutritionGoalEntityPojo.getCarbSugar());
		nutritionGoalEntity.setCarbSugarAdded(nutritionGoalEntityPojo.getCarbSugarAdded());
		nutritionGoalEntity.setCholesterol(nutritionGoalEntityPojo.getCholesterol());
		nutritionGoalEntity.setSodium(nutritionGoalEntityPojo.getSodium());
		nutritionGoalEntity.setFiber(nutritionGoalEntityPojo.getFiber());
		
		return nutritionGoalEntity;
	}
}
