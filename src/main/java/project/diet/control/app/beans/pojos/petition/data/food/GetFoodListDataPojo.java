package project.diet.control.app.beans.pojos.petition.data.food;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.pojos.entity.FoodEntityPojo;

@Getter @Setter
public class GetFoodListDataPojo {

	List<FoodEntityPojo> foods = new ArrayList<>();
}
