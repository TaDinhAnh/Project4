package com.demo.reponsitories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.Feedback;

@Repository
public interface FeedbackReponsitory extends CrudRepository<Feedback, Integer>{

}
