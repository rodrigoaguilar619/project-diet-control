package project.diet.control.app.beans.entity;

import jakarta.persistence.*;

import project.diet.control.app.beans.entity.generic.GenericDietEntity;

import java.math.BigDecimal;


/**
 * The persistent class for the diet_food database table.
 * 
 */
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

	//bi-directional many-to-one association to Food
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_food")
	private FoodEntity food;

	//bi-directional many-to-one association to Diet
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_diet")
	private DietEntity diet;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPortions() {
		return this.portions;
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

	public FoodEntity getFood() {
		return this.food;
	}

	public void setFood(FoodEntity food) {
		this.food = food;
	}

	public DietEntity getDiet() {
		return this.diet;
	}

	public void setDiet(DietEntity diet) {
		this.diet = diet;
	}

}