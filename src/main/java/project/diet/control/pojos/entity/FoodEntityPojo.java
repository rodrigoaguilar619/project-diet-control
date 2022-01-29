package project.diet.control.pojos.entity;

import java.math.BigDecimal;

public class FoodEntityPojo {

	private Integer id;
	
	private String description;
	
	private BigDecimal quantityGrams;
	
	private BigDecimal unityGrams;
	
	private BigDecimal calories;
	
	private BigDecimal carbohydrates;
	
	private BigDecimal proteins;
	
	private BigDecimal fat;
	
	private BigDecimal price;
	
	private BigDecimal costCalorie;
	
	private BigDecimal costProtein;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getQuantityGrams() {
		return quantityGrams;
	}

	public void setQuantityGrams(BigDecimal quantityGrams) {
		this.quantityGrams = quantityGrams;
	}

	public BigDecimal getUnityGrams() {
		return unityGrams;
	}

	public void setUnityGrams(BigDecimal unityGrams) {
		this.unityGrams = unityGrams;
	}

	public BigDecimal getCalories() {
		return calories;
	}

	public void setCalories(BigDecimal calories) {
		this.calories = calories;
	}

	public BigDecimal getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(BigDecimal carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public BigDecimal getProteins() {
		return proteins;
	}

	public void setProteins(BigDecimal proteins) {
		this.proteins = proteins;
	}

	public BigDecimal getFat() {
		return fat;
	}

	public void setFat(BigDecimal fat) {
		this.fat = fat;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getCostCalorie() {
		return costCalorie;
	}

	public void setCostCalorie(BigDecimal costCalorie) {
		this.costCalorie = costCalorie;
	}

	public BigDecimal getCostProtein() {
		return costProtein;
	}

	public void setCostProtein(BigDecimal costProtein) {
		this.costProtein = costProtein;
	}
}
