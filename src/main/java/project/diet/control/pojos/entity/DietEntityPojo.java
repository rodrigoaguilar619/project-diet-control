package project.diet.control.pojos.entity;

import java.math.BigDecimal;

public class DietEntityPojo {

	private Boolean isBase;

	private BigDecimal totalCalories;

	private BigDecimal totalCarbohydrates;

	private BigDecimal totalFat;

	private BigDecimal totalProteins;

	private BigDecimal totalQuantityGrams;

	public Boolean getIsBase() {
		return isBase;
	}

	public void setIsBase(Boolean isBase) {
		this.isBase = isBase;
	}

	public BigDecimal getTotalCalories() {
		return totalCalories;
	}

	public void setTotalCalories(BigDecimal totalCalories) {
		this.totalCalories = totalCalories;
	}

	public BigDecimal getTotalCarbohydrates() {
		return totalCarbohydrates;
	}

	public void setTotalCarbohydrates(BigDecimal totalCarbohydrates) {
		this.totalCarbohydrates = totalCarbohydrates;
	}

	public BigDecimal getTotalFat() {
		return totalFat;
	}

	public void setTotalFat(BigDecimal totalFat) {
		this.totalFat = totalFat;
	}

	public BigDecimal getTotalProteins() {
		return totalProteins;
	}

	public void setTotalProteins(BigDecimal totalProteins) {
		this.totalProteins = totalProteins;
	}

	public BigDecimal getTotalQuantityGrams() {
		return totalQuantityGrams;
	}

	public void setTotalQuantityGrams(BigDecimal totalQuantityGrams) {
		this.totalQuantityGrams = totalQuantityGrams;
	}
}
