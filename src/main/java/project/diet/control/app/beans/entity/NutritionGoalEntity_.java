package project.diet.control.app.beans.entity;

import java.math.BigDecimal;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NutritionGoalEntity.class)
public abstract class NutritionGoalEntity_ {

	public static SingularAttribute<NutritionGoalEntity, Double> carbohydrates;
	public static SingularAttribute<NutritionGoalEntity, Double> proteins;
	public static SingularAttribute<NutritionGoalEntity, Double> fat;
	public static SingularAttribute<NutritionGoalEntity, Integer> id;
	public static SingularAttribute<NutritionGoalEntity, Double> calories;
	public static SingularAttribute<NutritionGoalEntity, BigDecimal> fatMono;
	public static SingularAttribute<NutritionGoalEntity, BigDecimal> fatPoli;
	public static SingularAttribute<NutritionGoalEntity, BigDecimal> fatSat;
	public static SingularAttribute<NutritionGoalEntity, BigDecimal> fatTrans;
	public static SingularAttribute<NutritionGoalEntity, BigDecimal> carbSugar;
	public static SingularAttribute<NutritionGoalEntity, BigDecimal> carbSugarAdded;
	public static SingularAttribute<NutritionGoalEntity, BigDecimal> fiber;
	public static SingularAttribute<NutritionGoalEntity, BigDecimal> cholesterol;
	public static SingularAttribute<NutritionGoalEntity, BigDecimal> sodium;

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

