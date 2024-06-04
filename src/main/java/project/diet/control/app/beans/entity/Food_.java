package project.diet.control.app.beans.entity;

import java.math.BigDecimal;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Food.class)
public abstract class Food_ {

	public static SingularAttribute<Food, BigDecimal> carbohydrates;
	public static SingularAttribute<Food, BigDecimal> quantityGrams;
	public static SingularAttribute<Food, BigDecimal> unityGrams;
	public static SingularAttribute<Food, BigDecimal> price;
	public static SingularAttribute<Food, BigDecimal> proteins;
	public static SingularAttribute<Food, BigDecimal> fat;
	public static SingularAttribute<Food, String> description;
	public static SingularAttribute<Food, BigDecimal> costProtein;
	public static SingularAttribute<Food, Integer> id;
	public static SingularAttribute<Food, BigDecimal> calories;
	public static SingularAttribute<Food, BigDecimal> costCalorie;
	public static SingularAttribute<Food, BigDecimal> fatMono;
	public static SingularAttribute<Food, BigDecimal> fatPoli;
	public static SingularAttribute<Food, BigDecimal> fatSat;
	public static SingularAttribute<Food, BigDecimal> fatTrans;
	public static SingularAttribute<Food, BigDecimal> carbSugar;
	public static SingularAttribute<Food, BigDecimal> carbSugarAdded;
	public static SingularAttribute<Food, BigDecimal> fiber;
	public static SingularAttribute<Food, BigDecimal> cholesterol;
	public static SingularAttribute<Food, BigDecimal> sodium;
	public static ListAttribute<Food, DietFood> dietFoods;
	

	public static final String CARBOHYDRATES = "carbohydrates";
	public static final String QUANTITY_GRAMS = "quantityGrams";
	public static final String UNITY_GRAMS = "unityGrams";
	public static final String PRICE = "price";
	public static final String PROTEINS = "proteins";
	public static final String FAT = "fat";
	public static final String DESCRIPTION = "description";
	public static final String COST_PROTEIN = "costProtein";
	public static final String ID = "id";
	public static final String CALORIES = "calories";
	public static final String COST_CALORIE = "costCalorie";
	public static final String DIET_FOODS = "dietFoods";
	public static final String FAT_MONO = "fatMono";
	public static final String FAT_POLI = "fatPoli";
	public static final String FAT_SAT = "fatSat";
	public static final String FAT_TRANS = "fatTrans";
	public static final String CARB_SUGAR = "carbSugar";
	public static final String CARB_SUGAR_ADDED = "carbSugarAdded";
	public static final String FIBER = "fiber";
	public static final String CHOLESTEROL = "cholesterol";
	public static final String SODIUM = "sodium";

}

