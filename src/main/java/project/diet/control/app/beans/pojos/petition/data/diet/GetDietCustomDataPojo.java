package project.diet.control.app.beans.pojos.petition.data.diet;

import project.diet.control.app.beans.pojos.diet.DietCustomResumePojo;
import project.diet.control.app.beans.pojos.diet.DietDataPojo;

public class GetDietCustomDataPojo extends DietCustomResumePojo {
	
	DietDataPojo dietCustom;

	public DietDataPojo getDietCustom() {
		return dietCustom;
	}

	public void setDietCustom(DietDataPojo dietCustom) {
		this.dietCustom = dietCustom;
	}
	
}
