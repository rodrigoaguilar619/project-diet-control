package project.diet.control.business.food;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.base.backend.exception.data.BusinessException;
import lib.base.backend.persistance.GenericPersistence;
import lib.base.backend.web.enumeratos.CrudOptionsEnum;
import project.diet.control.beans.entity.Food;
import project.diet.control.pojos.entity.FoodEntityPojo;
import project.diet.control.pojos.request.food.AddEditFoodRequestPojo;
import project.diet.control.pojos.request.food.AddEditFoodsRequestPojo;
import project.diet.control.pojos.request.food.DeleteFoodRequestPojo;
import project.diet.control.pojos.request.food.GetFoodRequestPojo;
import project.diet.control.pojos.response.food.AddEditFoodRespPojo;
import project.diet.control.pojos.response.food.GetFoodListRespPojo;
import project.diet.control.pojos.response.food.GetFoodRespPojo;
import project.diet.control.util.BuildEntityToPojoUtil;
import project.diet.control.util.BuildPojoToEntityUtil;

@Component
public class CrudFoodBusiness {

	@SuppressWarnings("rawtypes")
	@Autowired
	GenericPersistence genericCustomPersistance;
	
	@Autowired
	BuildPojoToEntityUtil buildPojoToEntityUtil;
	
	@Autowired
	BuildEntityToPojoUtil buildEntityToPojoUtil;
	
	private String messageFoodNotFound(Integer idFood) {
		
		return "Food id: " + idFood + " not found";
	}
	
	@SuppressWarnings("unchecked")
	public Integer setAddEditFood(Food foodEntity, FoodEntityPojo foodEntityPojo, CrudOptionsEnum crudOptionsEnum) {
		
		buildPojoToEntityUtil.generateFoodEntity(foodEntity, foodEntityPojo);
		
		if (crudOptionsEnum.getId() == CrudOptionsEnum.SAVE.getId()) {
			genericCustomPersistance.save(foodEntity);
		}
		else if (crudOptionsEnum.getId() == CrudOptionsEnum.UPDATE.getId()) {
			genericCustomPersistance.update(foodEntity);
		}
		
		return foodEntity.getId();
	}
	
	@Transactional
	public AddEditFoodRespPojo executeAddFood(AddEditFoodRequestPojo addEditFoodRequestPojo) throws BusinessException {
		
		if (addEditFoodRequestPojo.getFood() == null)
			throw new BusinessException("Food data not found on request");
			
		Integer id = setAddEditFood(new Food(), addEditFoodRequestPojo.getFood(), CrudOptionsEnum.SAVE);
		
		AddEditFoodRespPojo responsePojo = new AddEditFoodRespPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public AddEditFoodRespPojo executeEditFood(AddEditFoodRequestPojo addEditFoodRequestPojo) throws BusinessException {
		
		FoodEntityPojo foodEntityPojo = addEditFoodRequestPojo.getFood();
		
		if (foodEntityPojo == null)
			throw new BusinessException("Food data not found on request");
		
		if (foodEntityPojo.getId() == null)
			throw new BusinessException("Food id is null");
		
		Food food = (Food) genericCustomPersistance.findById(Food.class, foodEntityPojo.getId());
		
		if (food == null)
			throw new BusinessException(messageFoodNotFound(foodEntityPojo.getId()));
			
		Integer id = setAddEditFood(food, addEditFoodRequestPojo.getFood(), CrudOptionsEnum.UPDATE);
		
		AddEditFoodRespPojo responsePojo = new AddEditFoodRespPojo();
		responsePojo.setId(id);
		
		return responsePojo;
	}
	
	@Transactional
	public void executeAddFoods(AddEditFoodsRequestPojo addEditFoodsRequestPojo) {
		
		for(FoodEntityPojo foodEntityPojo: addEditFoodsRequestPojo.getFoods()) {
			
			setAddEditFood(new Food(), foodEntityPojo, CrudOptionsEnum.SAVE);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public GetFoodListRespPojo executeGetFoods() {
		
		List<Food> foods = genericCustomPersistance.findAll(Food.class);
		List<FoodEntityPojo> foodEntityPojos = new ArrayList<>();
		
		for (Food food: foods) {
			
			foodEntityPojos.add(buildEntityToPojoUtil.generateFoodPojo(new FoodEntityPojo(), food));
		}
		
		GetFoodListRespPojo responsePojo = new GetFoodListRespPojo();
		responsePojo.setFoods(foodEntityPojos);
		
		return responsePojo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public void executeDeleteFood(DeleteFoodRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getId() == null)
			throw new BusinessException("Id can´t be null");
		
		Food food = (Food) genericCustomPersistance.findById(Food.class, requestPojo.getId());
		
		if (food == null)
			throw new BusinessException(messageFoodNotFound(requestPojo.getId()));
		
		genericCustomPersistance.delete(food);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public GetFoodRespPojo executeGetFood(GetFoodRequestPojo requestPojo) throws BusinessException {
		
		if (requestPojo.getId() == null)
			throw new BusinessException("Id can´t be null");
		
		Food food = (Food) genericCustomPersistance.findById(Food.class, requestPojo.getId());
		
		if (food == null)
			throw new BusinessException(messageFoodNotFound(requestPojo.getId()));
		
		FoodEntityPojo foodEntityPojo = buildEntityToPojoUtil.generateFoodPojo(new FoodEntityPojo(), food);
		
		GetFoodRespPojo responsePojo = new GetFoodRespPojo();
		responsePojo.setFood(foodEntityPojo);
		
		return responsePojo;
	}
}
