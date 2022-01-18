package project.diet.control.beans.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the diet_food database table.
 * 
 */
@Entity
@Table(name="diet_food")
@NamedQuery(name="DietFood.findAll", query="SELECT d FROM DietFood d")
public class DietFood implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private BigDecimal portions;

	@Column(name="total_calories")
	private BigDecimal totalCalories;

	@Column(name="total_carbohydrates")
	private BigDecimal totalCarbohydrates;

	@Column(name="total_fat")
	private BigDecimal totalFat;

	@Column(name="total_proteins")
	private BigDecimal totalProteins;

	@Column(name="total_quantity_grams")
	private BigDecimal totalQuantityGrams;

	//bi-directional many-to-one association to Food
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_food")
	private Food food;

	//bi-directional many-to-one association to Diet
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_diet")
	private Diet diet;

	public DietFood() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPortions() {
		return this.portions;
	}

	public void setPortions(BigDecimal portions) {
		this.portions = portions;
	}

	public BigDecimal getTotalCalories() {
		return this.totalCalories;
	}

	public void setTotalCalories(BigDecimal totalCalories) {
		this.totalCalories = totalCalories;
	}

	public BigDecimal getTotalCarbohydrates() {
		return this.totalCarbohydrates;
	}

	public void setTotalCarbohydrates(BigDecimal totalCarbohydrates) {
		this.totalCarbohydrates = totalCarbohydrates;
	}

	public BigDecimal getTotalFat() {
		return this.totalFat;
	}

	public void setTotalFat(BigDecimal totalFat) {
		this.totalFat = totalFat;
	}

	public BigDecimal getTotalProteins() {
		return this.totalProteins;
	}

	public void setTotalProteins(BigDecimal totalProteins) {
		this.totalProteins = totalProteins;
	}

	public BigDecimal getTotalQuantityGrams() {
		return this.totalQuantityGrams;
	}

	public void setTotalQuantityGrams(BigDecimal totalQuantityGrams) {
		this.totalQuantityGrams = totalQuantityGrams;
	}

	public Food getFood() {
		return this.food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Diet getDiet() {
		return this.diet;
	}

	public void setDiet(Diet diet) {
		this.diet = diet;
	}

}