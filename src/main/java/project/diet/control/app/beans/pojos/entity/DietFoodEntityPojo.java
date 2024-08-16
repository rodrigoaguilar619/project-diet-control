package project.diet.control.app.beans.pojos.entity;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DietFoodEntityPojo {

	private Integer id;
	
	private BigDecimal portions;
	
	private BigDecimal unities;	
}
