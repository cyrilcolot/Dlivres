package com.spring.henallux.DLivres.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="customer_id")
    private Integer customer_id;

    @Column(name="email")
    private String email;

    @Column(name="name")
    private String name;

    @Column(name="firstname")
    private String firstName;

    @Column(name="phonenumber")
    private String phoneNumber;

    @Column(name="birthdate")
    private Date birthDate;

    @Column(name="street")
    private String street;

    @Column(name="streetnumber")
    private Integer streetNumber;

    @Column(name="postalcode")
    private Integer postalCode;

    @Column(name="city")
    private String city;

    @Column(name="country")
    private String country;

    @Column(name="password")
    private String password;

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setPhoneNumber()
    {
        this.phoneNumber = null;
    }



    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
