package com.demo.reponsitories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.Dtos.Output.AuctionProductOutput;
import com.demo.models.Auctionproduct;
import com.demo.models.AuctionproductId;

@Repository
public interface AuctionProductReponsitory extends CrudRepository<Auctionproduct, AuctionproductId> {

	@Query("select new com.demo.Dtos.Output.AuctionProductOutput(auction.id, product.id , auction.account.fullname, auction.hourStart, "
			+ "auction.hourEnd, auction.eventdate, auction.description, auction.status, product.name, product.category.name, "
			+ "  product.priceMin,  product.image,  product.description, product.status, status ) from Auctionproduct "
			+ "where auction.account.id= :accountid and product.id= :productid")
	public AuctionProductOutput findListSold(@Param("accountid") int accountId, @Param("productid") int productid);
	
}
