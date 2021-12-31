package com.demo.reponsitories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.Dtos.Output.AccountOutput;
import com.demo.Dtos.Output.ProductOutput;
import com.demo.common.EProduct;
import com.demo.models.Product;

@Repository
public interface IProductResponsitory extends CrudRepository<Product, Integer> {
	@Query("select new com.demo.Dtos.Output.ProductOutput(id, category.name, name , priceMin, image, description, status, isAccept) from Product where isDelete = 1 and isAccept = 1 order by id desc ")
	public List<ProductOutput> getListProductByClient();

	@Query("select new com.demo.Dtos.Output.ProductOutput(id, category.name, name ,priceMin,  image, description, status, isAccept) from Product where name like %:name% and isDelete = 1 and isAccept = 1 order by id desc")
	public List<ProductOutput> getListProduct(@Param("name") String name);
}
