package project.diet.control.pojos.response.diet;

import java.util.ArrayList;
import java.util.List;

import project.diet.control.pojos.diet.DietFoodResumePojo;
import project.diet.control.pojos.diet.DietResumePojo;
import project.diet.control.pojos.entity.DietEntityPojo;
import project.diet.control.pojos.entity.RecipeEntityPojo;

public class GetDietCustomListRespPojo {
	
	List<DietResumePojo> diets = new ArrayList<DietResumePojo>();

	public List<DietResumePojo> getDiets() {
		return diets;
	}

	public void setDiets(List<DietResumePojo> diets) {
		this.diets = diets;
	}

}
