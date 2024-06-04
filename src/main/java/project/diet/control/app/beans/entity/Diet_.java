package project.diet.control.app.beans.entity;

import java.math.BigDecimal;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Diet.class)
public abstract class Diet_ {

	public static SingularAttribute<Diet, BigDecimal> totalCarbohydrates;
	public static SingularAttribute<Diet, BigDecimal> totalFat;
	public static SingularAttribute<Diet, Recipe> recipe;
	public static SingularAttribute<Diet, Byte> isBase;
	public static SingularAttribute<Diet, BigDecimal> totalCalories;
	public static SingularAttribute<Diet, Integer> idRecipe;
	public static SingularAttribute<Diet, BigDecimal> totalProteins;
	public static ListAttribute<Diet, DietFood> dietFoods;
	public static SingularAttribute<Diet, BigDecimal> totalQuantityGrams;
	public static SingularAttribute<Diet, BigDecimal> totalFatMono;
	public static SingularAttribute<Diet, BigDecimal> totalFatPoli;
	public static SingularAttribute<Diet, BigDecimal> totalFatSat;
	public static SingularAttribute<Diet, BigDecimal> totalFatTrans;
	public static SingularAttribute<Diet, BigDecimal> totalCarbSugar;
	public static SingularAttribute<Diet, BigDecimal> totalCarbSugarAdded;
	public static SingularAttribute<Diet, BigDecimal> totalFiber;
	public static SingularAttribute<Diet, BigDecimal> totalCholesterol;
	public static SingularAttribute<Diet, BigDecimal> totalSodium;

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

