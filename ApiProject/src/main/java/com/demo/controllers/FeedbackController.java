package com.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Dtos.Input.FeedBackInput;
import com.demo.services.IFeedbackService;
import com.demo.validators.Validate;

@RestController
@RequestMapping("api/feedback")
public class FeedbackController {
	@Autowired
	private IFeedbackService feedbackService;
	@Autowired
	private Validate validate;
	@RequestMapping( method = RequestMethod.POST, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> createFeedback(@RequestBody @Valid FeedBackInput feedbackInput, BindingResult bind) {
		validate.validate(feedbackInput, bind);
		if(bind.hasErrors()) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		if(feedbackService.createFeedBack(feedbackInput)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}else {		
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
	}
}
