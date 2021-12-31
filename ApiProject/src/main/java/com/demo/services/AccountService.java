package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Account;
import com.demo.reponsitories.AccountReponsitory;

@Service
public class AccountService implements IAccountService {
	
	@Autowired
	private AccountReponsitory accountReponsitory;
	@Override
	public Account findById(int id) {
		return accountReponsitory.findById(id).get();
	}
	
}
