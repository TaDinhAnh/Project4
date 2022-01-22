package com.demo.services;

import java.util.List;

import com.demo.Dtos.Input.AccountInput;
import com.demo.Dtos.Input.Login;
import com.demo.Dtos.Output.AccountOutput;
import com.demo.models.Account;

public interface IAccountService {
	boolean createAccount(AccountInput accountInput);

	String login(Login Login);

	AccountOutput changeInfor(int id, AccountInput accountInput);

	List<AccountOutput> getListAccount();

	Account findByGmail(String gmail);

	Account findById(int id);

	boolean checkGmail(String gmail);

	boolean changeAvatar(String nameImg, int id);

	AccountOutput getAccount(int accountId);

	AccountOutput changePassword(int id, AccountInput accountInput);

}
