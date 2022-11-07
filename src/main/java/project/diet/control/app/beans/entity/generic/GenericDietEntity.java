package project.diet.control.app.beans.entity.generic;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GenericDietEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
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

	@Column(name="total_quantity_grams")
	private BigDecimal totalQuantityGrams;
	
	public BigDecimal getTotalCalories() {
		return this.totalCalories;
	}

	public void setTotalCalories(BigDecimal totalCalories) {
		this.totalCalories = totalCalories;
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
	
	public void setTotalFatSat(BigDecimal totalFatSat) {
		this.totalFatSat = totalFatSat;
	}

	public BigDecimal getTotalFatTrans() {
		return totalFatTrans;
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

	public void setTotalFatTrans(BigDecimal totalFatTrans) {
		this.totalFatTrans = totalFatTrans;
	}
	
	public BigDecimal getTotalSodium() {
		return totalSodium;
	}

	public void setTotalSodium(BigDecimal totalSodium) {
		this.totalSodium = totalSodium;
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

	public BigDecimal getTotalQuantityGrams() {
		return this.totalQuantityGrams;
	}

	public void setTotalQuantityGrams(BigDecimal totalQuantityGrams) {
		this.totalQuantityGrams = totalQuantityGrams;
	}
	
}
