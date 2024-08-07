package project.diet.control.app.beans.pojos.diet;

import java.util.ArrayList;
import java.util.List;

import project.diet.control.app.beans.pojos.entity.DietFoodEntityPojo;

public class DietPojo {

	private Integer idRecipe;
	
	private Boolean isBase;
	
	private List<DietFoodEntityPojo> foods = new ArrayList<>();

	public Integer getIdRecipe() {
		return idRecipe;
	}

	public void setIdRecipe(Integer idRecipe) {
		this.idRecipe = idRecipe;
	}

	public List<DietFoodEntityPojo> getFoods() {
		return foods;
	}

	public void setFoods(List<DietFoodEntityPojo> foods) {
		this.foods = foods;
	}

	public Boolean getIsBase() {
		return isBase;
	}

	public void setIsBase(Boolean isBase) {
		this.isBase = isBase;
	}
}
