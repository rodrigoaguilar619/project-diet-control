package project.diet.control.app.beans.entity;

import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.entity.generic.GenericNutrientEntity;

@Getter @Setter
@Entity
@Table(name="nutrition_goals")
public class NutritionGoalEntity extends GenericNutrientEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private BigDecimal calories;

	private BigDecimal carbohydrates;

	private BigDecimal fat;

}