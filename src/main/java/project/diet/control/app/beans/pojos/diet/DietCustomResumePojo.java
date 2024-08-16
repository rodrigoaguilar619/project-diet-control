package project.diet.control.app.beans.pojos.diet;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.pojos.entity.DietEntityPojo;

@Getter @Setter
public class DietCustomResumePojo {

	private DietEntityPojo subTotalDietBase;
	
	private DietEntityPojo subTotalDietCustom;
	
	private DietEntityPojo nutritionalGoals;
	
	List<DietFoodResumePojo> foodsDietBase = new ArrayList<>();
}
