package com.demo.services;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dtos.Input.AccountInput;
import com.demo.Dtos.Output.AccountOutput;
import com.demo.models.Account;
import com.demo.reponsitories.AccountReponsitory;

@Service
public class AccountService implements IAccountService {
	@Autowired
	private AccountReponsitory accountReponsitory;

	@Override
	public AccountOutput findById(int id) {
		
		Account account = accountReponsitory.findById(id).get();
		if(account == null) {
			return null;
		}
		AccountOutput accountOutput = new AccountOutput();
		accountOutput.setCreatedAt(account.getCreatedAt());
		accountOutput.setId(account.getId());
		accountOutput.setRole(account.getRole());
		accountOutput.setStatus(account.getStatus());
		accountOutput.setUsername(account.getUsername());
		accountOutput.setUpdatedAt(account.getCreatedAt());
		return accountOutput;
	}

	@Override
	public List<AccountOutput> FindAll() {
		Iterable<Account> accIterable = accountReponsitory.findAll();
		if(accIterable == null) {
			return null;
		}
		List<AccountOutput> accOutputs = new ArrayList<>();
		for (Account account : accIterable) {
			AccountOutput acc = new AccountOutput();
			acc.setCreatedAt(account.getCreatedAt());
			acc.setId(account.getId());
			acc.setRole(account.getRole());
			acc.setStatus(account.getStatus());
			acc.setUsername(account.getUsername());
			acc.setUpdatedAt(account.getCreatedAt());
			accOutputs.add(acc);
		}
		return accOutputs;
	}

	@Override
	public Account Add(AccountInput account) {
		Account acc = new Account(); 
		acc.setUsername(account.getUsername());
		acc.setPassword(account.getPassword());
		acc.setCreatedAt(new Date());
		return accountReponsitory.save(acc);
	}
}
