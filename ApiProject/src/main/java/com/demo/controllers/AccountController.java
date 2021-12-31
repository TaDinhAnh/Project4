package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.demo.Dtos.Input.AccountInput;
import com.demo.Dtos.Output.AccountOutput;
import com.demo.services.IAccountService;

@RequestMapping("api/account")
@RestController
public class AccountController {

	@Autowired
	private IAccountService accountService;

	@RequestMapping(value = { "" }, method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> create(@RequestBody AccountInput accountInput) {
		if (accountInput == null) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		if (accountService.createAccount(accountInput)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);

		} else {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccountOutput>> findList() {
		List<AccountOutput> accountOutputs = accountService.getListAccount();
		if (accountOutputs == null || accountOutputs.size() <= 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AccountOutput>>(accountService.getListAccount(), HttpStatus.OK);
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.PUT, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountOutput> changeInfor(@PathVariable("id") int id,
			@RequestBody AccountInput accountInput) {
		if (id <= 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (accountInput == null) {
			return new ResponseEntity<AccountOutput>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AccountOutput>(accountService.changeInfor(id, accountInput), HttpStatus.OK);
	}

}
