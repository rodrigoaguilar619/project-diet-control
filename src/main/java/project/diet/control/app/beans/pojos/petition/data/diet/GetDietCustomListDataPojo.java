package project.diet.control.app.beans.pojos.petition.data.diet;

import java.util.ArrayList;
import java.util.List;

import project.diet.control.app.beans.pojos.diet.DietResumePojo;

public class GetDietCustomListDataPojo {
	
	List<DietResumePojo> diets = new ArrayList<>();

	public List<DietResumePojo> getDiets() {
		return diets;
	}

	public void setDiets(List<DietResumePojo> diets) {
		this.diets = diets;
	}

}
