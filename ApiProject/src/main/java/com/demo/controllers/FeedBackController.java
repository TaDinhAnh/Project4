package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.demo.Dtos.Input.FeedbackInput;
import com.demo.services.IFeedbackService;

@RestController
@RequestMapping("api/feedback")
public class FeedBackController {
	@Autowired
	private IFeedbackService feedbackService;

	@RequestMapping( method = RequestMethod.POST, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> createFeedback(@RequestBody FeedbackInput feedbackInput) {
		if(feedbackInput == null) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		if(feedbackService.createFeedBack(feedbackInput)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}else {		
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
	}
}
