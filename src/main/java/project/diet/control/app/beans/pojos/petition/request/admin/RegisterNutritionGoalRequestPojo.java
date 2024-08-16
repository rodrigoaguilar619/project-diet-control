package project.diet.control.app.beans.pojos.petition.request.admin;

import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.pojos.entity.NutritionGoalEntityPojo;
import project.diet.control.app.beans.pojos.petition.request.GenericRequestPojo;

@Getter @Setter
public class RegisterNutritionGoalRequestPojo extends GenericRequestPojo {

	private NutritionGoalEntityPojo nutritionGoal;
}
