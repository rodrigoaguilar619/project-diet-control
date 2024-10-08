package project.diet.control.modules.business.diet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lib.base.backend.persistance.GenericPersistence;
import project.diet.control.ProjectUnitTest;
import project.diet.control.app.beans.entity.DietEntity;
import project.diet.control.app.beans.entity.DietFoodEntity;
import project.diet.control.app.beans.entity.RecipeEntity;
import project.diet.control.app.beans.pojos.petition.data.diet.GetDietBaseDataPojo;
import project.diet.control.app.repository.DietRepositoryImpl;

class CrudDietBaseBusinessTest extends ProjectUnitTest {
	
	@InjectMocks
	private CrudDietBaseBusiness crudDietBaseBusiness;
	
	@SuppressWarnings("rawtypes")
	@Mock
    private GenericPersistence genericPersistance;
	
	@Mock
	DietRepositoryImpl dietRepository;
	
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

	@Test
	void testExecuteGetDietBase() {
		
		RecipeEntity recipeBase = new RecipeEntity();
		recipeBase.setId(1);
		recipeBase.setTitle("Test recipe");
		
		List<DietFoodEntity> dietFoods = new ArrayList<>();
		
		DietEntity dietBase = new DietEntity();
		dietBase.setIdRecipe(1);
		dietBase.setIsBase(true);
		dietBase.setRecipe(recipeBase);
		dietBase.setDietFoods(dietFoods);
		
		when(dietRepository.getDietBase()).thenReturn(dietBase);

		GetDietBaseDataPojo result = crudDietBaseBusiness.executeGetDietBase();
		
		assertEquals(dietBase.getIdRecipe(), result.getRecipe().getId());
	}

}
