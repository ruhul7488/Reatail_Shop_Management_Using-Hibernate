package com.shop.shopModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

@Entity
public class Product {
     
    //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  @Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
     private int productid;
     private String productModel;
     private String brand;
     @NaturalId
     private String serialnumber;
     private double  Weight;
     private String color;
     private String display;
     private String storage;
     private String operatin_system;
     private String Ram;
    private int warranty;
    private double actual_price;
    private double saling_price;



     


    public Product(int productid, String productModel, String brand, String serialnumber, double  weight, String color,
            String display, String storage, String operatin_system, String Ram, int warranty, double actual_price,
            double saling_price) {
        this.productid = productid;
        this.productModel = productModel;
        this.brand = brand;
        this.serialnumber = serialnumber;
        this.Weight = weight;
        this.color = color;
        this.display = display;
        this.storage = storage;
        this.operatin_system = operatin_system;
        this.Ram = Ram;
        this.warranty = warranty;
        this.actual_price = actual_price;
        this.saling_price = saling_price;
    }

    public Product(){}

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public double  getWeight() {
        return Weight;
    }

    public void setWeight(double  Weight) {
        this.Weight = Weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getOperatin_system() {
        return operatin_system;
    }

    public void setOperatin_system(String operatin_system) {
        this.operatin_system = operatin_system;
    }

    public String getRam() {
        return Ram;
    }

    public void setRam(String Ram) {
        this.Ram = Ram;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public double getActual_price() {
        return actual_price;
    }

    public void setActual_price(double actual_price) {
        this.actual_price = actual_price;
    }

    public double getSaling_price() {
        return saling_price;
    }

    public void setSaling_price(double saling_price) {
        this.saling_price = saling_price;
    }



}
