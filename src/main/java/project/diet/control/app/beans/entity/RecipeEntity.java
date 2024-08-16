package project.diet.control.app.beans.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the recipe database table.
 * 
 */
@Entity
@Table(name = "recipe")
public class RecipeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String instructions;

	private String title;

	//bi-directional one-to-one association to Diet
	@OneToOne(mappedBy="recipe", fetch=FetchType.LAZY)
	private DietEntity diet;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstructions() {
		return this.instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public DietEntity getDiet() {
		return this.diet;
	}

	public void setDiet(DietEntity diet) {
		this.diet = diet;
	}

}