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
	
	@Column(name="total_fat_mono")
	private BigDecimal totalFatMono;

	@Column(name="total_fat_poli")
	private BigDecimal totalFatPoli;

	@Column(name="total_fat_sat")
	private BigDecimal totalFatSat;

	@Column(name="total_fat_trans")
	private BigDecimal totalFatTrans;

	@Column(name="total_carb_sugar")
	private BigDecimal totalCarbSugar;

	@Column(name="total_carb_sugar_added")
	private BigDecimal totalCarbSugarAdded;

	@Column(name="total_fiber")
	private BigDecimal totalFiber;

	@Column(name="total_cholesterol")
	private BigDecimal totalCholesterol;

	@Column(name="total_sodium")
	private BigDecimal totalSodium;
	
	@Column(name="unities")
	private BigDecimal unities;

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
	
	public BigDecimal getUnities() {
		return unities;
	}

	public void setUnities(BigDecimal unities) {
		this.unities = unities;
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

	public BigDecimal getTotalFatMono() {
		return totalFatMono;
	}

	public void setTotalFatMono(BigDecimal totalFatMono) {
		this.totalFatMono = totalFatMono;
	}

	public BigDecimal getTotalFatPoli() {
		return totalFatPoli;
	}

	public void setTotalFatPoli(BigDecimal totalFatPoli) {
		this.totalFatPoli = totalFatPoli;
	}

	public BigDecimal getTotalFatSat() {
		return totalFatSat;
	}

	public void setTotalFatSat(BigDecimal totalFatSat) {
		this.totalFatSat = totalFatSat;
	}

	public BigDecimal getTotalFatTrans() {
		return totalFatTrans;
	}

	public void setTotalFatTrans(BigDecimal totalFatTrans) {
		this.totalFatTrans = totalFatTrans;
	}

	public BigDecimal getTotalCarbSugar() {
		return totalCarbSugar;
	}

	public void setTotalCarbSugar(BigDecimal totalCarbSugar) {
		this.totalCarbSugar = totalCarbSugar;
	}

	public BigDecimal getTotalCarbSugarAdded() {
		return totalCarbSugarAdded;
	}

	public void setTotalCarbSugarAdded(BigDecimal totalCarbSugarAdded) {
		this.totalCarbSugarAdded = totalCarbSugarAdded;
	}

	public BigDecimal getTotalFiber() {
		return totalFiber;
	}

	public void setTotalFiber(BigDecimal totalFiber) {
		this.totalFiber = totalFiber;
	}

	public BigDecimal getTotalCholesterol() {
		return totalCholesterol;
	}

	public void setTotalCholesterol(BigDecimal totalCholesterol) {
		this.totalCholesterol = totalCholesterol;
	}

	public BigDecimal getTotalSodium() {
		return totalSodium;
	}

	public void setTotalSodium(BigDecimal totalSodium) {
		this.totalSodium = totalSodium;
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