package com.spring.henallux.DLivres.Service;

import com.spring.henallux.DLivres.Model.Customer;
import com.spring.henallux.DLivres.dataAccess.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    private CustomerRepository customerRepository;

    @Autowired
    public UserDetailsServiceImplementation(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
    {
        UserDetails user = customerRepository.findByUserName(userName);
        if(user!= null)
            return user;
        else
            throw new UsernameNotFoundException("User not found");
    }
}
