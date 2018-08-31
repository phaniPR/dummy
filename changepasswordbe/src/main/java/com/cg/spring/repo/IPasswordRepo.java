package com.cg.spring.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.spring.beans.Password;

@Repository
public interface IPasswordRepo extends CrudRepository<Password, String>{

	
}
