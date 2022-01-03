package com.demo.services;
import org.springframework.stereotype.Service;
import java.util.List;
import com.demo.Dtos.Input.FeedBackInput;
import com.demo.Dtos.Output.FeedBackOutput;

@Service
public interface IFeedbackService {
	boolean createFeedBack(FeedBackInput feedbackInput);

	List<FeedBackOutput> getlistFeedback();

	List<FeedBackOutput> getAll();
	
}

