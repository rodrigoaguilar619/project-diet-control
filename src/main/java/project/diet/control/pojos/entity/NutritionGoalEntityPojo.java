package project.diet.control.pojos.entity;

import java.math.BigDecimal;

public class NutritionGoalEntityPojo {
	
	private BigDecimal calories;
	
	private BigDecimal proteins;
	
	private BigDecimal carbohydrates;
	
	private BigDecimal fat;

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

	public BigDecimal getFat() {
		return fat;
	}

	public void setFat(BigDecimal fat) {
		this.fat = fat;
	}
	
}
