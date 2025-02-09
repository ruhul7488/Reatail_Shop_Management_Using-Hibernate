package com.shop.shopServices;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.shop.shopDao.ShopDAO;
import com.shop.shopDao.ShopDaoImpl;
import com.shop.shopModel.Address;
import com.shop.shopModel.Bill;
import com.shop.shopModel.Customer;
import com.shop.shopModel.Product;
import com.shop.shopModel.Stocks;

public class ShopService {

    private static ShopDAO shopDao= new ShopDaoImpl();

    public static List<Product> getproductDetailByname(String productModel) throws SQLException{
        return shopDao.getproductDetailByname(productModel);
    }

    
   public static List<Product> getAllProduct()throws SQLException{
                 return shopDao.getAllProduct();

           }

    public static void newStock(String productModel, String brand, String serialnumber, double  weight, String color, String display, String storage, String operatin_system,  int warranty, double actual_price,double saling_price, String Ram)throws SQLException{
            shopDao.newStock(productModel, brand, serialnumber, weight, color, display, storage, operatin_system, Ram, warranty, actual_price, saling_price);
    }


    public static void addCustomer(String customer_name, long phone, String email, Address address)throws SQLException{
        shopDao.addCustomer(customer_name, phone, email, address);
    }

    public static Customer viewCustomerByphone(long phone)throws SQLException{
        return shopDao.viewCustomerByphone(phone);
    }


   public static List<Customer> viewAllCustomer()throws SQLException{
    return shopDao.viewAllCustomer();
   }

   public static List<Stocks> getStockbyname(String productModel)throws SQLException{
       return  shopDao.getStockbyname(productModel);
   }

    
   public static  List<Stocks> getAllStocks()throws SQLException{
         return   shopDao.getAllStocks();
   }


   public static void generateBill(String customer_name, long phone, String email, Address address, long invoice_number, Date billiDate, String typesofPayment, String productModel, String brand, String serialnumber, double  weight, String color, String display, String storage, String operatin_system, String Ram, int warranty, double amount)throws SQLException{

      shopDao.generateBill(customer_name, phone, email, address, invoice_number, billiDate, typesofPayment, productModel, brand, serialnumber, weight, color, display, storage, operatin_system, Ram, warranty, amount);
   }
 

   public static Bill getbillByphone(long phone)throws SQLException{

       return shopDao.getbillByphone(phone);
   }


   public static  List <Bill> getAllBills() throws SQLException{

        return shopDao.getAllBills();
   }
}
