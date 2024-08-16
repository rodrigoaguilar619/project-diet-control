package project.diet.control.app.beans.entity;

import java.math.BigDecimal;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FoodEntity.class)
public abstract class FoodEntity_ {

	public static SingularAttribute<FoodEntity, BigDecimal> carbohydrates;
	public static SingularAttribute<FoodEntity, BigDecimal> quantityGrams;
	public static SingularAttribute<FoodEntity, BigDecimal> unityGrams;
	public static SingularAttribute<FoodEntity, BigDecimal> price;
	public static SingularAttribute<FoodEntity, BigDecimal> proteins;
	public static SingularAttribute<FoodEntity, BigDecimal> fat;
	public static SingularAttribute<FoodEntity, String> description;
	public static SingularAttribute<FoodEntity, BigDecimal> costProtein;
	public static SingularAttribute<FoodEntity, Integer> id;
	public static SingularAttribute<FoodEntity, BigDecimal> calories;
	public static SingularAttribute<FoodEntity, BigDecimal> costCalorie;
	public static SingularAttribute<FoodEntity, BigDecimal> fatMono;
	public static SingularAttribute<FoodEntity, BigDecimal> fatPoli;
	public static SingularAttribute<FoodEntity, BigDecimal> fatSat;
	public static SingularAttribute<FoodEntity, BigDecimal> fatTrans;
	public static SingularAttribute<FoodEntity, BigDecimal> carbSugar;
	public static SingularAttribute<FoodEntity, BigDecimal> carbSugarAdded;
	public static SingularAttribute<FoodEntity, BigDecimal> fiber;
	public static SingularAttribute<FoodEntity, BigDecimal> cholesterol;
	public static SingularAttribute<FoodEntity, BigDecimal> sodium;
	public static ListAttribute<FoodEntity, DietFoodEntity> dietFoods;
	

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

