package com.demo.reponsitories;

import java.util.List;
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

	@Query(value = "select * from Orders " + "where  status != 0 order by id desc limit 0, :limit", nativeQuery = true)
	public List<Orders> getListLimit(@Param("limit") int limit);

	@Query(value = "select new com.demo.Dtos.Output.OrdersOutput(id, successDate, total,piad,"
			+ "status, account.fullname) from Orders ")
	public List<OrdersOutput> getAll();
}
