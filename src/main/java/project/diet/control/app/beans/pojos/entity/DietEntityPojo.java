package project.diet.control.app.beans.pojos.entity;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DietEntityPojo {

	private Boolean isBase;
	
	private Integer id;

	private BigDecimal totalCalories;

	private BigDecimal totalCarbohydrates;

	private BigDecimal totalFat;

	private BigDecimal totalProteins;

	private BigDecimal totalQuantityGrams;
	
	private BigDecimal totalFatMono;

	private BigDecimal totalFatPoli;

	private BigDecimal totalFatSat;

	private BigDecimal totalFatTrans;

	private BigDecimal totalCarbSugar;

	private BigDecimal totalCarbSugarAdded;

	private BigDecimal totalFiber;

	private BigDecimal totalCholesterol;

	private BigDecimal totalSodium;
}
