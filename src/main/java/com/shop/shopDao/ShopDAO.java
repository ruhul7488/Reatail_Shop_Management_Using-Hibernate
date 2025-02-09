package com.shop.shopDao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.shop.shopModel.Address;
import com.shop.shopModel.Bill;
import com.shop.shopModel.Customer;
import com.shop.shopModel.Product;
import com.shop.shopModel.Stocks;

public interface ShopDAO {

        List<Product>getproductDetailByname(String productModel) throws SQLException;

       List<Product> getAllProduct()throws SQLException;

        void newStock(String productModel, String brand, String serialnumber, double  weight, String color, String display, String storage, String operatin_system, String Ram, int warranty, double actual_price,double saling_price)throws SQLException;

        void addCustomer(String customer_name, long phone, String email, Address address)throws SQLException;

        Customer viewCustomerByphone(long phone)throws SQLException;

        List<Customer> viewAllCustomer()throws SQLException;

       List< Stocks> getStockbyname(String productModel)throws SQLException;

        List<Stocks> getAllStocks()throws SQLException;

        void generateBill(String customer_name, long phone, String email, Address address, long invoice_number, Date billiDate, String typesofPayment, String productModel, String brand, String serialnumber, double  weight, String color, String display, String storage, String operatin_system, String ram, int warranty, double amount)throws SQLException;

        Bill getbillByphone(long phone)throws SQLException;

       List <Bill> getAllBills() throws SQLException;

}
