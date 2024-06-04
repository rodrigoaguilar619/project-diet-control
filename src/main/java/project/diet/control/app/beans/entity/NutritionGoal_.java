package project.diet.control.app.beans.entity;

import java.math.BigDecimal;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NutritionGoal.class)
public abstract class NutritionGoal_ {

	public static SingularAttribute<NutritionGoal, Double> carbohydrates;
	public static SingularAttribute<NutritionGoal, Double> proteins;
	public static SingularAttribute<NutritionGoal, Double> fat;
	public static SingularAttribute<NutritionGoal, Integer> id;
	public static SingularAttribute<NutritionGoal, Double> calories;
	public static SingularAttribute<NutritionGoal, BigDecimal> fatMono;
	public static SingularAttribute<NutritionGoal, BigDecimal> fatPoli;
	public static SingularAttribute<NutritionGoal, BigDecimal> fatSat;
	public static SingularAttribute<NutritionGoal, BigDecimal> fatTrans;
	public static SingularAttribute<NutritionGoal, BigDecimal> carbSugar;
	public static SingularAttribute<NutritionGoal, BigDecimal> carbSugarAdded;
	public static SingularAttribute<NutritionGoal, BigDecimal> fiber;
	public static SingularAttribute<NutritionGoal, BigDecimal> cholesterol;
	public static SingularAttribute<NutritionGoal, BigDecimal> sodium;

	public static final String CARBOHYDRATES = "carbohydrates";
	public static final String PROTEINS = "proteins";
	public static final String FAT = "fat";
	public static final String ID = "id";
	public static final String CALORIES = "calories";
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

