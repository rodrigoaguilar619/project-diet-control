package project.diet.control.app.beans.entity.generic;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@MappedSuperclass
public class GenericNutrientEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private BigDecimal proteins;
	
	@Column(name="fat_mono")
	private BigDecimal fatMono;

	@Column(name="fat_poli")
	private BigDecimal fatPoli;

	@Column(name="fat_sat")
	private BigDecimal fatSat;

	@Column(name="fat_trans")
	private BigDecimal fatTrans;

	@Column(name="carb_sugar")
	private BigDecimal carbSugar;

	@Column(name="carb_sugar_added")
	private BigDecimal carbSugarAdded;

	@Column(name="fiber")
	private BigDecimal fiber;

	@Column(name="cholesterol")
	private BigDecimal cholesterol;

	@Column(name="sodium")
	private BigDecimal sodium;
	
}
