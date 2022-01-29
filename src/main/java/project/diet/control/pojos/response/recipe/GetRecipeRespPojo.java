package project.diet.control.pojos.response.recipe;

import project.diet.control.pojos.entity.RecipeEntityPojo;

public class GetRecipeRespPojo {

	RecipeEntityPojo recipe;

	public RecipeEntityPojo getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeEntityPojo recipe) {
		this.recipe = recipe;
	}
}
