package com.spring.henallux.DLivres.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="commandline")
public class CommandLineEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="commandline_id")
    private Integer commandLine_id;

    @Column(name="quantity")
    private Integer quantity;

    @JoinColumn(name="book_id", referencedColumnName="isbn")
    @ManyToOne
    private BookEntity book;

    @JoinColumn(name="ordercustomer_id", referencedColumnName="ordercustomer_id")
    @ManyToOne
    private OrderCustomerEntity orderCustomer;

    public OrderCustomerEntity getOrderCustomer() {
        return orderCustomer;
    }

    public void setOrderCustomer(OrderCustomerEntity orderCustomer) {
        this.orderCustomer = orderCustomer;
    }

    public Integer getCommandLine_id() {
        return commandLine_id;
    }

    public void setCommandLine_id(Integer commandLine_id) {
        this.commandLine_id = commandLine_id;
    }


    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



}
