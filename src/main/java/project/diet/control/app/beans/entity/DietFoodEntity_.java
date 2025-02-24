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
	public static SingularAttribute<DietFoodEntity, BigDecimal> totalCostProtein;
	public static SingularAttribute<DietFoodEntity, BigDecimal> totalCostCalorie;
	public static SingularAttribute<DietFoodEntity, BigDecimal> totalCostGram;

}

