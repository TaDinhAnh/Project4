package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.Dtos.Input.FeedbackInput;
import com.demo.models.Account;
import com.demo.models.Feedback;
import com.demo.models.Product;
import com.demo.reponsitories.FeedbackReponsitory;

@Service
public class FeedbackService implements IFeedbackService {
	@Autowired
	private  FeedbackReponsitory feedbackReponsitory;
	
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private IProductService productService;

	@Override
	public boolean createFeedBack(FeedbackInput feedbackInput) {
		Account account = accountService.findById(feedbackInput.getAccountId());
		Product product = productService.findById(feedbackInput.getProductId());
		if(product == null || account == null)
			return false;
		Feedback feedback = new Feedback();
		feedback.setAccount(account);
		feedback.setProduct(product);
		feedback.setContent(feedbackInput.getContent());
		return feedbackReponsitory.save(feedback) != null;
	} 
}
