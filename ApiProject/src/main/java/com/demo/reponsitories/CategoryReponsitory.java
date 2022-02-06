package com.demo.reponsitories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.Dtos.Output.CategoryOutput;
import com.demo.models.Category;

@Repository
public interface CategoryReponsitory extends CrudRepository<Category, Integer> {

	@Query("select new com.demo.Dtos.Output.CategoryOutput(category.name, name, isDelete ) from Category")
	public List<CategoryOutput> getListCategory();

	@Query(value = "select * from category c1 LEFT join category c2 on c1.presentid = c2.id order by c1.id desc", nativeQuery = true)
	public List<Category> findAllCategory();

	@Query("select new com.demo.Dtos.Output.CategoryOutput(category.name, name ) from Category where id= :id")
	public CategoryOutput getCategory(@Param("id") int id);
	
	@Query("select new com.demo.Dtos.Output.CategoryOutput(id, name ) from Category where isDelete = 0")
	public List<CategoryOutput> getCateNotDel();
}
