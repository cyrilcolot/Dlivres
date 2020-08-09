package com.spring.henallux.DLivres.dataAccess.entity;

import javax.persistence.*;


@Entity
@Table(name="author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="author_id")
    private Integer authorID;

    @Column(name="name")
    private String name;

    @Column(name="firstname")
    private String firstName;

    public Integer getAuthorId()
    {
        return authorID;
    }
    public void setAuthorID(Integer authorID)
    {
        this.authorID = authorID;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
}
