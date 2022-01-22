package com.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.demo.Dtos.Input.FeedBackInput;
import com.demo.Dtos.Input.SendMailInput;
import com.demo.Dtos.Output.FeedBackOutput;
import com.demo.services.IFeedbackService;
import com.demo.validators.Validate;

@RestController
@RequestMapping("api/feedback")
public class FeedbackController {
	@Autowired
	private IFeedbackService feedbackService;
	@Autowired
	private Validate validate;

	@RequestMapping(method = RequestMethod.POST, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> createFeedback(@RequestBody @Valid FeedBackInput feedbackInput, BindingResult bind) {
		validate.validate(feedbackInput, bind);
		if (bind.hasErrors()) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		if (feedbackService.createFeedBack(feedbackInput)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.GET, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FeedBackOutput>> getLimit() {
		List<FeedBackOutput> rs = feedbackService.getlistLimit();
		return new ResponseEntity<List<FeedBackOutput>>(rs, HttpStatus.OK);
	}

	@RequestMapping(value = "reply/{id}", method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> replyFeeback(@PathVariable("id") int id,
			@RequestBody @Valid SendMailInput sendMailInput, BindingResult bind) {
		validate.validate(sendMailInput, bind);
		if (bind.hasErrors() || id <= 0) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		if(feedbackService.replyFeedback(id, sendMailInput))
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
