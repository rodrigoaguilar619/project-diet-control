package project.diet.control.app.beans.entity;

import java.math.BigDecimal;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DietEntity.class)
public abstract class DietEntity_ {

	public static SingularAttribute<DietEntity, BigDecimal> totalCarbohydrates;
	public static SingularAttribute<DietEntity, BigDecimal> totalFat;
	public static SingularAttribute<DietEntity, RecipeEntity> recipe;
	public static SingularAttribute<DietEntity, Byte> isBase;
	public static SingularAttribute<DietEntity, BigDecimal> totalCalories;
	public static SingularAttribute<DietEntity, Integer> idRecipe;
	public static SingularAttribute<DietEntity, BigDecimal> totalProteins;
	public static ListAttribute<DietEntity, DietFoodEntity> dietFoods;
	public static SingularAttribute<DietEntity, BigDecimal> totalQuantityGrams;
	public static SingularAttribute<DietEntity, BigDecimal> totalFatMono;
	public static SingularAttribute<DietEntity, BigDecimal> totalFatPoli;
	public static SingularAttribute<DietEntity, BigDecimal> totalFatSat;
	public static SingularAttribute<DietEntity, BigDecimal> totalFatTrans;
	public static SingularAttribute<DietEntity, BigDecimal> totalCarbSugar;
	public static SingularAttribute<DietEntity, BigDecimal> totalCarbSugarAdded;
	public static SingularAttribute<DietEntity, BigDecimal> totalFiber;
	public static SingularAttribute<DietEntity, BigDecimal> totalCholesterol;
	public static SingularAttribute<DietEntity, BigDecimal> totalSodium;

	public static final String TOTAL_CARBOHYDRATES = "totalCarbohydrates";
	public static final String TOTAL_FAT = "totalFat";
	public static final String RECIPE = "recipe";
	public static final String IS_BASE = "isBase";
	public static final String TOTAL_CALORIES = "totalCalories";
	public static final String ID_RECIPE = "idRecipe";
	public static final String TOTAL_PROTEINS = "totalProteins";
	public static final String DIET_FOODS = "dietFoods";
	public static final String TOTAL_QUANTITY_GRAMS = "totalQuantityGrams";
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

