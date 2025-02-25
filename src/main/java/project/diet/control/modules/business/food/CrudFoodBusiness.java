package project.diet.control.modules.business.food;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.persistance.GenericPersistence;
import lib.base.backend.vo.CrudOptionsEnum;
import lombok.RequiredArgsConstructor;
import project.diet.control.app.beans.entity.FoodEntity;
import project.diet.control.app.beans.pojos.entity.FoodEntityPojo;
import project.diet.control.app.beans.pojos.petition.data.food.AddEditFoodDataPojo;
import project.diet.control.app.beans.pojos.petition.data.food.GetFoodDataPojo;
import project.diet.control.app.beans.pojos.petition.data.food.GetFoodListDataPojo;
import project.diet.control.app.beans.pojos.petition.request.food.AddEditFoodRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.food.AddEditFoodsRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.food.DeleteFoodRequestPojo;
import project.diet.control.app.beans.pojos.petition.request.food.GetFoodRequestPojo;
import project.diet.control.app.repository.FoodRepositoryImpl;
import project.diet.control.app.vo.catalogs.CatalogsErrorMessage;
import project.diet.control.modules.business.MainBusiness;

@RequiredArgsConstructor
@Component
public class CrudFoodBusiness extends MainBusiness {
	
	@SuppressWarnings("rawtypes")
	private final GenericPersistence genericPersistance;
	private final FoodRepositoryImpl foodRepository;
	
	@SuppressWarnings("unchecked")
	public Integer setAddEditFood(FoodEntity foodEntity, FoodEntityPojo foodEntityPojo, CrudOptionsEnum crudOptionsEnum) {
		
		buildPojoToEntityUtil.generateFoodEntity(foodEntity, foodEntityPojo);
		
		if (crudOptionsEnum == CrudOptionsEnum.SAVE) {
			genericPersistance.save(foodEntity);
		}
		else if (crudOptionsEnum == CrudOptionsEnum.UPDATE) {
			genericPersistance.update(foodEntity);
		}
		
		return foodEntity.getId();
	}
	
	@Transactional(rollbackFor = Exception.class)
	public AddEditFoodDataPojo executeAddFood(AddEditFoodRequestPojo addEditFoodRequestPojo) throws BusinessException {
		
		if (addEditFoodRequestPojo.getFood() == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgFoodNotFoundRequest());
			
		Integer id = setAddEditFood(new FoodEntity(), addEditFoodRequestPojo.getFood(), CrudOptionsEnum.SAVE);
		
		AddEditFoodDataPojo responsePojo = new AddEditFoodDataPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public AddEditFoodDataPojo executeEditFood(AddEditFoodRequestPojo addEditFoodRequestPojo) throws BusinessException {
		
		FoodEntityPojo foodEntityPojo = addEditFoodRequestPojo.getFood();
		
		if (foodEntityPojo == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgFoodNotFoundRequest());
		
		if (foodEntityPojo.getId() == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgFoodIdIsNull());
		
		FoodEntity food = (FoodEntity) genericPersistance.findById(FoodEntity.class, foodEntityPojo.getId());
		
		if (food == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgFoodIdNotFound(foodEntityPojo.getId()));
			
		Integer id = setAddEditFood(food, addEditFoodRequestPojo.getFood(), CrudOptionsEnum.UPDATE);
		
		AddEditFoodDataPojo responsePojo = new AddEditFoodDataPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void executeAddFoods(AddEditFoodsRequestPojo addEditFoodsRequestPojo) {
		
		for(FoodEntityPojo foodEntityPojo: addEditFoodsRequestPojo.getFoods()) {
			
			setAddEditFood(new FoodEntity(), foodEntityPojo, CrudOptionsEnum.SAVE);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public GetFoodListDataPojo executeGetFoods() {
		
		List<FoodEntity> foods = genericPersistance.findAll(FoodEntity.class);
		List<FoodEntityPojo> foodEntityPojos = new ArrayList<>();
		
		for (FoodEntity food: foods) {
			
			foodEntityPojos.add(buildEntityToPojoUtil.generateFoodPojo(new FoodEntityPojo(), food));
		}
		
		GetFoodListDataPojo responsePojo = new GetFoodListDataPojo();
		responsePojo.setFoods(foodEntityPojos);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public void executeDeleteFood(DeleteFoodRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getId() == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgFoodIdIsNull());
		
		FoodEntity food = (FoodEntity) genericPersistance.findById(FoodEntity.class, requestPojo.getId());
		
		if (food == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgFoodIdNotFound(requestPojo.getId()));
		
		if (foodRepository.countRegisterDietFood(requestPojo.getId()) > 0)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgFoodIdUsedOnDietCustom());
		
		genericPersistance.delete(food);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public GetFoodDataPojo executeGetFood(GetFoodRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getId() == null)
			throw new BusinessException("Id can´t be null");
		
		FoodEntity food = (FoodEntity) genericPersistance.findById(FoodEntity.class, requestPojo.getId());
		
		if (food == null)
			throw new BusinessException(CatalogsErrorMessage.getErrorMsgFoodIdNotFound(requestPojo.getId()));
		
		FoodEntityPojo foodEntityPojo = buildEntityToPojoUtil.generateFoodPojo(new FoodEntityPojo(), food);
		
		GetFoodDataPojo responsePojo = new GetFoodDataPojo();
		responsePojo.setFood(foodEntityPojo);
		
		return responsePojo;
	}
}
