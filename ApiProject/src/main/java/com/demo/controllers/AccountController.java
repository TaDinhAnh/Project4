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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.demo.Dtos.Input.AccountInput;
import com.demo.Dtos.Output.AccountOutput;
import com.demo.common.UploadImg;
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
			@RequestBody @Valid AccountInput accountInput, BindingResult bind) {
		validate.validate(accountInput, bind);
		if (bind.hasErrors() || id <= 0) {
			return new ResponseEntity<AccountOutput>(HttpStatus.BAD_REQUEST);
		}
		AccountOutput accountOutput = accountService.changeInfor(id, accountInput);
		if (accountOutput == null) {
			return new ResponseEntity<AccountOutput>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AccountOutput>(accountService.changeInfor(id, accountInput), HttpStatus.OK);
	}

	@RequestMapping(value = { "changeAvatar/{id}/{imgOld}" }, method = RequestMethod.POST, 
			produces = {MimeTypeUtils.IMAGE_PNG_VALUE, MimeTypeUtils.IMAGE_JPEG_VALUE, MimeTypeUtils.IMAGE_GIF_VALUE})
	public ResponseEntity<byte[]> changeAvatar(@RequestParam("file") MultipartFile file,
			@PathVariable("id") int id,  @PathVariable("imgOld")String imgOld) {
		if (file == null || id <= 0) {
			return new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		String filename = UploadImg.Upload(file, "avatar");
		if (filename == null) {
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (accountService.changeAvatar(filename, id)) {
			UploadImg.DelFile(filename);
			return new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		UploadImg.DelFile(imgOld);
		return new ResponseEntity<byte[]>(UploadImg.DisplayImg(filename), HttpStatus.OK);
	}
	
	@RequestMapping(value = { "getAvatar/{filename}" }, produces = {MimeTypeUtils.IMAGE_PNG_VALUE, MimeTypeUtils.IMAGE_JPEG_VALUE, MimeTypeUtils.IMAGE_GIF_VALUE})
	public ResponseEntity<byte[]> getImg(@PathVariable("filename") String filename){
		if (filename == null) {
			return new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		byte[] rs = UploadImg.DisplayImg(filename);
		if(rs == null) {
			return new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<byte[]>(rs, HttpStatus.OK);
	}

}
