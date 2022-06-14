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
	
	private BigDecimal fatMono;

	private BigDecimal fatPoli;

	private BigDecimal fatSat;

	private BigDecimal fatTrans;

	private BigDecimal carbSugar;

	private BigDecimal carbSugarAdded;

	private BigDecimal fiber;

	private BigDecimal cholesterol;

	private BigDecimal sodium;
	
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

	public BigDecimal getFatMono() {
		return fatMono;
	}

	public void setFatMono(BigDecimal fatMono) {
		this.fatMono = fatMono;
	}

	public BigDecimal getFatPoli() {
		return fatPoli;
	}

	public void setFatPoli(BigDecimal fatPoli) {
		this.fatPoli = fatPoli;
	}

	public BigDecimal getFatSat() {
		return fatSat;
	}

	public void setFatSat(BigDecimal fatSat) {
		this.fatSat = fatSat;
	}

	public BigDecimal getFatTrans() {
		return fatTrans;
	}

	public void setFatTrans(BigDecimal fatTrans) {
		this.fatTrans = fatTrans;
	}

	public BigDecimal getCarbSugar() {
		return carbSugar;
	}

	public void setCarbSugar(BigDecimal carbSugar) {
		this.carbSugar = carbSugar;
	}

	public BigDecimal getCarbSugarAdded() {
		return carbSugarAdded;
	}

	public void setCarbSugarAdded(BigDecimal carbSugarAdded) {
		this.carbSugarAdded = carbSugarAdded;
	}

	public BigDecimal getFiber() {
		return fiber;
	}

	public void setFiber(BigDecimal fiber) {
		this.fiber = fiber;
	}

	public BigDecimal getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(BigDecimal cholesterol) {
		this.cholesterol = cholesterol;
	}

	public BigDecimal getSodium() {
		return sodium;
	}

	public void setSodium(BigDecimal sodium) {
		this.sodium = sodium;
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
