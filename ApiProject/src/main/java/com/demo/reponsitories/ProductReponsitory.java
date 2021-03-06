package com.demo.reponsitories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.Dtos.Output.ProductOutput;
import com.demo.models.Product;

@Repository
public interface ProductReponsitory extends CrudRepository<Product, Integer> {
	@Query(value = "select new com.demo.Dtos.Output.ProductOutput(id, category.name, name , "
			+ "priceMin, image, description, status, isAccept) from Product "
			+ "where  isDelete = 0 and isAccept = 1 and status = 1  order by id desc ")
	public List<ProductOutput> getListProductByClient();

	@Query(value = "select new com.demo.Dtos.Output.ProductOutput(id, category.name, name , "
			+ "priceMin, image, description, status, isAccept, vendorId) from Product " + "where  id = :id ")
	public ProductOutput find2(@Param("id") int id);

	@Query(value = "select new com.demo.Dtos.Output.ProductOutput(id, category.name, name , "
			+ "priceMin, image, description, status, isAccept, isDelete) from Product  order by id desc ")
	public List<ProductOutput> findAllProduct();

	@Query(value = "select new com.demo.Dtos.Output.ProductOutput(id, category.name, name ,priceMin,  image, "
			+ "description, status, isAccept) from Product where name like %:name% and isDelete = 0 "
			+ "and isAccept = 1 and status = 1 order by id desc")
	public List<ProductOutput> getListProduct(@Param("name") String name);
	
	@Query("select new com.demo.Dtos.Output.ProductOutput(id, category.name, name ,priceMin,  image, "
			+ "description, status, isAccept) from Product where id = :id")
	public ProductOutput find(@Param("id") int id);
	
}
