package com.shop.shopModel;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
public class Address {
    private String street;
    private String city;
    private String state;
    private int pin;

    public Address(String street, String city, String state, int pin) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.pin = pin;
    }
      
    public Address(){}


    
}
