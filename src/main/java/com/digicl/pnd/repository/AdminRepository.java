package com.digicl.pnd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digicl.pnd.model.AdminUser;

@Repository
public interface AdminRepository extends CrudRepository<AdminUser, Long>{

	AdminUser findByEmail(String email);
	
}
