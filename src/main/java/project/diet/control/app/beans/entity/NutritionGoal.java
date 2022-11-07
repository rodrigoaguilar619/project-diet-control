package project.diet.control.app.beans.entity;

import java.math.BigDecimal;

import javax.persistence.*;

import project.diet.control.app.beans.entity.generic.GenericNutrientEntity;


/**
 * The persistent class for the nutrition_goals database table.
 * 
 */
@Entity
@Table(name="nutrition_goals")
@NamedQuery(name="NutritionGoal.findAll", query="SELECT n FROM NutritionGoal n")
public class NutritionGoal extends GenericNutrientEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private BigDecimal calories;

	private BigDecimal carbohydrates;

	private BigDecimal fat;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public BigDecimal getCarbohydrates() {
		return this.carbohydrates;
	}

	public void setCarbohydrates(BigDecimal carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public BigDecimal getCalories() {
		return this.calories;
	}

	public void setCalories(BigDecimal calories) {
		this.calories = calories;
	}

	public BigDecimal getFat() {
		return this.fat;
	}

	public void setFat(BigDecimal fat) {
		this.fat = fat;
	}

}