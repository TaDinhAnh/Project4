package com.demo.services;

import java.util.List;

import com.demo.Dtos.Input.FeedBackInput;
import com.demo.Dtos.Output.FeedBackOutput;

public interface IFeedbackService {
	boolean createFeedback(FeedBackInput feedback);

	List<FeedBackOutput> getlistFeedback();

	List<FeedBackOutput> getAll();
	
}
