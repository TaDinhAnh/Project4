package com.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import com.demo.common.JwtTokenUtils;
import com.demo.common.UploadImg;
import com.demo.services.IAccountService;
import com.demo.validators.Validate;

@RequestMapping("api/authentication")
@RestController
public class AuthenticationController {

	@Autowired
	private IAccountService accountService;

	@Autowired
	private Validate validate;

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public ResponseEntity<AccountOutput> Login(@RequestBody @Valid com.demo.Dtos.Input.Login login, BindingResult bind) {
		validate.validate(login, bind);
		if (bind.hasErrors()) {
			return new ResponseEntity<AccountOutput>(HttpStatus.BAD_REQUEST);
		}
		AccountOutput accountOutput = accountService.login(login);		
		if (accountOutput == null)
			return new ResponseEntity<AccountOutput>(HttpStatus.NOT_FOUND);
		HttpHeaders responseHeaders = new HttpHeaders();
		String jwtToken = JwtTokenUtils.generateToken(accountOutput);
		responseHeaders.add("Authorization", jwtToken);
		return ResponseEntity.ok().headers(responseHeaders).body(accountOutput);
	}

	@RequestMapping(value = {
			"register" }, method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> Register(@RequestBody @Valid AccountInput accountInput, BindingResult bind) {
		validate.validate(accountInput, bind);
		if (bind.hasErrors() || accountInput.getPassword() == null) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		if (!accountService.createAccount(accountInput)) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	@RequestMapping(value = { "getImage/{url}/{filename}" }, produces = { MimeTypeUtils.IMAGE_PNG_VALUE,
			MimeTypeUtils.IMAGE_JPEG_VALUE, MimeTypeUtils.IMAGE_GIF_VALUE })
	public ResponseEntity<byte[]> getImg(@PathVariable("filename") String filename, @PathVariable("url") String url) {
		if (filename == null) {
			return new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		byte[] rs = UploadImg.DisplayImg(filename, url);
		if (rs == null) {
			return new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<byte[]>(rs, HttpStatus.OK);
	}
}
