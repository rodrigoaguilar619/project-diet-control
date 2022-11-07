package project.diet.control.app.beans.pojos.diet;

import java.math.BigDecimal;

import project.diet.control.app.beans.pojos.entity.FoodEntityPojo;

public class DietFoodResumePojo extends FoodEntityPojo {

	private Integer idDietFood;
	
	private BigDecimal portions;
	
	private BigDecimal unities;

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

	public BigDecimal getUnities() {
		return unities;
	}

	public void setUnities(BigDecimal unities) {
		this.unities = unities;
	}
}
