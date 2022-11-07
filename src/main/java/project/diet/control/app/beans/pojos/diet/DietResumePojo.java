package project.diet.control.app.beans.pojos.diet;

import project.diet.control.app.beans.pojos.entity.DietEntityPojo;

public class DietResumePojo extends DietEntityPojo {

	private Integer id;
	
	private String recipeTitle;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
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
