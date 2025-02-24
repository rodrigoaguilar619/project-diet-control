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
	public static SingularAttribute<DietEntity, BigDecimal> totalCostProtein;
	public static SingularAttribute<DietEntity, BigDecimal> totalCostCalorie;
	public static SingularAttribute<DietEntity, BigDecimal> totalCostGram;
}

