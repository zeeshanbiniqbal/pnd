package com.digicl.pnd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digicl.pnd.model.AdminRole;

@Repository
public interface AdminRoleRepository extends CrudRepository<AdminRole, Long>{

}
