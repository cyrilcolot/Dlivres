package com.spring.henallux.DLivres.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="category_id")
    private Integer category_id;


    public Integer getCategory_id()
    {
        return category_id;
    }
    public void setCategory_id(Integer category_id)
    {
        this.category_id = category_id;
    }

}
