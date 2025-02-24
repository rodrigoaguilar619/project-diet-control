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
	public static SingularAttribute<FoodEntity, BigDecimal> costKilo;
	public static SingularAttribute<FoodEntity, BigDecimal> costGram;

}

