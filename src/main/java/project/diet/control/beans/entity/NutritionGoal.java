package project.diet.control.beans.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;


/**
 * The persistent class for the nutrition_goals database table.
 * 
 */
@Entity
@Table(name="nutrition_goals")
@NamedQuery(name="NutritionGoal.findAll", query="SELECT n FROM NutritionGoal n")
public class NutritionGoal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private BigDecimal calories;

	private BigDecimal carbohydrates;

	private BigDecimal fat;

	private BigDecimal proteins;

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

	public BigDecimal getProteins() {
		return this.proteins;
	}

	public void setProteins(BigDecimal proteins) {
		this.proteins = proteins;
	}

}