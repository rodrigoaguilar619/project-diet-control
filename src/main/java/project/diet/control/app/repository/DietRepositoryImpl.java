package project.diet.control.app.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.diet.control.app.beans.entity.DietEntity;
import project.diet.control.app.beans.entity.DietFoodEntity_;
import project.diet.control.app.beans.entity.DietEntity_;

@Repository
public class DietRepositoryImpl extends MainRepository {

	@Autowired
	EntityManager em;
	
	public void deleteDietFoods(Integer idRecipe) {
		
		Query query = em.createQuery(StringEscapeUtils.escapeSql("DELETE FROM " + jpaUtil.getTableMetaModel(DietFoodEntity_.class) + " WHERE " + DietFoodEntity_.diet.getName() + " = :idRecipe"));
		
		query.setParameter("idRecipe", new DietEntity(idRecipe));
		query.executeUpdate();
	}
	
	public DietEntity getDietBase() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DietEntity> cq = cb.createQuery(DietEntity.class);
		Root<DietEntity> root = cq.from(DietEntity.class);
				
		Predicate predicateAnd = cb.and(
				cb.equal(root.get(DietEntity_.isBase), true));
		
		cq.where( predicateAnd );
		
		List<DietEntity> resultList = em.createQuery(cq).setMaxResults(1).getResultList();
		return (resultList.isEmpty()) ? null : resultList.get(0);
		
	}
	
	public List<DietEntity> getDietCustomList() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DietEntity> cq = cb.createQuery(DietEntity.class);
		Root<DietEntity> root = cq.from(DietEntity.class);
				
		Predicate predicateAnd = cb.and(
				cb.equal(root.get(DietEntity_.isBase), false));
		
		cq.where( predicateAnd );
		
		return em.createQuery(cq).getResultList();
	}
	
	public long countRegisterDiet(Integer idDiet) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<DietEntity> root = cq.from(DietEntity.class);
		
		Predicate predicateAnd = cb.and(
				cb.equal(root.get(DietEntity_.idRecipe), idDiet));
		
		cq.where( predicateAnd );
		cq.select(cb.count(root.get(DietEntity_.idRecipe)));

		return (em.createQuery(cq).getResultList().get(0));
	}
}
