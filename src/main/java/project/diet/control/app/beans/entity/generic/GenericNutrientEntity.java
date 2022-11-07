package project.diet.control.app.beans.entity.generic;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GenericNutrientEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
private BigDecimal proteins;
	
	@Column(name="fat_mono")
	private BigDecimal fatMono;

	@Column(name="fat_poli")
	private BigDecimal fatPoli;

	@Column(name="fat_sat")
	private BigDecimal fatSat;

	@Column(name="fat_trans")
	private BigDecimal fatTrans;

	@Column(name="carb_sugar")
	private BigDecimal carbSugar;

	@Column(name="carb_sugar_added")
	private BigDecimal carbSugarAdded;

	@Column(name="fiber")
	private BigDecimal fiber;

	@Column(name="cholesterol")
	private BigDecimal cholesterol;

	@Column(name="sodium")
	private BigDecimal sodium;
	
	public BigDecimal getProteins() {
		return this.proteins;
	}

	public void setProteins(BigDecimal proteins) {
		this.proteins = proteins;
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
}
