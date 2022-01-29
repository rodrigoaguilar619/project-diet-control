package project.diet.control.pojos.request.recipe;

import project.diet.control.pojos.entity.RecipeEntityPojo;

public class AddEditRecipeRequestPojo {

	RecipeEntityPojo recipe;

	public RecipeEntityPojo getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeEntityPojo recipe) {
		this.recipe = recipe;
	}
	
}
