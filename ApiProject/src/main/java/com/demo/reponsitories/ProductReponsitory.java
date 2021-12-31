package com.demo.reponsitories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.Product;

@Repository
public interface ProductReponsitory extends CrudRepository<Product, Integer> {

}
