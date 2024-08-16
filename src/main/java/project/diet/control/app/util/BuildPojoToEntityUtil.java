package project.diet.control.app.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import project.diet.control.app.beans.entity.DietEntity;
import project.diet.control.app.beans.entity.DietFoodEntity;
import project.diet.control.app.beans.entity.FoodEntity;
import project.diet.control.app.beans.entity.NutritionGoalEntity;
import project.diet.control.app.beans.entity.RecipeEntity;
import project.diet.control.app.beans.pojos.custom.NutrientPojo;
import project.diet.control.app.beans.pojos.entity.DietFoodEntityPojo;
import project.diet.control.app.beans.pojos.entity.FoodEntityPojo;
import project.diet.control.app.beans.pojos.entity.NutritionGoalEntityPojo;
import project.diet.control.app.beans.pojos.entity.RecipeEntityPojo;

public class BuildPojoToEntityUtil {

	public NutrientPojo initNutrient() {
		
		NutrientPojo nutrientPojo = new NutrientPojo();
		
		nutrientPojo.setTotalCalories(BigDecimal.valueOf(0.0));
		nutrientPojo.setTotalProteins(BigDecimal.valueOf(0.0));
		nutrientPojo.setTotalCarbohydrates(BigDecimal.valueOf(0.0));
		nutrientPojo.setTotalFats(BigDecimal.valueOf(0.0));
		nutrientPojo.setTotalGrams(BigDecimal.valueOf(0.0));
		nutrientPojo.setTotalFatMonos(BigDecimal.valueOf(0.0));
		nutrientPojo.setTotalFatPolis(BigDecimal.valueOf(0.0));
		nutrientPojo.setTotalFatSats(BigDecimal.valueOf(0.0));
		nutrientPojo.setTotalFatTrans(BigDecimal.valueOf(0.0));
		nutrientPojo.setTotalCarbSugars(BigDecimal.valueOf(0.0));
		nutrientPojo.setTotalCarbSugarAddeds(BigDecimal.valueOf(0.0));
		nutrientPojo.setTotalFiber(BigDecimal.valueOf(0.0));
		nutrientPojo.setTotalCholesterols(BigDecimal.valueOf(0.0));
		nutrientPojo.setTotalSodium(BigDecimal.valueOf(0.0));
		
		return nutrientPojo;
	}
	
	public void mapNutrientFood(NutrientPojo nutrientPojo, FoodEntity food, BigDecimal portions) {
		
		nutrientPojo.setTotalCalories(nutrientPojo.getTotalCalories().add(food.getCalories().multiply(portions)));
		nutrientPojo.setTotalProteins(nutrientPojo.getTotalProteins().add(food.getProteins().multiply(portions)));
		nutrientPojo.setTotalCarbohydrates(nutrientPojo.getTotalCarbohydrates().add(food.getCarbohydrates().multiply(portions)));
		nutrientPojo.setTotalFats(nutrientPojo.getTotalFats().add(food.getFat().multiply(portions)));
		nutrientPojo.setTotalGrams(nutrientPojo.getTotalGrams().add(food.getQuantityGrams().multiply(portions)));
		nutrientPojo.setTotalFatMonos(nutrientPojo.getTotalFatMonos().add(food.getFatMono().multiply(portions)));
		nutrientPojo.setTotalFatPolis(nutrientPojo.getTotalFatPolis().add(food.getFatPoli().multiply(portions)));
		nutrientPojo.setTotalFatSats(nutrientPojo.getTotalFatSats().add(food.getFatSat().multiply(portions)));
		nutrientPojo.setTotalFatTrans(nutrientPojo.getTotalFatTrans().add(food.getFatTrans().multiply(portions)));
		nutrientPojo.setTotalCarbSugars(nutrientPojo.getTotalCarbSugars().add(food.getCarbSugar().multiply(portions)));
		nutrientPojo.setTotalCarbSugarAddeds(nutrientPojo.getTotalCarbSugarAddeds().add(food.getCarbSugarAdded().multiply(portions)));
		nutrientPojo.setTotalFiber(nutrientPojo.getTotalFiber().add(food.getFiber().multiply(portions)));
		nutrientPojo.setTotalCholesterols(nutrientPojo.getTotalCholesterols().add(food.getCholesterol().multiply(portions)));
		nutrientPojo.setTotalSodium(nutrientPojo.getTotalSodium().add(food.getSodium().multiply(portions)));
	}

	public FoodEntity generateFoodEntity(FoodEntity foodEntity, FoodEntityPojo foodEntityPojo) {
		
		if (foodEntity == null)
			foodEntity = new FoodEntity();
		
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
	
	public RecipeEntity generateRecipeEntity(RecipeEntity recipeEntity, RecipeEntityPojo recipeEntityPojo) {
		
		if (recipeEntity == null)
			recipeEntity = new RecipeEntity();
		
		recipeEntity.setInstructions(recipeEntityPojo.getInstructions());
		recipeEntity.setTitle(recipeEntityPojo.getTitle());
		
		return recipeEntity;
	}
	
	public DietFoodEntity generateDietFoodEntity(DietFoodEntity dietFoodEntity, FoodEntity food, DietFoodEntityPojo dietFoodEntityPojo, Integer idRecipe) {
		
		if(dietFoodEntity == null)
			dietFoodEntity = new DietFoodEntity();
		
		NutrientPojo nutrientPojo = initNutrient();
		
		mapNutrientFood(nutrientPojo, food, dietFoodEntityPojo.getPortions());
		
		dietFoodEntity.setFood(food);
		dietFoodEntity.setDiet(new DietEntity(idRecipe));
		dietFoodEntity.setPortions(dietFoodEntityPojo.getPortions());
		dietFoodEntity.setTotalCalories(nutrientPojo.getTotalCalories());
		dietFoodEntity.setTotalProteins(nutrientPojo.getTotalProteins());
		dietFoodEntity.setTotalCarbohydrates(nutrientPojo.getTotalCarbohydrates());
		dietFoodEntity.setTotalFat(nutrientPojo.getTotalFats());
		dietFoodEntity.setTotalQuantityGrams(nutrientPojo.getTotalGrams());
		dietFoodEntity.setUnities(dietFoodEntityPojo.getUnities() != null ? dietFoodEntityPojo.getUnities() : BigDecimal.valueOf(0.0));
		dietFoodEntity.setTotalFatMono(nutrientPojo.getTotalFatMonos());
		dietFoodEntity.setTotalFatPoli(nutrientPojo.getTotalFatPolis());
		dietFoodEntity.setTotalFatSat(nutrientPojo.getTotalFatSats());
		dietFoodEntity.setTotalFatTrans(nutrientPojo.getTotalFatTrans());
		dietFoodEntity.setTotalCarbSugar(nutrientPojo.getTotalCarbSugars());
		dietFoodEntity.setTotalCarbSugarAdded(nutrientPojo.getTotalCarbSugarAddeds());
		dietFoodEntity.setTotalCholesterol(nutrientPojo.getTotalCholesterols());
		dietFoodEntity.setTotalFiber(nutrientPojo.getTotalFiber());
		dietFoodEntity.setTotalSodium(nutrientPojo.getTotalSodium());
		
		return dietFoodEntity;
	}
	
	public NutritionGoalEntity generateNutritionGoalEntity(NutritionGoalEntity nutritionGoalEntity, NutritionGoalEntityPojo nutritionGoalEntityPojo) {
		
		if (nutritionGoalEntity == null)
			nutritionGoalEntity = new NutritionGoalEntity();
		
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
