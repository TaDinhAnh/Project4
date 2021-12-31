package com.demo.reponsitories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.Account;

@Repository
public interface AccountReponsitory extends CrudRepository<Account, Integer> {

}
