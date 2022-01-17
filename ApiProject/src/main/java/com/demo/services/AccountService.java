package com.demo.services;
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
	private AccountReponsitory accountResponsitory;

	@Override
	public boolean createAccount(AccountInput accountInput) {
		Account accDB = findByGmail(accountInput.getGmail());
		if(accDB != null) return false;
		Account account = new Account();
		account.setDob(accountInput.getDob());
		account.setFullname(accountInput.getFullname());
		account.setGmail(accountInput.getGmail());
		account.setPhone(accountInput.getPhone());
		account.setPassword(accountInput.getPassword());
		account.setRole(accountInput.getRole());
		return accountResponsitory.save(account) != null;
	}

	@Override
	public Account login(Account accoount) {
		return null;
	}

	@Override
	public AccountOutput changeInfor(int id, AccountInput accountInput) {
		Account account = findById(id);
		if(account == null) {
			return null;
		}
		account.setDob(accountInput.getDob());
		account.setFullname(accountInput.getFullname());
		account.setGmail(accountInput.getGmail());
		account.setPhone(accountInput.getPhone());
		account = accountResponsitory.save(account);
		return new AccountOutput(account.getId(),account.getGmail(), account.getFullname(), account.getPhone(), account.getDob(),
				account.getImage(), account.getRole());
	}

	@Override
	public List<AccountOutput> getListAccount() {
			return accountResponsitory.getListAccount();
	}

	@Override
	public Account findByGmail(String gmail) {
			return accountResponsitory.find(gmail);	
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
	public Boolean delAccount(int id) {
		Account account = findById(id);
		if(account == null)
			return false;
		account.setIsDelete(!account.getIsDelete());
		return accountResponsitory.save(account) == null;
	}
	
}
