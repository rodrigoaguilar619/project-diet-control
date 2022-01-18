package project.diet.control.pojos.diet;

import project.diet.control.pojos.entity.DietEntityPojo;

public class DietResumePojo extends DietEntityPojo {

	private Integer id;
	
	private String recipeTitle;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRecipeTitle() {
		return recipeTitle;
	}

	public void setRecipeTitle(String recipeTitle) {
		this.recipeTitle = recipeTitle;
	}
	
}
