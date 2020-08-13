package com.spring.henallux.DLivres.dataAccess.dao;

import com.spring.henallux.DLivres.Model.OrderCustomer;
import com.spring.henallux.DLivres.dataAccess.entity.OrderCustomerEntity;
import com.spring.henallux.DLivres.dataAccess.repository.OrderCustomerRepository;
import com.spring.henallux.DLivres.dataAccess.util.ProviderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderCustomerDAO {
    @Autowired
    private OrderCustomerRepository orderCustomerRepository;
    @Autowired
    private ProviderConverter providerConverter;


    public OrderCustomer addOrderCustomer(OrderCustomer orderCustomer)
    {

        OrderCustomerEntity orderCustomerEntity = providerConverter.orderCustomerToOrderCustomerEntity(orderCustomer);
        orderCustomerEntity = orderCustomerRepository.save(orderCustomerEntity);
        orderCustomer = providerConverter.orderCustomerEntityToOrderCustomer(orderCustomerEntity);
        return orderCustomer;
    }
}
