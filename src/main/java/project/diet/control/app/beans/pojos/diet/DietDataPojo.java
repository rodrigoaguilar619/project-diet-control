package project.diet.control.app.beans.pojos.diet;

import java.util.List;

import project.diet.control.app.beans.pojos.entity.DietEntityPojo;
import project.diet.control.app.beans.pojos.entity.RecipeEntityPojo;

public class DietDataPojo {

	RecipeEntityPojo recipe;
	
	DietEntityPojo diet;
	
	List<DietFoodResumePojo> foods;

	public RecipeEntityPojo getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeEntityPojo recipe) {
		this.recipe = recipe;
	}

	public List<DietFoodResumePojo> getFoods() {
		return foods;
	}

	public void setFoods(List<DietFoodResumePojo> foods) {
		this.foods = foods;
	}

	public DietEntityPojo getDiet() {
		return diet;
	}

	public void setDiet(DietEntityPojo diet) {
		this.diet = diet;
	}
}
