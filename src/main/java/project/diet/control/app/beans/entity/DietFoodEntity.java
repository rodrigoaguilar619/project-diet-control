package project.diet.control.app.beans.entity;

import jakarta.persistence.*;

import project.diet.control.app.beans.entity.generic.GenericDietEntity;

import java.math.BigDecimal;

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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getIdFood() {
		return idFood;
	}

	public void setIdFood(Integer idFood) {
		this.idFood = idFood;
	}

	public Integer getIdDiet() {
		return idDiet;
	}

	public void setIdDiet(Integer idDiet) {
		this.idDiet = idDiet;
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