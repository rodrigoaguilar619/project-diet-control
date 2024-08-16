package project.diet.control.app.beans.pojos.petition.data.diet;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.pojos.diet.DietResumePojo;

@Getter @Setter
public class GetDietCustomListDataPojo {
	
	List<DietResumePojo> diets = new ArrayList<>();
}
