package com.demo.reponsitories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.Dtos.Output.AuctionHistoryOutput;
import com.demo.models.Auctionhistory;

@Repository
public interface IAuctionHistoryResponsitory extends CrudRepository<Auctionhistory, Integer> {
	@Query("select new com.demo.Dtos.Output.AuctionHistoryOutput(id, account.fullname, product.name, auction.hourStart, auction.hourEnd, auction.eventdate,  price, time) "
			+ "from Auctionhistory order by id desc ")
	public List<AuctionHistoryOutput> getlistAuctionHistory();

	@Query("select new com.demo.Dtos.Output.AuctionHistoryOutput(id, account.fullname, product.name, auction.hourStart, auction.hourEnd, auction.eventdate,  price, time) from Auctionhistory where account.id = :accountid")
	public List<AuctionHistoryOutput> getAuctionHistoryByCustomer(@Param("accountid") int accountid);
	
	@Query(value = "select * from auctionhistory where auctionid =:id order by price desc limit 5 ", nativeQuery = true)
	public List<Auctionhistory> getAuctionHistoryById(@Param("id") int id);

	@Query("select count(*) from Auctionhistory where auction.id = :id")
	public int countAuctionHistoryById(@Param("id") int id);
	
	@Query("select max(price) from Auctionhistory where auction.id = :id ")
	public double maxPriceAuctionHistoryById(@Param("id") int id);
}
