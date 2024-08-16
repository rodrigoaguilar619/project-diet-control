package project.diet.control.app.beans.pojos.petition.request.food;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.pojos.entity.FoodEntityPojo;
import project.diet.control.app.beans.pojos.petition.request.GenericRequestPojo;

@Getter @Setter
public class AddEditFoodsRequestPojo extends GenericRequestPojo {

	List<FoodEntityPojo> foods = new ArrayList<>();
}
