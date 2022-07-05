package project.diet.control.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.diet.control.beans.entity.Diet;
import project.diet.control.beans.entity.DietFood;
import project.diet.control.beans.entity.DietFood_;
import project.diet.control.beans.entity.Diet_;
import project.diet.control.beans.entity.Food_;

@Repository
public class DietRepositoryImpl extends MainRepository {

	@Autowired
	EntityManager em;
	
	public void deleteDietFoods(Integer idRecipe) {
		
		Query query = em.createQuery("DELETE FROM " + jpaUtil.getTableMetaModel(DietFood_.class) + " WHERE " + DietFood_.diet.getName() + " = :idRecipe");
		query.setParameter("idRecipe", new Diet(idRecipe));
		query.executeUpdate();
	}
	
	public Diet getDietBase() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Diet> cq = cb.createQuery(Diet.class);
		Root<Diet> root = cq.from(Diet.class);
				
		Predicate predicateAnd = cb.and(
				cb.equal(root.get(Diet_.isBase), true));
		
		cq.where( predicateAnd );
		
		List<Diet> resultList = em.createQuery(cq).setMaxResults(1).getResultList();
		return (resultList.isEmpty()) ? null : resultList.get(0);
		
	}
	
	public List<Diet> getDietCustomList() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Diet> cq = cb.createQuery(Diet.class);
		Root<Diet> root = cq.from(Diet.class);
				
		Predicate predicateAnd = cb.and(
				cb.equal(root.get(Diet_.isBase), false));
		
		cq.where( predicateAnd );
		
		return em.createQuery(cq).getResultList();
	}
	
	public long countRegisterDiet(Integer idDiet) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Diet> root = cq.from(Diet.class);
		
		Predicate predicateAnd = cb.and(
				cb.equal(root.get(Diet_.idRecipe), idDiet));
		
		cq.where( predicateAnd );
		cq.select(cb.count(root.get(Diet_.idRecipe)));

		return (long)(em.createQuery(cq).getResultList().get(0));
	}
}
