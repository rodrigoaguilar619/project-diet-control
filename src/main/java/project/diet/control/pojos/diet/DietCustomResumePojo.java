package project.diet.control.pojos.diet;

import java.util.List;

import project.diet.control.pojos.entity.DietEntityPojo;

public class DietCustomResumePojo {

	private DietEntityPojo subTotalDietBase;
	
	private DietEntityPojo subTotalDietCustom;
	
	List<DietFoodResumePojo> foodsDietBase;
	
	public DietEntityPojo getSubTotalDietBase() {
		return subTotalDietBase;
	}
	
	public void setSubTotalDietBase(DietEntityPojo subTotalDietBase) {
		this.subTotalDietBase = subTotalDietBase;
	}
	
	public DietEntityPojo getSubTotalDietCustom() {
		return subTotalDietCustom;
	}
	
	public void setSubTotalDietCustom(DietEntityPojo subTotalDietCustom) {
		this.subTotalDietCustom = subTotalDietCustom;
	}

	public List<DietFoodResumePojo> getFoodsDietBase() {
		return foodsDietBase;
	}

	public void setFoodsDietBase(List<DietFoodResumePojo> foodsDietBase) {
		this.foodsDietBase = foodsDietBase;
	}
	
	
}
