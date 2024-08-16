package project.diet.control.app.beans.pojos.entity.generic;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
}
