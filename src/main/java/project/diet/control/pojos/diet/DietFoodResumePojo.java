package project.diet.control.pojos.diet;

import java.math.BigDecimal;

import project.diet.control.pojos.entity.FoodEntityPojo;

public class DietFoodResumePojo extends FoodEntityPojo {

	private Integer idDietFood;
	
	private BigDecimal portions;

	public Integer getIdDietFood() {
		return idDietFood;
	}

	public void setIdDietFood(Integer idDietFood) {
		this.idDietFood = idDietFood;
	}

	public BigDecimal getPortions() {
		return portions;
	}

	public void setPortions(BigDecimal portions) {
		this.portions = portions;
	}
}
