package project.diet.control.pojos.response.diet;

import project.diet.control.pojos.diet.DietCustomResumePojo;
import project.diet.control.pojos.diet.DietDataPojo;

public class GetDietCustomRespPojo extends DietCustomResumePojo {
	
	DietDataPojo dietCustom;

	public DietDataPojo getDietCustom() {
		return dietCustom;
	}

	public void setDietCustom(DietDataPojo dietCustom) {
		this.dietCustom = dietCustom;
	}
	
}
