package project.diet.control.beans.entity;

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

	public static final String CARBOHYDRATES = "carbohydrates";
	public static final String PROTEINS = "proteins";
	public static final String FAT = "fat";
	public static final String ID = "id";
	public static final String CALORIES = "calories";

}

