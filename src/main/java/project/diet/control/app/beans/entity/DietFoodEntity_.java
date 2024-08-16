package project.diet.control.app.beans.entity;

import java.math.BigDecimal;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DietFoodEntity.class)
public abstract class DietFoodEntity_ {

	public static SingularAttribute<DietFoodEntity, BigDecimal> totalCarbohydrates;
	public static SingularAttribute<DietFoodEntity, BigDecimal> totalFat;
	public static SingularAttribute<DietFoodEntity, Integer> id;
	public static SingularAttribute<DietFoodEntity, BigDecimal> totalCalories;
	public static SingularAttribute<DietFoodEntity, DietEntity> diet;
	public static SingularAttribute<DietFoodEntity, BigDecimal> totalProteins;
	public static SingularAttribute<DietFoodEntity, BigDecimal> totalQuantityGrams;
	public static SingularAttribute<DietFoodEntity, FoodEntity> food;
	public static SingularAttribute<DietFoodEntity, BigDecimal> portions;
	public static SingularAttribute<DietFoodEntity, BigDecimal> unities;
	public static SingularAttribute<DietFoodEntity, BigDecimal> totalFatMono;
	public static SingularAttribute<DietFoodEntity, BigDecimal> totalFatPoli;
	public static SingularAttribute<DietFoodEntity, BigDecimal> totalFatSat;
	public static SingularAttribute<DietFoodEntity, BigDecimal> totalFatTrans;
	public static SingularAttribute<DietFoodEntity, BigDecimal> totalCarbSugar;
	public static SingularAttribute<DietFoodEntity, BigDecimal> totalCarbSugarAdded;
	public static SingularAttribute<DietFoodEntity, BigDecimal> totalFiber;
	public static SingularAttribute<DietFoodEntity, BigDecimal> totalCholesterol;
	public static SingularAttribute<DietFoodEntity, BigDecimal> totalSodium;

	public static final String TOTAL_CARBOHYDRATES = "totalCarbohydrates";
	public static final String TOTAL_FAT = "totalFat";
	public static final String ID = "id";
	public static final String TOTAL_CALORIES = "totalCalories";
	public static final String DIET = "diet";
	public static final String TOTAL_PROTEINS = "totalProteins";
	public static final String TOTAL_QUANTITY_GRAMS = "totalQuantityGrams";
	public static final String FOOD = "food";
	public static final String UNITIES = "unitites";
	public static final String TOTAL_FAT_MONO = "totalFatMono";
	public static final String TOTAL_FAT_POLI = "totalFatPoli";
	public static final String TOTAL_FAT_SAT = "totalFatSat";
	public static final String TOTAL_FAT_TRANS = "totalFatTrans";
	public static final String TOTAL_CARB_SUGAR = "totalCarbSugar";
	public static final String TOTAL_CARB_SUGAR_ADDED = "totalCarbSugarAdded";
	public static final String TOTAL_FIBER = "totalFiber";
	public static final String TOTAL_CHOLESTEROL = "totalCholesterol";
	public static final String TOTAL_SODIUM = "totalSodium";

}

