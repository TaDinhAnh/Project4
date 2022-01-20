package com.demo.reponsitories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.demo.Dtos.Output.OrdersOutput;
import com.demo.models.Orders;

@Repository
public interface OrdersResponsitory extends CrudRepository<Orders, Integer> {
	@Query(value = "select new com.demo.Dtos.Output.OrdersOutput(id, successDate, total,piad, address,  "
			+ "status, account.id, account.gmail, account.fullname, account.image, account.phone) from Orders "
			+ "where  proId = :id and status != 0")
	public OrdersOutput find(@Param("id") int id);

}
