package project.diet.control.pojos.response.diet;

import java.util.List;

import project.diet.control.pojos.diet.DietCustomDetailResumePojo;
import project.diet.control.pojos.diet.DietDataPojo;

public class GetDietCustomDetailListRespPojo {

	List<DietCustomDetailResumePojo> dietCustomDetailList;

	public List<DietCustomDetailResumePojo> getDietCustomDetailList() {
		return dietCustomDetailList;
	}

	public void setDietCustomDetailList(List<DietCustomDetailResumePojo> dietCustomDetailList) {
		this.dietCustomDetailList = dietCustomDetailList;
	}
	
}
