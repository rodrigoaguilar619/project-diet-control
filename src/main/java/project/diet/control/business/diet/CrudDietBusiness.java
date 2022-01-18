package project.diet.control.business.diet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.persistance.GenericPersistence;
import lib.base.backend.web.enumeratos.CrudOptionsEnum;
import project.diet.control.beans.entity.Diet;
import project.diet.control.beans.entity.DietFood;
import project.diet.control.business.MainBusiness;
import project.diet.control.pojos.diet.DietPojo;
import project.diet.control.pojos.entity.DietFoodEntityPojo;
import project.diet.control.pojos.request.diet.AddEditDietRequestPojo;
import project.diet.control.pojos.request.diet.RegisterDietBaseRequestPojo;
import project.diet.control.pojos.response.diet.AddEditDietRespPojo;
import project.diet.control.repository.DietRepositoryImpl;
import project.diet.control.util.BuildEntityToPojoUtil;
import project.diet.control.util.BuildPojoToEntityUtil;

@Component
public class CrudDietBusiness extends MainBusiness {
	
	@Autowired
	DietRepositoryImpl dietRepository;
	
	@SuppressWarnings("unchecked")
	public Integer setAddEditDiet(Diet dietEntity, DietPojo dietEntityPojo, CrudOptionsEnum crudOptionsEnum) {
		
		dietEntity = buildPojoToEntityUtil.generateDietEntity(dietEntity, dietEntityPojo);
		
		List<DietFood> dietFoods = new ArrayList<DietFood>();
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
	
	@Transactional
	public AddEditDietRespPojo executeAddDiet(AddEditDietRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getDiet() == null)
			throw new BusinessException("Diet data not found on request");
			
		Integer id = setAddEditDiet(new Diet(), requestPojo.getDiet(), CrudOptionsEnum.SAVE);
		
		AddEditDietRespPojo responsePojo = new AddEditDietRespPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public AddEditDietRespPojo executeEditDiet(AddEditDietRequestPojo requestPojo) throws BusinessException {
		
		DietPojo dietEntityPojo = requestPojo.getDiet();
		
		if (dietEntityPojo == null)
			throw new BusinessException("Diet data not found on request");
		
		if (dietEntityPojo.getIdRecipe() == null)
			throw new BusinessException("Diet id is null");
		
		Diet diet = (Diet) genericCustomPersistance.findById(Diet.class, dietEntityPojo.getIdRecipe());
		
		if (diet == null)
			throw new BusinessException("Diet id: " + dietEntityPojo.getIdRecipe() + " not found");
			
		Integer id = setAddEditDiet(diet, dietEntityPojo, CrudOptionsEnum.UPDATE);
		
		AddEditDietRespPojo responsePojo = new AddEditDietRespPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
}
