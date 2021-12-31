package com.demo.reponsitories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.demo.models.Category;

@Repository
public interface CategoryReponsitory extends CrudRepository<Category, Integer>{

}
