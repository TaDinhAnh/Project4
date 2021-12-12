package com.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.models.Account;

import demo.com.Dtos.Input.AccountInput;
import demo.com.Dtos.Output.AccountOutput;

@Service
public interface IAccountService {
	AccountOutput findById(int id);
	List<AccountOutput> FindAll();
	Account Add(AccountInput account);
}
