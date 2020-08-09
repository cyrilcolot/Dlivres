package com.spring.henallux.DLivres.Model;

import java.util.Date;

public class OrderCustomer {
    private Integer orderCustomer_id;
    private Date orderCustomerDate;
    private Customer customer_id;

    public OrderCustomer(){}

    public Integer getOrderCustomer_id() {
        return orderCustomer_id;
    }
    public void setOrderCustomer_id(Integer orderCustomer_id) {
        this.orderCustomer_id = orderCustomer_id;
    }
    public Date getOrderCustomerDate() {
        return orderCustomerDate;
    }
    public void setOrderCustomerDate(Date orderCustomerDate) {
        this.orderCustomerDate = orderCustomerDate;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(Customer customer) {
        this.customer_id = customer;
    }
}
