package project.diet.control.app.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.diet.control.app.beans.entity.DietFoodEntity;
import project.diet.control.app.beans.entity.DietFoodEntity_;
import project.diet.control.app.beans.entity.FoodEntity_;

@Repository
public class FoodRepositoryImpl extends MainRepository {

	@Autowired
	EntityManager em;
	
	public long countRegisterDietFood(Integer idFood) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<DietFoodEntity> root = cq.from(DietFoodEntity.class);
		
		Predicate predicateAnd = cb.and(
				cb.equal(root.get(DietFoodEntity_.food).get(FoodEntity_.id), idFood));
		
		cq.where( predicateAnd );
		cq.select(cb.count(root.get(DietFoodEntity_.food).get(FoodEntity_.id)));

		return (em.createQuery(cq).getResultList().get(0));
	}
}
