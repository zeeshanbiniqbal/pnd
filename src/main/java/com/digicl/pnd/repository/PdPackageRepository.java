package com.digicl.pnd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digicl.pnd.model.PdPackage;

@Repository
public interface PdPackageRepository extends CrudRepository<PdPackage, Long>{

}
