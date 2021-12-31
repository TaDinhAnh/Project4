package com.demo.services;

import org.springframework.stereotype.Service;

import com.demo.Dtos.Input.FeedbackInput;

@Service
public interface IFeedbackService {
	boolean createFeedBack(FeedbackInput feedbackInput);
}
