package project.diet.control.app.beans.pojos.diet;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.pojos.entity.FoodEntityPojo;

@Getter @Setter
public class DietFoodResumePojo extends FoodEntityPojo {

	private Integer idDietFood;
	
	private BigDecimal portions;
	
	private BigDecimal unities;
}
