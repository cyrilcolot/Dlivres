package com.spring.henallux.DLivres.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="category_id")
    private Integer categoryId;


    public Integer getCategory_id()
    {
        return categoryId;
    }
    public void setCategoryId(Integer category_id)
    {
        this.categoryId = category_id;
    }

}
