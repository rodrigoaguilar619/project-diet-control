package project.diet.control.app.beans.pojos.petition.data.recipe;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.pojos.entity.RecipeEntityPojo;

@Getter @Setter
public class GetRecipeListDataPojo {

	List<RecipeEntityPojo> recipes = new ArrayList<>();
}
