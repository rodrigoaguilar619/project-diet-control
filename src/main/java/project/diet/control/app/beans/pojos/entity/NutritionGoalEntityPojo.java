package project.diet.control.app.beans.pojos.entity;

import java.math.BigDecimal;

import project.diet.control.app.beans.pojos.entity.generic.GenericNutrientEntityPojo;

public class NutritionGoalEntityPojo extends GenericNutrientEntityPojo {
	
	private BigDecimal calories;
	
	private BigDecimal proteins;
	
	private BigDecimal carbohydrates;

	public BigDecimal getCalories() {
		return calories;
	}

	public void setCalories(BigDecimal calories) {
		this.calories = calories;
	}

	public BigDecimal getProteins() {
		return proteins;
	}

	public void setProteins(BigDecimal proteins) {
		this.proteins = proteins;
	}

	public BigDecimal getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(BigDecimal carbohydrates) {
		this.carbohydrates = carbohydrates;
	}
	
}
