package com.demo.reponsitories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.Dtos.Output.FeedBackOutput;
import com.demo.models.Feedback;

@Repository
public interface FeedbackReponsitory extends CrudRepository<Feedback, Integer>{
	@Query("select new com.demo.Dtos.Output.FeedBackOutput(id, account.fullname, product.name,  "
			+ "content) from Feedback where isDel = 0 order by id desc ")
	public List<FeedBackOutput> getListFeedBack(); 
	
	@Query("select new com.demo.Dtos.Output.FeedBackOutput(id, account.fullname, product.name,  "
			+ "content) from Feedback order by id desc")
	public List<FeedBackOutput> getAll(); 
	@Query("select new com.demo.Dtos.Output.FeedBackOutput(id, account.fullname, account.image, account.gmail, product.name,  "
			+ "content) from Feedback where isDel = 0 order by id desc ")
	public List<FeedBackOutput> getListLimit(); 
	
}
