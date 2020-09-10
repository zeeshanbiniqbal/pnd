package com.digicl.pnd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digicl.pnd.model.AdminUser;
import com.digicl.pnd.model.ServiceProvider;

@Repository
public interface ServiceProviderRepository extends CrudRepository<ServiceProvider, Long>{

	ServiceProvider findBySpEmail(String spEmail);
	
}
