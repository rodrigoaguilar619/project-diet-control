package project.diet.control.app.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import project.diet.control.ProjectJpaTest;
import project.diet.control.app.beans.entity.Diet;

class DietRepositoryImplTest extends ProjectJpaTest {
	
	@Autowired
	DietRepositoryImpl dietRepository;

	@Test
	void testDeleteDietFoods() {

		dietRepository.deleteDietFoods(1);
		
		assertTrue(true);
	}

	@Test
	void testGetDietBase() {

		Diet diet = dietRepository.getDietBase();
		
		assertNotNull(diet);
	}

	@Test
	void testGetDietCustomList() {
		
		Diet diet = dietRepository.getDietBase();
		
		assertNotNull(diet);
	}

	@Test
	void testCountRegisterDiet() {
		
		long totalRegistered = dietRepository.countRegisterDiet(1);
		
		assertTrue(totalRegistered > 0);
		
	}

}
