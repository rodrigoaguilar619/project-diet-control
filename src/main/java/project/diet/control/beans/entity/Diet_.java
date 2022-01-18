package project.diet.control.beans.entity;

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

	public static final String TOTAL_CARBOHYDRATES = "totalCarbohydrates";
	public static final String TOTAL_FAT = "totalFat";
	public static final String RECIPE = "recipe";
	public static final String IS_BASE = "isBase";
	public static final String TOTAL_CALORIES = "totalCalories";
	public static final String ID_RECIPE = "idRecipe";
	public static final String TOTAL_PROTEINS = "totalProteins";
	public static final String DIET_FOODS = "dietFoods";
	public static final String TOTAL_QUANTITY_GRAMS = "totalQuantityGrams";

}

