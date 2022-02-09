package com.demo.reponsitories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.Dtos.Output.AuctionProductOutput;
import com.demo.Dtos.Output.ProductOutput;
import com.demo.models.Auctionproduct;
import com.demo.models.AuctionproductId;

@Repository
public interface AuctionProductReponsitory extends CrudRepository<Auctionproduct, AuctionproductId> {

	@Query("select new com.demo.Dtos.Output.AuctionProductOutput(auction.id, product.id , auction.account.fullname, auction.hourStart, "
			+ "auction.hourEnd, auction.eventdate, auction.description, auction.status, product.name, product.category.name, "
			+ "  product.priceMin,  product.image,  product.description, product.status, product.isAccept,  status ) from Auctionproduct "
			+ "where auction.account.id= :accountid and product.id= :productid")
	public AuctionProductOutput findListSold(@Param("accountid") int accountId, @Param("productid") int productid);

	@Query("select new com.demo.Dtos.Output.ProductOutput(product.id , auction.account.fullname, product.name, "
			+ "product.category.name, product.priceMin, product.image, product.description) "
			+ "from Auctionproduct where auction.id = :auctionid")
	public List<ProductOutput> getListProByAuction(@Param("auctionid") int auctionid);

	@Query("select new com.demo.Dtos.Output.AuctionProductOutput(auction.id, product.id , auction.hourStart, "
			+ "auction.hourEnd, auction.eventdate, product.name, product.category.name, "
			+ "  product.priceMin,  product.image,  product.description, auction.account.fullname, auction.status ) from Auctionproduct "
			+ "where auction.id= :auctionid and product.id= :productid")
	public AuctionProductOutput getByIdProductAndAuction(@Param("auctionid") int auctionid,
			@Param("productid") int productid);

	@Query("select new com.demo.Dtos.Output.AuctionProductOutput(auction.id, product.id , auction.account.fullname, auction.hourStart, "
			+ "auction.hourEnd, auction.eventdate, auction.description, auction.status, product.name, product.category.name, "
			+ "  product.priceMin,  product.image,  product.description, product.status, product.isAccept,  status ) from Auctionproduct "
			+ "where auction.account.id= :accountid")
	public List<AuctionProductOutput> findById(@Param("accountid") int accountId);

	@Query("select new com.demo.Dtos.Output.ProductOutput(product.id ) "
			+ "from Auctionproduct where product.vendorId = :idvendor and status = null")
	public List<ProductOutput> getProduct(@Param("idvendor") int idvendor);

}
