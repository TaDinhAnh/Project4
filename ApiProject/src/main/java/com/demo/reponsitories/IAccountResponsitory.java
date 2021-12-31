package com.demo.reponsitories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.Dtos.Output.AccountOutput;
import com.demo.models.Account;

@Repository
public interface IAccountResponsitory extends CrudRepository<Account, Integer> {
	@Query("select new com.demo.Dtos.Output.AccountOutput(id, gmail, fullname, phone,  dob, image, role ) from Account where isDelete = 1")
	public List<AccountOutput> getListAccount();

	@Query("from Account where gmail= :gmail")
	public Account find(@Param("gmail") String gmail);

}
