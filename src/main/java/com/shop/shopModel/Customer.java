package com.shop.shopModel;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

@Entity
public class Customer {
         @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int customer_id;
        private String customer_name;
        @NaturalId
        private long phone;
        private String email;
        @Embedded
        public Address address;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer( String customer_name, long phone, String email, Address address) {
        // this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

  public Customer(){}
       

}
