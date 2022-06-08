package project.diet.control.pojos.response.recipe;

import java.util.ArrayList;
import java.util.List;

import project.diet.control.pojos.entity.RecipeEntityPojo;

public class GetRecipeListRespPojo {

	List<RecipeEntityPojo> recipes = new ArrayList<>();

	public List<RecipeEntityPojo> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<RecipeEntityPojo> recipes) {
		this.recipes = recipes;
	}
}
