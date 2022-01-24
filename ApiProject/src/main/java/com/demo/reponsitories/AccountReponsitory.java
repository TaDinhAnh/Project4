package com.demo.reponsitories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.demo.Dtos.Output.AccountOutput;
import com.demo.models.Account;

@Repository
public interface AccountReponsitory extends CrudRepository<Account, Integer> {
	@Query("select new com.demo.Dtos.Output.AccountOutput(id, gmail, fullname, phone,  dob, image, role, isDelete ) from Account")
	public List<AccountOutput> getListAccount();

	@Query("from Account where gmail= :gmail and isDelete = 0")
	public Account find(@Param("gmail") String gmail);

	@Query("select new com.demo.Dtos.Output.AccountOutput(id, gmail, fullname, phone,  dob, image, role, isDelete ) from Account where id = :id")
	public AccountOutput find(@Param("id") int id);
}
