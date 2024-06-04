package project.diet.control.app.beans.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Recipe.class)
public abstract class Recipe_ {

	public static SingularAttribute<Recipe, String> instructions;
	public static SingularAttribute<Recipe, Integer> id;
	public static SingularAttribute<Recipe, Diet> diet;
	public static SingularAttribute<Recipe, String> title;

	public static final String INSTRUCTIONS = "instructions";
	public static final String ID = "id";
	public static final String DIET = "diet";
	public static final String TITLE = "title";

}

