package project.diet.control.app.beans.pojos.petition.request.recipe;

import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.pojos.petition.request.GenericRequestPojo;

@Getter @Setter
public class DeleteRecipeRequestPojo extends GenericRequestPojo {

	private Integer id;
}
