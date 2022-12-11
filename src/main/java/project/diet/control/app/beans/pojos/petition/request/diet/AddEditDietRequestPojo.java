package project.diet.control.app.beans.pojos.petition.request.diet;

import project.diet.control.app.beans.pojos.diet.DietPojo;

public class AddEditDietRequestPojo {

	private DietPojo diet;
	
	private String recipeInstructions;

	public String getRecipeInstructions() {
		return recipeInstructions;
	}

	public void setRecipeInstructions(String recipeInstructions) {
		this.recipeInstructions = recipeInstructions;
	}

	public DietPojo getDiet() {
		return diet;
	}

	public void setDiet(DietPojo diet) {
		this.diet = diet;
	}
}
