package com.spring.henallux.DLivres.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="book")

public class BookEntity {

    @Id
    @Column(name="isbn")
    private Integer isbn;

    @Column(name="price")
    private Float price;

    @Column(name="summary")
    private String summary;

    @Column(name="numberofpages")
    private Integer numberOfPages;

    @Column(name="publicationdate")
    private Date publicationDate;

    @Column(name="height")
    private Integer height;

    @Column(name="width")
    private Integer width;

    @Column(name="thickness")
    private Integer thickness;

    @Column(name="weight")
    private Integer weight;

    @Column(name="stock")
    private Integer stock;

    @Column(name="typeofbook")
    private String typeOfBook;

    @Column(name="filesize")
    private Integer fileSize;

    @Column(name="extension")
    private String extension;

    @JoinColumn(name="author_pb_id", referencedColumnName="author_id")
    @ManyToOne
    private AuthorEntity author;

    @JoinColumn(name="publishinghouse_pb__id", referencedColumnName="publishinghouse_id")
    @ManyToOne
    private PublishingHouseEntity publishingHouse;

    @JoinColumn(name="category_pb_id", referencedColumnName="category_id")
    @ManyToOne
    private CategoryEntity category;

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }



    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getThickness() {
        return thickness;
    }

    public void setThickness(Integer thickness) {
        this.thickness = thickness;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }



    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getTypeOfBook() {
        return typeOfBook;
    }

    public void setTypeOfBook(String typeOfBook) {
        this.typeOfBook = typeOfBook;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    public PublishingHouseEntity getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouseEntity publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }



}