package project.diet.control.beans.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Recipe.class)
public abstract class Recipe_ {

	public static volatile SingularAttribute<Recipe, String> instructions;
	public static volatile SingularAttribute<Recipe, Integer> id;
	public static volatile SingularAttribute<Recipe, Diet> diet;
	public static volatile SingularAttribute<Recipe, String> title;

	public static final String INSTRUCTIONS = "instructions";
	public static final String ID = "id";
	public static final String DIET = "diet";
	public static final String TITLE = "title";

}

