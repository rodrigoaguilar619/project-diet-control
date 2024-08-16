package project.diet.control.app.beans.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;

import project.diet.control.app.beans.entity.generic.GenericNutrientEntity;

import java.util.List;


/**
 * The persistent class for the food database table.
 * 
 */
@Entity
@Table(name = "food")
public class FoodEntity extends GenericNutrientEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private BigDecimal calories;

	private BigDecimal carbohydrates;

	@Column(name="cost_calorie")
	private BigDecimal costCalorie;

	@Column(name="cost_protein")
	private BigDecimal costProtein;

	private String description;

	private BigDecimal fat;

	private BigDecimal price;

	@Column(name="quantity_grams")
	private BigDecimal quantityGrams;
	
	@Column(name="unity_grams")
	private BigDecimal unityGrams;

	//bi-directional many-to-one association to DietFood
	@OneToMany(mappedBy="food")
	private List<DietFoodEntity> dietFoods;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getCalories() {
		return this.calories;
	}

	public void setCalories(BigDecimal calories) {
		this.calories = calories;
	}

	public BigDecimal getCarbohydrates() {
		return this.carbohydrates;
	}

	public void setCarbohydrates(BigDecimal carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public BigDecimal getCostCalorie() {
		return this.costCalorie;
	}

	public void setCostCalorie(BigDecimal costCalorie) {
		this.costCalorie = costCalorie;
	}

	public BigDecimal getCostProtein() {
		return this.costProtein;
	}

	public void setCostProtein(BigDecimal costProtein) {
		this.costProtein = costProtein;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getFat() {
		return this.fat;
	}

	public void setFat(BigDecimal fat) {
		this.fat = fat;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getQuantityGrams() {
		return this.quantityGrams;
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

	public List<DietFoodEntity> getDietFoods() {
		return this.dietFoods;
	}

	public void setDietFoods(List<DietFoodEntity> dietFoods) {
		this.dietFoods = dietFoods;
	}

	public DietFoodEntity addDietFood(DietFoodEntity dietFood) {
		getDietFoods().add(dietFood);
		dietFood.setFood(this);

		return dietFood;
	}

	public DietFoodEntity removeDietFood(DietFoodEntity dietFood) {
		getDietFoods().remove(dietFood);
		dietFood.setFood(null);

		return dietFood;
	}

}