package com.spring.henallux.DLivres.dataAccess.dao;

import com.spring.henallux.DLivres.Model.Customer;
import com.spring.henallux.DLivres.dataAccess.entity.CustomerEntity;
import com.spring.henallux.DLivres.dataAccess.repository.CustomerRepository;
import com.spring.henallux.DLivres.dataAccess.util.ProviderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerDAO {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProviderConverter providerConverter;


    public Customer getCustomerByUserName(String userName)
    {
        CustomerEntity customerEntity = customerRepository.findByUserName(userName);


        Customer memberModel = providerConverter.customerEntityToCustomer(customerEntity);
        return memberModel;
    }


    public boolean save(CustomerEntity customerEntity)
    {
        if(customerRepository.save(customerEntity)!=null)
            return true;
        else
            return false;
    }
}