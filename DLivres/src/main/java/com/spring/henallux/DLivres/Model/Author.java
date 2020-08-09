package com.spring.henallux.DLivres.Model;

public class Author {

    private Integer authorID;
    private String name;
    private String firstName;


    public Integer getAuthorID() {
        return authorID;
    }
    public Author(){}
    public void setAuthorID(Integer authorID) {
        this.authorID = authorID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
