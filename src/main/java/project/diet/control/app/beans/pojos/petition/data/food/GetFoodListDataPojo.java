package project.diet.control.app.beans.pojos.petition.data.food;

import java.util.ArrayList;
import java.util.List;

import project.diet.control.app.beans.pojos.entity.FoodEntityPojo;

public class GetFoodListDataPojo {

	List<FoodEntityPojo> foods = new ArrayList<>();

	public List<FoodEntityPojo> getFoods() {
		return foods;
	}

	public void setFoods(List<FoodEntityPojo> foods) {
		this.foods = foods;
	}
}
