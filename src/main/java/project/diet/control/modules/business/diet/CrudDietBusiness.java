package project.diet.control.modules.business.diet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.enumerators.CrudOptionsEnum;
import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.persistance.GenericPersistence;
import lombok.RequiredArgsConstructor;
import project.diet.control.app.beans.entity.DietEntity;
import project.diet.control.app.beans.entity.DietFoodEntity;
import project.diet.control.app.beans.entity.FoodEntity;
import project.diet.control.app.beans.pojos.diet.DietPojo;
import project.diet.control.app.beans.pojos.entity.DietFoodEntityPojo;
import project.diet.control.app.beans.pojos.petition.data.diet.AddEditDietDataPojo;
import project.diet.control.app.beans.pojos.petition.request.diet.AddEditDietRequestPojo;
import project.diet.control.app.repository.DietRepositoryImpl;
import project.diet.control.app.vo.catalogs.CatalogsErrorMessage;
import project.diet.control.config.helper.DietHelper;
import project.diet.control.modules.business.MainBusiness;

@RequiredArgsConstructor
@Component
public class CrudDietBusiness extends MainBusiness {
	
	@SuppressWarnings("rawtypes")
	protected final GenericPersistence genericPersistance;
	protected final DietRepositoryImpl dietRepository;
	protected final DietHelper dietHelper;
	
	@SuppressWarnings("unchecked")
	public Integer setAddEditDiet(DietEntity dietEntity, DietPojo dietEntityPojo, CrudOptionsEnum crudOptionsEnum) {
		
		dietEntity = dietHelper.generateDietEntity(dietEntity, dietEntityPojo);
		
		List<DietFoodEntity> dietFoods = new ArrayList<>();
		for(DietFoodEntityPojo dietFoodEntityPojo: dietEntityPojo.getFoods()) {
			
			FoodEntity food = (FoodEntity) genericPersistance.findById(FoodEntity.class, dietFoodEntityPojo.getId());
			DietFoodEntity dietFood = buildPojoToEntityUtil.generateDietFoodEntity(null, food, dietFoodEntityPojo, dietEntityPojo.getIdRecipe());
			dietFoods.add(dietFood);
		}
		
		if (crudOptionsEnum.getId() == CrudOptionsEnum.SAVE.getId()) {
			genericPersistance.save(dietEntity);
		}
		else if (crudOptionsEnum.getId() == CrudOptionsEnum.UPDATE.getId()) {
			dietRepository.deleteDietFoods(dietEntityPojo.getIdRecipe());
			genericPersistance.update(dietEntity);
		}
		
		genericPersistance.save(dietFoods);
		
		return dietEntity.getIdRecipe();
	}
	
	@SuppressWarnings("unchecked")
	public void deleteDiet(DietEntity diet) {
		
		if (diet != null) {
			dietRepository.deleteDietFoods(diet.getIdRecipe());
			genericPersistance.delete(diet);
		}
	}
	
	@Transactional(rollbackFor = Exception.class)
	public AddEditDietDataPojo executeAddDiet(AddEditDietRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getDiet() == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgDietNotFoundRequest());
			
		Integer id = setAddEditDiet(new DietEntity(), requestPojo.getDiet(), CrudOptionsEnum.SAVE);
		
		AddEditDietDataPojo responsePojo = new AddEditDietDataPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public AddEditDietDataPojo executeEditDiet(AddEditDietRequestPojo requestPojo) throws BusinessException {
		
		DietPojo dietEntityPojo = requestPojo.getDiet();
		
		if (dietEntityPojo == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgDietNotFoundRequest());
		
		if (dietEntityPojo.getIdRecipe() == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgDietIdIsNull());
		
		DietEntity diet = (DietEntity) genericPersistance.findById(DietEntity.class, dietEntityPojo.getIdRecipe());
		
		if (diet == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgDietIdNotFound(dietEntityPojo.getIdRecipe()));
			
		Integer id = setAddEditDiet(diet, dietEntityPojo, CrudOptionsEnum.UPDATE);
		
		AddEditDietDataPojo responsePojo = new AddEditDietDataPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
}
