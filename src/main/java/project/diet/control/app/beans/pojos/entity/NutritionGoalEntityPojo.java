package project.diet.control.app.beans.pojos.entity;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.pojos.entity.generic.GenericNutrientEntityPojo;

@Getter @Setter
public class NutritionGoalEntityPojo extends GenericNutrientEntityPojo {
	
	private BigDecimal calories;
	
	private BigDecimal proteins;
	
	private BigDecimal carbohydrates;
}
