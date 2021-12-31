package com.demo.services;

import org.springframework.stereotype.Service;

import com.demo.models.Account;

@Service
public interface IAccountService {
	Account findById(int id);
}
