package project.diet.control.app.beans.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RecipeEntity.class)
public abstract class RecipeEntity_ {

	public static SingularAttribute<RecipeEntity, String> instructions;
	public static SingularAttribute<RecipeEntity, Integer> id;
	public static SingularAttribute<RecipeEntity, DietEntity> diet;
	public static SingularAttribute<RecipeEntity, String> title;

	public static final String INSTRUCTIONS = "instructions";
	public static final String ID = "id";
	public static final String DIET = "diet";
	public static final String TITLE = "title";

}

