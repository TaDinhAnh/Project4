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
import com.demo.Dtos.Input.AccountInput;
import com.demo.Dtos.Output.AccountOutput;
import com.demo.models.Account;
import com.demo.services.IAccountService;
import com.demo.validators.Validate;

@RequestMapping("api/account")
@RestController
public class AccountController {

	@Autowired
	private IAccountService accountService;

	@Autowired
	private Validate validate;

	@RequestMapping(value = { "" }, method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> create(@RequestBody @Valid AccountInput accountInput, BindingResult bind) {
		validate.validate(accountInput, bind);
		if (bind.hasErrors() || accountInput.getPassword() == null) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		if (!accountService.createAccount(accountInput)) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<AccountOutput>> findList() {
		List<AccountOutput> accountOutputs = accountService.getListAccount();
		if (accountOutputs == null || accountOutputs.size() <= 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AccountOutput>>(accountOutputs, HttpStatus.OK);
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.PUT, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountOutput> changeInfor(@PathVariable("id") int id,
			@RequestBody @Valid AccountInput accountInput, BindingResult bind) {
		validate.validate(accountInput, bind);
		if (bind.hasErrors() || id <= 0) {
			return new ResponseEntity<AccountOutput>(HttpStatus.BAD_REQUEST);
		}
		AccountOutput accountOutput = accountService.changeInfor(id, accountInput);
		if (accountOutput == null) {
			return new ResponseEntity<AccountOutput>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AccountOutput>(accountOutput, HttpStatus.OK);
	}

	@RequestMapping(value = {
			"/changePass/{id}" }, method = RequestMethod.PUT, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountOutput> changePassword(@PathVariable("id") int id,
			@RequestBody AccountInput accountInput) {
		if (id <= 0) {
			return new ResponseEntity<AccountOutput>(HttpStatus.BAD_REQUEST);
		}
		AccountOutput accountOutput = accountService.changePassword(id, accountInput);
		if (accountOutput == null) {
			return new ResponseEntity<AccountOutput>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AccountOutput>(accountOutput, HttpStatus.OK);
	}

	@RequestMapping(value = "/checkGmail/{gmail}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> checkGmail(@PathVariable("gmail") String gmail) {
		Boolean result = accountService.checkGmail(gmail);
		if (gmail == null) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		if (!result) {
			return new ResponseEntity<>(false, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<AccountOutput> getAccount(@PathVariable("id") int id) {
		AccountOutput accountOutput = accountService.getAccount(id);
		if (id <= 0) {
			return new ResponseEntity<AccountOutput>(HttpStatus.BAD_REQUEST);
		}
		if (accountOutput == null) {
			return new ResponseEntity<AccountOutput>(HttpStatus.BAD_REQUEST);
		}
		System.out.println(accountOutput.getDob());
		return new ResponseEntity<AccountOutput>(accountOutput, HttpStatus.OK);
	}

}
