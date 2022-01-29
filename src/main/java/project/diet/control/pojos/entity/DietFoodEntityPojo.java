package project.diet.control.pojos.entity;

import java.math.BigDecimal;

public class DietFoodEntityPojo {

	private Integer id;
	
	private BigDecimal portions;
	
	private BigDecimal unities;

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

	public BigDecimal getUnities() {
		return unities;
	}

	public void setUnities(BigDecimal unities) {
		this.unities = unities;
	}

	
}
