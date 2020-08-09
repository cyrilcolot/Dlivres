package com.spring.henallux.DLivres.Model;

import java.util.Date;

public class Promotion {
    private Integer promotion_id;
    private Date startDate;
    private Date endDate;
    private Float percentage;
    private String summary;
    private Book book_id;


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public Book getBook_id() {
        return book_id;
    }

    public void setBook_id(Book book_id) {
        this.book_id = book_id;
    }


    public Promotion(){}

    public Integer getPromotion_id() {
        return promotion_id;
    }
    public void setPromotion_id(Integer promotion_id) {
        this.promotion_id = promotion_id;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
}
