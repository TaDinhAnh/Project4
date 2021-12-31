package com.demo.reponsitories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.Dtos.Output.AuctionOutput;
import com.demo.Dtos.Output.ProductOutput;
import com.demo.models.Auction;

@Repository
public interface IAuctionResponsitory extends CrudRepository<Auction, Integer> {
	@Query("select new com.demo.Dtos.Output.AuctionOutput(id, hourStart, hourEnd, eventdate, description, status) from Auction where isDel = 0 order by id desc ")
	public List<AuctionOutput> getlistAuction();

	@Query("select new com.demo.Dtos.Output.AuctionOutput(id, hourStart, hourEnd, eventdate, description, status) from Auction where id=:id")
	public AuctionOutput getDetailAuction(@Param("id") int id);

	@Query("select new com.demo.Dtos.Output.AuctionOutput(id, hourStart, hourEnd, eventdate, description, status) from Auction order by id desc ")
	public List<AuctionOutput> getAll();

}
