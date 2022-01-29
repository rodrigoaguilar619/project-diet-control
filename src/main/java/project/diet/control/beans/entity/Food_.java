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

}

