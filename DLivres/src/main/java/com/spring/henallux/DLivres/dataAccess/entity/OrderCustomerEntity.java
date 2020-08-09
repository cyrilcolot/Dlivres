package com.spring.henallux.DLivres.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ordercustomer")
public class OrderCustomerEntity {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ordercustomer_id")
    private Integer orderCustomer_id;

    @Column(name="ordercustomerdate")
    private Date orderCustomerDate;

    @JoinColumn(name="customer_id", referencedColumnName="customer_id")
    @ManyToOne
    private CustomerEntity customer_id;

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

    public CustomerEntity getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(CustomerEntity customer_id) {
        this.customer_id = customer_id;
    }




}