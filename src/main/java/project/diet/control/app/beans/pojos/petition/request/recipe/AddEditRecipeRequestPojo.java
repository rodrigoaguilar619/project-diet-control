package project.diet.control.app.beans.pojos.petition.request.recipe;

import project.diet.control.app.beans.pojos.entity.RecipeEntityPojo;

public class AddEditRecipeRequestPojo {

	RecipeEntityPojo recipe;

	public RecipeEntityPojo getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeEntityPojo recipe) {
		this.recipe = recipe;
	}
	
}