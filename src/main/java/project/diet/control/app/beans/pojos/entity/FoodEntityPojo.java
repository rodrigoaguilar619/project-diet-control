package project.diet.control.app.beans.pojos.entity;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.pojos.entity.generic.GenericNutrientEntityPojo;

@Getter @Setter
public class FoodEntityPojo extends GenericNutrientEntityPojo {

	private Integer id;
	
	private String description;
	
	private BigDecimal quantityGrams;
	
	private BigDecimal unityGrams;
	
	private BigDecimal calories;
	
	private BigDecimal carbohydrates;
	
	private BigDecimal proteins;
	
	private BigDecimal price;
	
	private BigDecimal costCalorie;
	
	private BigDecimal costProtein;
}
