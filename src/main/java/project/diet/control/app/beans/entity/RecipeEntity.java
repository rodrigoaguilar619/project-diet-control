package project.diet.control.app.beans.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "recipe")
public class RecipeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String instructions;

	private String title;

	@OneToOne(mappedBy="recipe", fetch=FetchType.LAZY)
	private DietEntity diet;

}