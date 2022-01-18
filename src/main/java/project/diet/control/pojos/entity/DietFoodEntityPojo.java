package project.diet.control.pojos.entity;

import java.math.BigDecimal;

public class DietFoodEntityPojo {

	private Integer id;
	
	private BigDecimal portions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer idFood) {
		this.id = idFood;
	}

	public BigDecimal getPortions() {
		return portions;
	}

	public void setPortions(BigDecimal portions) {
		this.portions = portions;
	}
}
