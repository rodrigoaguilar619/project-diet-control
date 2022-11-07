package project.diet.control.app.beans.pojos.petition.data.recipe;

import java.util.ArrayList;
import java.util.List;

import project.diet.control.app.beans.pojos.entity.RecipeEntityPojo;

public class GetRecipeListDataPojo {

	List<RecipeEntityPojo> recipes = new ArrayList<>();

	public List<RecipeEntityPojo> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<RecipeEntityPojo> recipes) {
		this.recipes = recipes;
	}
}
