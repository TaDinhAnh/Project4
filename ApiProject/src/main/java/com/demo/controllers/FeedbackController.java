package com.demo.controllers;

import java.util.List;

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
import com.demo.Dtos.Output.FeedBackOutput;
import com.demo.services.IFeedbackService;
import com.demo.validators.Validate;

@RequestMapping("api/feedback")
@RestController
public class FeedbackController {

	@Autowired
	private IFeedbackService feedbackService;
	@Autowired
	private Validate validate;

	@RequestMapping(value = { "" }, method = RequestMethod.POST, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> create(@RequestBody @Valid FeedBackInput feedBackInput, BindingResult bind) {
		validate.validate(feedBackInput, bind);
		if (bind.hasErrors()) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		if (!feedbackService.createFeedBack(feedBackInput)) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
			
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FeedBackOutput>> findList() {
		List<FeedBackOutput> feedBackOutputs = feedbackService.getlistFeedback();
		if (feedBackOutputs == null || feedBackOutputs.size() <= 0) {
			return new ResponseEntity<List<FeedBackOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<FeedBackOutput>>(feedbackService.getlistFeedback(), HttpStatus.OK);

	}

	@RequestMapping(value = "admin", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FeedBackOutput>> getAll() {
		List<FeedBackOutput> feedBackOutputs = feedbackService.getAll();
		if (feedBackOutputs == null || feedBackOutputs.size() <= 0) {
			return new ResponseEntity<List<FeedBackOutput>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<FeedBackOutput>>(feedbackService.getAll(), HttpStatus.OK);

	}

}
