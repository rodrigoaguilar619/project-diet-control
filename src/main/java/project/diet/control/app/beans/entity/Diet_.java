package project.diet.control.app.beans.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Diet.class)
public abstract class Diet_ {

	public static volatile SingularAttribute<Diet, BigDecimal> totalCarbohydrates;
	public static volatile SingularAttribute<Diet, BigDecimal> totalFat;
	public static volatile SingularAttribute<Diet, Recipe> recipe;
	public static volatile SingularAttribute<Diet, Byte> isBase;
	public static volatile SingularAttribute<Diet, BigDecimal> totalCalories;
	public static volatile SingularAttribute<Diet, Integer> idRecipe;
	public static volatile SingularAttribute<Diet, BigDecimal> totalProteins;
	public static volatile ListAttribute<Diet, DietFood> dietFoods;
	public static volatile SingularAttribute<Diet, BigDecimal> totalQuantityGrams;
	public static volatile SingularAttribute<Diet, BigDecimal> totalFatMono;
	public static volatile SingularAttribute<Diet, BigDecimal> totalFatPoli;
	public static volatile SingularAttribute<Diet, BigDecimal> totalFatSat;
	public static volatile SingularAttribute<Diet, BigDecimal> totalFatTrans;
	public static volatile SingularAttribute<Diet, BigDecimal> totalCarbSugar;
	public static volatile SingularAttribute<Diet, BigDecimal> totalCarbSugarAdded;
	public static volatile SingularAttribute<Diet, BigDecimal> totalFiber;
	public static volatile SingularAttribute<Diet, BigDecimal> totalCholesterol;
	public static volatile SingularAttribute<Diet, BigDecimal> totalSodium;

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

