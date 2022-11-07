package project.diet.control.app.beans.pojos.diet;

import java.util.List;

import project.diet.control.app.beans.pojos.entity.DietEntityPojo;
import project.diet.control.app.beans.pojos.entity.RecipeEntityPojo;

public class DietCustomDetailResumePojo {
	
	private Integer idDietCustom;

	private DietEntityPojo subTotalDietBase;
	
	private DietEntityPojo subTotalDietCustom;
	
	private DietEntityPojo totalDiet;

	private RecipeEntityPojo recipe;
	
	private List<DietFoodResumePojo> foods;
	
	public Integer getIdDietCustom() {
		return idDietCustom;
	}

	public void setIdDietCustom(Integer idDietCustom) {
		this.idDietCustom = idDietCustom;
	}

	public DietEntityPojo getSubTotalDietBase() {
		return subTotalDietBase;
	}

	public void setSubTotalDietBase(DietEntityPojo subTotalDietBase) {
		this.subTotalDietBase = subTotalDietBase;
	}

	public DietEntityPojo getSubTotalDietCustom() {
		return subTotalDietCustom;
	}

	public void setSubTotalDietCustom(DietEntityPojo subTotalDietCustom) {
		this.subTotalDietCustom = subTotalDietCustom;
	}

	public DietEntityPojo getTotalDiet() {
		return totalDiet;
	}

	public void setTotalDiet(DietEntityPojo totalDiet) {
		this.totalDiet = totalDiet;
	}

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
	
}
