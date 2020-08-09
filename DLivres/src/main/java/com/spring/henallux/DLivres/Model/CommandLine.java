package com.spring.henallux.DLivres.Model;

public class CommandLine {

    private Integer commandLine_id;
    private Book book;
    private OrderCustomer orderCustomer;
    private Integer quantity;

    public CommandLine() {

    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public OrderCustomer getOrderCustomer() {
        return orderCustomer;
    }
    public void setOrderCustomer(OrderCustomer orderCustomer) {
        this.orderCustomer = orderCustomer;
    }

    public Integer getCommandLine_id() {
        return commandLine_id;
    }
    public void setCommandLine_id(Integer commandLine_id) {
        this.commandLine_id = commandLine_id;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
