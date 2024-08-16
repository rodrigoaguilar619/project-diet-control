package project.diet.control.app.beans.entity;

import jakarta.persistence.*;

import project.diet.control.app.beans.entity.generic.GenericDietEntity;

import java.util.List;


/**
 * The persistent class for the diet database table.
 * 
 */
@Entity
@Table(name = "diet")
public class DietEntity extends GenericDietEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_recipe")
	private Integer idRecipe;

	@Column(name="is_base")
	private Boolean isBase;

	//bi-directional one-to-one association to Recipe
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_recipe")
	private RecipeEntity recipe;

	//bi-directional many-to-one association to DietFood
	@OneToMany(mappedBy="diet")
	private List<DietFoodEntity> dietFoods;

	public DietEntity() {
	}

	public DietEntity(int idRecipe) {
		super();
		this.idRecipe = idRecipe;
	}

	public int getIdRecipe() {
		return this.idRecipe;
	}

	public void setIdRecipe(int idRecipe) {
		this.idRecipe = idRecipe;
	}

	public Boolean getIsBase() {
		return this.isBase;
	}

	public void setIsBase(Boolean isBase) {
		this.isBase = isBase;
	}

	public RecipeEntity getRecipe() {
		return this.recipe;
	}

	public void setRecipe(RecipeEntity recipe) {
		this.recipe = recipe;
	}

	public List<DietFoodEntity> getDietFoods() {
		return this.dietFoods;
	}

	public void setDietFoods(List<DietFoodEntity> dietFoods) {
		this.dietFoods = dietFoods;
	}

	public DietFoodEntity addDietFood(DietFoodEntity dietFood) {
		getDietFoods().add(dietFood);
		dietFood.setDiet(this);

		return dietFood;
	}

	public DietFoodEntity removeDietFood(DietFoodEntity dietFood) {
		getDietFoods().remove(dietFood);
		dietFood.setDiet(null);

		return dietFood;
	}

}