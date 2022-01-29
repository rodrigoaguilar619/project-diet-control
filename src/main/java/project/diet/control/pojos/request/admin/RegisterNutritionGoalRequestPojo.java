package project.diet.control.pojos.request.admin;

import project.diet.control.pojos.entity.NutritionGoalEntityPojo;

public class RegisterNutritionGoalRequestPojo {

	private NutritionGoalEntityPojo nutritionGoal;

	public NutritionGoalEntityPojo getNutritionGoal() {
		return nutritionGoal;
	}

	public void setNutritionGoal(NutritionGoalEntityPojo nutritionGoal) {
		this.nutritionGoal = nutritionGoal;
	}
}
