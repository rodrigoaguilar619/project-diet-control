package project.diet.control.app.beans.entity;

import javax.persistence.*;

import project.diet.control.app.beans.entity.generic.GenericDietEntity;

import java.util.List;


/**
 * The persistent class for the diet database table.
 * 
 */
@Entity
@NamedQuery(name="Diet.findAll", query="SELECT d FROM Diet d")
public class Diet extends GenericDietEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_recipe")
	private Integer idRecipe;

	@Column(name="is_base")
	private Boolean isBase;

	//bi-directional one-to-one association to Recipe
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_recipe")
	private Recipe recipe;

	//bi-directional many-to-one association to DietFood
	@OneToMany(mappedBy="diet")
	private List<DietFood> dietFoods;

	public Diet() {
	}

	public Diet(int idRecipe) {
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

	public Recipe getRecipe() {
		return this.recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public List<DietFood> getDietFoods() {
		return this.dietFoods;
	}

	public void setDietFoods(List<DietFood> dietFoods) {
		this.dietFoods = dietFoods;
	}

	public DietFood addDietFood(DietFood dietFood) {
		getDietFoods().add(dietFood);
		dietFood.setDiet(this);

		return dietFood;
	}

	public DietFood removeDietFood(DietFood dietFood) {
		getDietFoods().remove(dietFood);
		dietFood.setDiet(null);

		return dietFood;
	}

}