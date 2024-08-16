package project.diet.control.app.beans.entity.generic;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
	
}
