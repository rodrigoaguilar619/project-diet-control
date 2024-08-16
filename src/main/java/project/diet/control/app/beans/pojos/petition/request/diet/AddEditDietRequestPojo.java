package project.diet.control.app.beans.pojos.petition.request.diet;

import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.pojos.diet.DietPojo;
import project.diet.control.app.beans.pojos.petition.request.GenericRequestPojo;

@Getter @Setter
public class AddEditDietRequestPojo extends GenericRequestPojo {

	private DietPojo diet;
}
