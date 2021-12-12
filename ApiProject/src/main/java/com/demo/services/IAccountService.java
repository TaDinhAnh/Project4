package com.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.Dtos.Input.AccountInput;
import com.demo.Dtos.Output.AccountOutput;
import com.demo.models.Account;

@Service
public interface IAccountService {
	AccountOutput findById(int id);
	List<AccountOutput> FindAll();
	Account Add(AccountInput account);
}
