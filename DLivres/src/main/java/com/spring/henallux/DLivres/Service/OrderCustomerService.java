package com.spring.henallux.DLivres.Service;

import com.spring.henallux.DLivres.Model.CommandLine;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class OrderCustomerService {

    public OrderCustomerService ()
    {}
    double totalPrice;
    public double getTotalOrder (HashMap<Integer, CommandLine> cart)
    {
        double totalPrice = 0;
        double price = 0;

        for (HashMap.Entry<Integer, CommandLine> commandLine : cart.entrySet()) {

            price = commandLine.getValue().getBook().getPrice();


        }

        totalPrice = (Math.floor(totalPrice * 100) / 100);

        return totalPrice;
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }
}