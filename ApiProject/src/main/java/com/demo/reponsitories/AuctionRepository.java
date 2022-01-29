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

	@Query("select new com.demo.Dtos.Output.AuctionOutput(id, account.fullname, hourStart, hourEnd, eventdate, description, status) from Auction where isDel = 0 order by id desc ")
	public List<AuctionOutput> getlistAuction();

	@Query("select new com.demo.Dtos.Output.AuctionOutput(id, hourStart, hourEnd, eventdate, description, status) from Auction where id=:id")
	public AuctionOutput getDetailAuction(@Param("id") int id);

	@Query("select new com.demo.Dtos.Output.AuctionOutput(id, hourStart, hourEnd, eventdate, description, status) from Auction order by id desc ")
	public List<AuctionOutput> getAll();

	@Query(value = "select new com.demo.Dtos.Output.AuctionOutput(id, hourStart, hourEnd, eventdate, description, status, isDel)"
			+ "from Auction where account.id = :id")
	public List<AuctionOutput> getAuctionByIdVendor(@Param("id") int id);

	@Query("select new com.demo.Dtos.Output.AuctionOutput(id, account.fullname, hourStart, hourEnd, eventdate, description, status) from Auction where status = 0 and isDel = 0 order by id desc")
	public List<AuctionOutput> getlistAuctionOver();

	@Query("select new com.demo.Dtos.Output.AuctionOutput(id, account.fullname, hourStart, hourEnd, eventdate, description, status) from Auction where status = 1 and isDel = 0 order by id desc")
	public List<AuctionOutput> getlistAuctionHappening();

	@Query("select new com.demo.Dtos.Output.AuctionOutput(id, account.fullname, hourStart, hourEnd, eventdate, description, status) from Auction where status = 2 and isDel = 0 order by id desc")
	public List<AuctionOutput> getlistAuctionComingsoon();
		
	@Query(value="select * from auction where status = 1 and isDel = 0  order by id desc LIMIT 3", nativeQuery = true)
	public List<Auction> getLimitAuctionHappening();

	@Query("select new com.demo.Dtos.Output.AuctionOutput(id, account.fullname, hourStart, hourEnd, eventdate, description, status) from Auction where isDel = 0 and status = 2 and account.id = :id order by id desc ")
	public List<AuctionOutput> getAuction(@Param("id") int accountid);


}
