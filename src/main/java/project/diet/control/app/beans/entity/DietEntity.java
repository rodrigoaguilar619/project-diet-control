package project.diet.control.app.beans.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.diet.control.app.beans.entity.generic.GenericDietEntity;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "diet")
public class DietEntity extends GenericDietEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_recipe")
	private Integer idRecipe;

	@Column(name="is_base")
	private Boolean isBase;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_recipe", insertable = false, updatable = false)
	private RecipeEntity recipe;

	@OneToMany(mappedBy="diet", fetch = FetchType.LAZY)
	private List<DietFoodEntity> dietFoods = new ArrayList<>();

	public DietEntity() {
	}

	public DietEntity(int idRecipe) {
		super();
		this.idRecipe = idRecipe;
	}

}