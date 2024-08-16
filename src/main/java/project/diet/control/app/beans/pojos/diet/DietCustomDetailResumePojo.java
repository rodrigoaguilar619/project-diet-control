package project.diet.control.app.beans.pojos.diet;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.pojos.entity.DietEntityPojo;
import project.diet.control.app.beans.pojos.entity.RecipeEntityPojo;

@Getter @Setter
public class DietCustomDetailResumePojo {
	
	private Integer idDietCustom;

	private DietEntityPojo subTotalDietBase;
	
	private DietEntityPojo subTotalDietCustom;
	
	private DietEntityPojo totalDiet;

	private RecipeEntityPojo recipe;
	
	private List<DietFoodResumePojo> foods;
	
}
