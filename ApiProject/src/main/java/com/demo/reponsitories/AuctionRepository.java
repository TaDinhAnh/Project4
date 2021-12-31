package com.demo.reponsitories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.Dtos.Output.AuctionOutput;
import com.demo.models.Auction;

@Repository
public interface AuctionRepository extends CrudRepository<Auction, Integer> {
	
	@Query(value = "select new com.demo.Dtos.Output.AuctionOutput(id, hourStart, hourEnd, eventdate, description, status, isDel)"
			+ "from Auction where account.id = :id")
	public List<AuctionOutput> getAuctionByIdVendor(@Param("id") int id);
}
