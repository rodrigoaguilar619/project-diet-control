package project.diet.control.app.beans.entity;

import java.math.BigDecimal;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DietFood.class)
public abstract class DietFood_ {

	public static SingularAttribute<DietFood, BigDecimal> totalCarbohydrates;
	public static SingularAttribute<DietFood, BigDecimal> totalFat;
	public static SingularAttribute<DietFood, Integer> id;
	public static SingularAttribute<DietFood, BigDecimal> totalCalories;
	public static SingularAttribute<DietFood, Diet> diet;
	public static SingularAttribute<DietFood, BigDecimal> totalProteins;
	public static SingularAttribute<DietFood, BigDecimal> totalQuantityGrams;
	public static SingularAttribute<DietFood, Food> food;
	public static SingularAttribute<DietFood, BigDecimal> portions;
	public static SingularAttribute<DietFood, BigDecimal> unities;
	public static SingularAttribute<DietFood, BigDecimal> totalFatMono;
	public static SingularAttribute<DietFood, BigDecimal> totalFatPoli;
	public static SingularAttribute<DietFood, BigDecimal> totalFatSat;
	public static SingularAttribute<DietFood, BigDecimal> totalFatTrans;
	public static SingularAttribute<DietFood, BigDecimal> totalCarbSugar;
	public static SingularAttribute<DietFood, BigDecimal> totalCarbSugarAdded;
	public static SingularAttribute<DietFood, BigDecimal> totalFiber;
	public static SingularAttribute<DietFood, BigDecimal> totalCholesterol;
	public static SingularAttribute<DietFood, BigDecimal> totalSodium;

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

