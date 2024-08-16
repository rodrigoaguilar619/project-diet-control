package project.diet.control.app.beans.pojos.diet;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.pojos.entity.DietFoodEntityPojo;

@Getter @Setter
public class DietPojo {

	private Integer idRecipe;
	
	private Boolean isBase;
	
	private List<DietFoodEntityPojo> foods = new ArrayList<>();
}
