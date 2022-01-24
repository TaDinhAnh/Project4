package com.demo.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.Dtos.Input.AccountInput;
import com.demo.Dtos.Input.Login;
import com.demo.Dtos.Output.AccountOutput;
import com.demo.models.Account;
import com.demo.reponsitories.AccountReponsitory;

@Service
public class AccountService implements IAccountService {
	@Autowired
	private AccountReponsitory accountResponsitory;

	@Override
	public boolean createAccount(AccountInput accountInput) {
		Account accDB = findByGmail(accountInput.getGmail());
		if (accDB != null)
			return false;
		Account account = new Account();
		account.setDob(accountInput.getDob());
		account.setFullname(accountInput.getFullname());
		account.setGmail(accountInput.getGmail());
		account.setPhone(accountInput.getPhone());
		account.setPassword(BCrypt.hashpw(accountInput.getPassword(), BCrypt.gensalt(12)));
		account.setRole(accountInput.getRole());
		return accountResponsitory.save(account) != null;
	}

	@Override
	public AccountOutput login(Login loginInfo) {
		Account account = findByGmail(loginInfo.getEmail());
		if (account == null || !BCrypt.checkpw(loginInfo.getPassword(), account.getPassword()))
			return null;
		AccountOutput accountOutput = new AccountOutput();
		accountOutput.setFullname(account.getFullname());
		accountOutput.setGmail(account.getGmail());
		accountOutput.setId(account.getId());
		accountOutput.setImage(account.getImage());
		accountOutput.setRole(account.getRole());
		return accountOutput;
	}

	@Override
	public AccountOutput changeInfor(int id, AccountInput accountInput) {
		Account account = findById(id);
		if (account == null) {
			return null;
		}
		account.setDob(accountInput.getDob());
		account.setFullname(accountInput.getFullname());
		account.setGmail(accountInput.getGmail());
		account.setPhone(accountInput.getPhone());
		account = accountResponsitory.save(account);
		return new AccountOutput(account.getId(), account.getGmail(), account.getFullname(), account.getPhone(),
				account.getDob(), account.getImage(), account.getRole());
	}
	
	@Override
	public AccountOutput changePassword(int id, AccountInput accountInput) {
		Account account = findById(id);
		if(account == null) {
			return null;
		}	
		account.setPassword(accountInput.getPassword());
		account = accountResponsitory.save(account);
		return new AccountOutput(account.getId(),account.getGmail(), account.getFullname(), account.getPhone(), account.getDob(),
				account.getImage(), account.getRole());
	}
	
	@Override
	public List<AccountOutput> getListAccount() {
		return accountResponsitory.getListAccount();
	}

	@Override
	public Account findById(int id) {
		try {
			return accountResponsitory.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Account findByGmail(String gmail) {
		return accountResponsitory.find(gmail);
	}

	@Override
	public boolean checkGmail(String gmail) {
		return accountResponsitory.find(gmail) != null;
	}

	public boolean changeAvatar(String nameImg, int id) {
		Account account = findById(id);
		if (account == null)
			return true;
		account.setImage(nameImg);
		return accountResponsitory.save(account) == null;
	}

	@Override
	public AccountOutput getAccount(int accountId) {
		return accountResponsitory.getAccount(accountId);
	}

	
}
