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
import com.demo.Dtos.Input.SendMailInput;
import com.demo.common.MailHelper;
import com.demo.validators.Validate;

@RestController
@RequestMapping("api/sendmail")
public class SendMailController {
	@Autowired
	private Validate validate;

	@RequestMapping(value = { "" }, method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> create(@RequestBody @Valid SendMailInput sendMailInput, BindingResult bind) {
		validate.validate(sendMailInput, bind);
		if (bind.hasErrors()) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		if (!MailHelper.sendMail(sendMailInput.getToEmail(), sendMailInput.getContent(), sendMailInput.getSubject()))
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}
