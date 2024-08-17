package project.diet.control.config.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lib.base.backend.persistance.GenericPersistence;
import project.diet.control.app.beans.entity.DietEntity;
import project.diet.control.app.beans.entity.FoodEntity;
import project.diet.control.app.beans.pojos.custom.NutrientPojo;
import project.diet.control.app.beans.pojos.diet.DietPojo;
import project.diet.control.app.beans.pojos.entity.DietFoodEntityPojo;
import project.diet.control.app.util.BuildPojoToEntityUtil;

@Component
public class DietHelper {
	
	@SuppressWarnings("rawtypes")
	protected GenericPersistence genericPersistance;
	
	private BuildPojoToEntityUtil buildPojoToEntityUtil = new BuildPojoToEntityUtil();
	
	@SuppressWarnings("rawtypes")
	@Autowired
	public DietHelper(GenericPersistence genericPersistance) {
		this.genericPersistance = genericPersistance;
	}

	@SuppressWarnings("unchecked")
	public DietEntity generateDietEntity(DietEntity dietEntity, DietPojo dietEntityPojo) {
		
		if(dietEntity == null)
			dietEntity = new DietEntity();
		
		NutrientPojo nutrientPojo = buildPojoToEntityUtil.initNutrient();
		
		for (DietFoodEntityPojo dietFoodEntityPojo: dietEntityPojo.getFoods()) {
			FoodEntity food = (FoodEntity) genericPersistance.findById(FoodEntity.class, dietFoodEntityPojo.getId());
			buildPojoToEntityUtil.mapNutrientFood(nutrientPojo, food, dietFoodEntityPojo.getPortions());
		}
		
		dietEntity.setIsBase(dietEntityPojo.getIsBase());
		dietEntity.setIdRecipe(dietEntityPojo.getIdRecipe());
		dietEntity.setTotalCalories(nutrientPojo.getTotalCalories());
		dietEntity.setTotalProteins(nutrientPojo.getTotalProteins());
		dietEntity.setTotalCarbohydrates(nutrientPojo.getTotalCarbohydrates());
		dietEntity.setTotalFat(nutrientPojo.getTotalFats());
		dietEntity.setTotalQuantityGrams(nutrientPojo.getTotalGrams());
		dietEntity.setTotalFatMono(nutrientPojo.getTotalFatMonos());
		dietEntity.setTotalFatPoli(nutrientPojo.getTotalFatPolis());
		dietEntity.setTotalFatSat(nutrientPojo.getTotalFatSats());
		dietEntity.setTotalFatTrans(nutrientPojo.getTotalFatTrans());
		dietEntity.setTotalCarbSugar(nutrientPojo.getTotalCarbSugars());
		dietEntity.setTotalCarbSugarAdded(nutrientPojo.getTotalCarbSugarAddeds());
		dietEntity.setTotalCholesterol(nutrientPojo.getTotalCholesterols());
		dietEntity.setTotalFiber(nutrientPojo.getTotalFiber());
		dietEntity.setTotalSodium(nutrientPojo.getTotalSodium());
		
		return dietEntity;
	}
}
