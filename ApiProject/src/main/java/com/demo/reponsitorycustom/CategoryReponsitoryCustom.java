//package com.demo.reponsitorycustom;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//
//import com.demo.Dtos.Output.CategoryOutput;
//import com.demo.models.Category;
//
//public class CategoryReponsitoryCustom implements ICategoryReponsitoryCustom {
//
//	@PersistenceContext
//	private EntityManager entityManager;
//	@Override
//	public List<CategoryOutput> findAll2() {
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Category> criteriaQuery = cb.createQuery(Category.class);
//		Root<Category> category = criteriaQuery.from(Category.class);
//		criteriaQuery.select(category);
//		
//		return null;
//	}
//
//}
