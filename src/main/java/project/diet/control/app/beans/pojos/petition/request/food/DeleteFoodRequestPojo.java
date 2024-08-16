package project.diet.control.app.beans.pojos.petition.request.food;

import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.pojos.petition.request.GenericRequestPojo;

@Getter @Setter
public class DeleteFoodRequestPojo extends GenericRequestPojo {

	private Integer id;	
}
