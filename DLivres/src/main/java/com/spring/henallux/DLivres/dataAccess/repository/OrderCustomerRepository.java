package com.spring.henallux.DLivres.dataAccess.repository;

import com.spring.henallux.DLivres.Model.OrderCustomer;
import com.spring.henallux.DLivres.dataAccess.entity.OrderCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OrderCustomerRepository extends JpaRepository<OrderCustomerEntity,Integer> {
    OrderCustomerEntity save(OrderCustomerEntity entity);
}
