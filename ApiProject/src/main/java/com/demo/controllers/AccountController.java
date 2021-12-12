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
import com.demo.models.Account;
import com.demo.services.AccountService;

@RestController
@RequestMapping("api/account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = {"/{id}" }, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountOutput> findByUserName(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<AccountOutput>(accountService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<AccountOutput>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> Create(@RequestBody AccountInput account) {
		try {
			return new ResponseEntity<Account>(accountService.Add(account), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping( method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccountOutput>> FindAll() {
		try {
			return new ResponseEntity<List<AccountOutput>>(accountService.FindAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<AccountOutput>>(HttpStatus.BAD_REQUEST);
		}
	}
}
