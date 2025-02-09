package com.shop.shopModel;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

@Entity
public class Bill {
 @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)  
  private int bill_id;
   private String customer_name;
        @NaturalId
        private long phone;
        private String email;
        @Embedded
        private Address address;
        @NaturalId
        private long invoice_number;
        private Date billiDate;
        private String typesofPayment;

        private String productModel;
        private String brand;
        
        private String serialnumber;
        private double  Weight;
        private String color;
        private String display;
        private String storage;
        private String operatin_system;
        private String ram;
       private int warranty;
       private double amount;


       

    public Bill( String customer_name, long phone, String email, Address address, long invoice_number,
            Date billiDate, String typesofPayment, String productModel, String brand, String serialnumber, double  weight,
            String color, String display, String storage, String operatin_system, String ram, int warranty,
            double amount) {
        this.bill_id = bill_id;
        this.customer_name = customer_name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.invoice_number = invoice_number;
        this.billiDate = billiDate;
        this.typesofPayment = typesofPayment;
        this.productModel = productModel;
        this.brand = brand;
        this.serialnumber = serialnumber;
        this.Weight = weight;
        this.color = color;
        this.display = display;
        this.storage = storage;
        this.operatin_system = operatin_system;
        this.ram = ram;
        this.warranty = warranty;
        this.amount = amount;
    }
    public Bill(){}

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
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

    public long getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(long  invoice_number) {
        this.invoice_number = invoice_number;
    }

    public Date getBilliDate() {
        return billiDate;
    }

    public void setBilliDate(Date billiDate) {
        this.billiDate = billiDate;
    }

    public String getTypesofPayment() {
        return typesofPayment;
    }

    public void setTypesofPayment(String typesofPayment) {
        this.typesofPayment = typesofPayment;
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
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


   


}
