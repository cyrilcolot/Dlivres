package com.spring.henallux.DLivres.dataAccess.repository;

import com.spring.henallux.DLivres.dataAccess.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {

    CustomerEntity findByUserName(String UserName);
    CustomerEntity findByEmail(String email);
    CustomerEntity save(CustomerEntity customerEntity);
}