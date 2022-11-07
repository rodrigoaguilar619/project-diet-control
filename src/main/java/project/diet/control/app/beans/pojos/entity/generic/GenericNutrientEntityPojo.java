package project.diet.control.app.beans.pojos.entity.generic;

import java.math.BigDecimal;

public class GenericNutrientEntityPojo {

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
	
	public BigDecimal getFatSat() {
		return fatSat;
	}

	public void setFatSat(BigDecimal fatSat) {
		this.fatSat = fatSat;
	}
	
	public BigDecimal getFat() {
		return fat;
	}

	public void setFat(BigDecimal fat) {
		this.fat = fat;
	}
	
	public BigDecimal getCarbSugar() {
		return carbSugar;
	}

	public void setCarbSugar(BigDecimal carbSugar) {
		this.carbSugar = carbSugar;
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
	
	public BigDecimal getSodium() {
		return sodium;
	}

	public void setSodium(BigDecimal sodium) {
		this.sodium = sodium;
	}

	public BigDecimal getFatTrans() {
		return fatTrans;
	}

	public void setFatTrans(BigDecimal fatTrans) {
		this.fatTrans = fatTrans;
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
}
