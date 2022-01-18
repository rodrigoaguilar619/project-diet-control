package project.diet.control.pojos.response.food;

import java.util.ArrayList;
import java.util.List;

import project.diet.control.pojos.entity.FoodEntityPojo;

public class GetFoodListRespPojo {

	List<FoodEntityPojo> foods = new ArrayList<FoodEntityPojo>();

	public List<FoodEntityPojo> getFoods() {
		return foods;
	}

	public void setFoods(List<FoodEntityPojo> foods) {
		this.foods = foods;
	}
}
