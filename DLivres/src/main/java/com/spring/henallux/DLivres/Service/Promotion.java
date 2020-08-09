package com.spring.henallux.DLivres.Service;

import org.springframework.stereotype.Service;

@Service
public class Promotion {


    public double costReducItemQuantity(double totalCost, int sizeBasket){
        if(sizeBasket>=4){
            return (totalCost *= 0.85);
        }
        else
            return totalCost;
    }
}
