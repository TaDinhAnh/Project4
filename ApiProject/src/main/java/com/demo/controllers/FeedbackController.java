package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Dtos.Input.FeedBackInput;
import com.demo.Dtos.Output.FeedBackOutput;
import com.demo.services.IFeedbackService;

@RequestMapping("api/feedback")
@RestController
public class FeedbackController {

	@Autowired
	private IFeedbackService feedbackService;

	@RequestMapping(value = { "" }, method = RequestMethod.POST, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> create(@RequestBody FeedBackInput feedBackInput) {
		if (feedBackInput == null) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		if (feedbackService.createFeedBack(feedBackInput)) {
			return new ResponseEntity<Boolean>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
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
		return new ResponseEntity<List<FeedBackOutput>>(feedbackService.getlistFeedback(), HttpStatus.OK);

	}
	

}
