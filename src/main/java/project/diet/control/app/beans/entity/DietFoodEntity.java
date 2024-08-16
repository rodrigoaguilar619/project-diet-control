package project.diet.control.app.beans.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.entity.generic.GenericDietEntity;

import java.math.BigDecimal;

@Getter @Setter
@Entity
@Table(name="diet_food")
public class DietFoodEntity extends GenericDietEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private BigDecimal portions;
	
	@Column(name="unities")
	private BigDecimal unities;
	
	@Column(name="id_food")
	private Integer idFood;
	
	@Column(name="id_diet")
	private Integer idDiet;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_food", insertable = false, updatable = false)
	private FoodEntity food;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_diet", insertable = false, updatable = false)
	private DietEntity diet;

}