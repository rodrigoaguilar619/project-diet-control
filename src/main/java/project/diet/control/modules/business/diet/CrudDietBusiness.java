package project.diet.control.modules.business.diet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.enumerators.CrudOptionsEnum;
import lib.base.backend.exception.data.BusinessException;
import project.diet.control.app.beans.entity.Diet;
import project.diet.control.app.beans.entity.DietFood;
import project.diet.control.app.beans.pojos.diet.DietPojo;
import project.diet.control.app.beans.pojos.entity.DietFoodEntityPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.AddEditDietDataPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.AddEditDietRequestPojo;
import project.diet.control.app.repository.DietRepositoryImpl;
import project.diet.control.modules.business.MainBusiness;

@Component
public class CrudDietBusiness extends MainBusiness {
	
	@Autowired
	DietRepositoryImpl dietRepository;
	
	@SuppressWarnings("unchecked")
	public Integer setAddEditDiet(Diet dietEntity, DietPojo dietEntityPojo, CrudOptionsEnum crudOptionsEnum) {
		
		dietEntity = buildPojoToEntityUtil.generateDietEntity(dietEntity, dietEntityPojo);
		
		List<DietFood> dietFoods = new ArrayList<>();
		for(DietFoodEntityPojo dietFoodEntityPojo: dietEntityPojo.getFoods()) {
			
			DietFood dietFood = buildPojoToEntityUtil.generateDietFoodEntity(null, dietFoodEntityPojo, dietEntityPojo.getIdRecipe());
			dietFoods.add(dietFood);
		}
		
		if (crudOptionsEnum.getId() == CrudOptionsEnum.SAVE.getId()) {
			genericCustomPersistance.save(dietEntity);
		}
		else if (crudOptionsEnum.getId() == CrudOptionsEnum.UPDATE.getId()) {
			dietRepository.deleteDietFoods(dietEntityPojo.getIdRecipe());
			genericCustomPersistance.update(dietEntity);
		}
		
		genericCustomPersistance.save(dietFoods);
		
		return dietEntity.getIdRecipe();
	}
	
	@SuppressWarnings("unchecked")
	public void deleteDiet(Diet diet) {
		
		if (diet != null) {
			dietRepository.deleteDietFoods(diet.getIdRecipe());
			genericCustomPersistance.delete(diet);
		}
	}
	
	@Transactional(rollbackFor = Exception.class)
	public AddEditDietDataPojo executeAddDiet(AddEditDietRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getDiet() == null)
			throw new BusinessException("Diet data not found on request");
			
		Integer id = setAddEditDiet(new Diet(), requestPojo.getDiet(), CrudOptionsEnum.SAVE);
		
		AddEditDietDataPojo responsePojo = new AddEditDietDataPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public AddEditDietDataPojo executeEditDiet(AddEditDietRequestPojo requestPojo) throws BusinessException {
		
		DietPojo dietEntityPojo = requestPojo.getDiet();
		
		if (dietEntityPojo == null)
			throw new BusinessException("Diet data not found on request");
		
		if (dietEntityPojo.getIdRecipe() == null)
			throw new BusinessException("Diet id is null");
		
		Diet diet = (Diet) genericCustomPersistance.findById(Diet.class, dietEntityPojo.getIdRecipe());
		
		if (diet == null)
			throw new BusinessException("Diet id: " + dietEntityPojo.getIdRecipe() + " not found");
			
		Integer id = setAddEditDiet(diet, dietEntityPojo, CrudOptionsEnum.UPDATE);
		
		AddEditDietDataPojo responsePojo = new AddEditDietDataPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
}
