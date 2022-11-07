package project.diet.control.app.beans.entity;

import java.math.BigDecimal;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NutritionGoal.class)
public abstract class NutritionGoal_ {

	public static volatile SingularAttribute<NutritionGoal, Double> carbohydrates;
	public static volatile SingularAttribute<NutritionGoal, Double> proteins;
	public static volatile SingularAttribute<NutritionGoal, Double> fat;
	public static volatile SingularAttribute<NutritionGoal, Integer> id;
	public static volatile SingularAttribute<NutritionGoal, Double> calories;
	public static volatile SingularAttribute<NutritionGoal, BigDecimal> fatMono;
	public static volatile SingularAttribute<NutritionGoal, BigDecimal> fatPoli;
	public static volatile SingularAttribute<NutritionGoal, BigDecimal> fatSat;
	public static volatile SingularAttribute<NutritionGoal, BigDecimal> fatTrans;
	public static volatile SingularAttribute<NutritionGoal, BigDecimal> carbSugar;
	public static volatile SingularAttribute<NutritionGoal, BigDecimal> carbSugarAdded;
	public static volatile SingularAttribute<NutritionGoal, BigDecimal> fiber;
	public static volatile SingularAttribute<NutritionGoal, BigDecimal> cholesterol;
	public static volatile SingularAttribute<NutritionGoal, BigDecimal> sodium;

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

