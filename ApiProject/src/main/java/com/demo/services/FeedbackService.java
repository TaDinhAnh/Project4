package com.demo.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.Dtos.Input.FeedBackInput;
import com.demo.Dtos.Input.SendMailInput;
import com.demo.Dtos.Output.FeedBackOutput;
import com.demo.common.MailHelper;
import com.demo.models.Account;
import com.demo.models.Feedback;
import com.demo.reponsitories.FeedbackReponsitory;

@Service
public class FeedbackService implements IFeedbackService {
	@Autowired
	private FeedbackReponsitory feedbackReponsitory;

	@Autowired
	private IAccountService accountService;

	public boolean createFeedBack(FeedBackInput feedbackInput) {
		Account account = accountService.findById(feedbackInput.getAccountId());
		//Product product = productService.findById(feedbackInput.getProductId());
		if (account == null)
			return false;
		Feedback feedback = new Feedback();
		feedback.setAccount(account);
		feedback.setContent(feedbackInput.getContent());
		return feedbackReponsitory.save(feedback) != null;
	}

	@Override
	public List<FeedBackOutput> getlistFeedback() {
		return feedbackReponsitory.getListFeedBack();
	}

	@Override
	public List<FeedBackOutput> getAll() {
		return feedbackReponsitory.getAll();
	}

	@Override
	public List<FeedBackOutput> getlistLimit() {
		List<FeedBackOutput> feedBackInputs = feedbackReponsitory.getListLimit();
		List<FeedBackOutput> rs = new ArrayList<FeedBackOutput>(feedBackInputs.subList(0, 4));
		return rs;
	}

	@Override
	public Boolean replyFeedback(int id, SendMailInput sendMailInput) {
		Feedback feedback = find(id);
		if(!MailHelper.sendMail(sendMailInput.getToEmail(), sendMailInput.getContent(), sendMailInput.getSubject()))
			return true;
		feedback.setIsDel(true);
		return feedbackReponsitory.save(feedback) == null;
	}

	public Feedback find(int id) {
		try {
			return feedbackReponsitory.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}
}
