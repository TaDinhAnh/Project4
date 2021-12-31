package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dtos.Input.FeedBackInput;
import com.demo.Dtos.Output.FeedBackOutput;
import com.demo.models.Feedback;
import com.demo.reponsitories.IAccountResponsitory;
import com.demo.reponsitories.IFeedbackResponsitory;
import com.demo.reponsitories.IProductResponsitory;

@Service
public class FeedbackService implements IFeedbackService {
	@Autowired
	private IFeedbackResponsitory feedbackResponsitory;
	@Autowired
	private IAccountService accountService;
	@Autowired
	private IProductService productService;

	@Override
	public boolean createFeedback(FeedBackInput feedbackInput) {
		Feedback feedback = new Feedback();
		feedback.setAccount(accountService.findById(feedbackInput.getAccountId()));
		feedback.setContent(feedbackInput.getContent());
		feedback.setProduct(productService.findById(feedbackInput.getProductId()));
		return feedbackResponsitory.save(feedback) != null;
	}

	@Override
	public List<FeedBackOutput> getlistFeedback() {
		return feedbackResponsitory.getListFeedBack();
	}

	@Override
	public List<FeedBackOutput> getAll() {
		return feedbackResponsitory.getAll();
	}


}
