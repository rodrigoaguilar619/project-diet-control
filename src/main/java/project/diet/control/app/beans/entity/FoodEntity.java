package project.diet.control.app.beans.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.entity.generic.GenericNutrientEntity;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "food")
public class FoodEntity extends GenericNutrientEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private BigDecimal calories;

	private BigDecimal carbohydrates;
	
	@Column(name="cost_kilo")
	private BigDecimal costKilo;

	@Column(name="cost_calorie")
	private BigDecimal costCalorie;

	@Column(name="cost_protein")
	private BigDecimal costProtein;
	
	@Column(name="cost_gram")
	private BigDecimal costGram;

	private String description;

	private BigDecimal fat;

	@Column(name="quantity_grams")
	private BigDecimal quantityGrams;
	
	@Column(name="unity_grams")
	private BigDecimal unityGrams;

	@OneToMany(mappedBy="food", fetch = FetchType.LAZY)
	private List<DietFoodEntity> dietFoods = new ArrayList<>();

}