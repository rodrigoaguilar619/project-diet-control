package project.diet.control.app.beans.pojos.diet;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.pojos.entity.DietEntityPojo;
import project.diet.control.app.beans.pojos.entity.RecipeEntityPojo;

@Getter @Setter
public class DietDataPojo {

	RecipeEntityPojo recipe;
	
	DietEntityPojo diet;
	
	List<DietFoodResumePojo> foods = new ArrayList<>();
}
