package project.diet.control.beans.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Food.class)
public abstract class Food_ {

	public static volatile SingularAttribute<Food, BigDecimal> carbohydrates;
	public static volatile SingularAttribute<Food, BigDecimal> quantityGrams;
	public static volatile SingularAttribute<Food, BigDecimal> unityGrams;
	public static volatile SingularAttribute<Food, BigDecimal> price;
	public static volatile SingularAttribute<Food, BigDecimal> proteins;
	public static volatile SingularAttribute<Food, BigDecimal> fat;
	public static volatile SingularAttribute<Food, String> description;
	public static volatile SingularAttribute<Food, BigDecimal> costProtein;
	public static volatile SingularAttribute<Food, Integer> id;
	public static volatile SingularAttribute<Food, BigDecimal> calories;
	public static volatile SingularAttribute<Food, BigDecimal> costCalorie;
	public static volatile SingularAttribute<Food, BigDecimal> fatMono;
	public static volatile SingularAttribute<Food, BigDecimal> fatPoli;
	public static volatile SingularAttribute<Food, BigDecimal> fatSat;
	public static volatile SingularAttribute<Food, BigDecimal> fatTrans;
	public static volatile SingularAttribute<Food, BigDecimal> carbSugar;
	public static volatile SingularAttribute<Food, BigDecimal> carbSugarAdded;
	public static volatile SingularAttribute<Food, BigDecimal> fiber;
	public static volatile SingularAttribute<Food, BigDecimal> cholesterol;
	public static volatile SingularAttribute<Food, BigDecimal> sodium;
	public static volatile ListAttribute<Food, DietFood> dietFoods;
	

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

