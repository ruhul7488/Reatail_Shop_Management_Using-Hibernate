package com.shop.util;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.shop.shopModel.Address;
import com.shop.shopModel.Bill;
import com.shop.shopModel.Customer;
import com.shop.shopModel.Product;
import com.shop.shopModel.Stocks;
import com.shop.shopServices.ShopService;

public class ShopOps {




    static Scanner sc = new Scanner(System.in);

    public static void viewProductByName() {
        System.out.println("Enter Product's Model Name:");
        String productName = sc.nextLine();

        try {
           
            List<Product> productList = ShopService.getproductDetailByname(productName); 
            
            if (productList != null && !productList.isEmpty()) {
                  System.out.println("==========================================================================================================================================================");
                  System.out.println("Sr/No.|productModel   |brand   |serialnumber |weight   |color  |display    |storage   |operating_system|ram   |warranty(years)|actual_price|selling_price");
                  System.out.println("==========================================================================================================================================================");

                for (Product product1 : productList) {
                   
              System.out.println(String.format("%-4d |%-7s | %-4s | %-7s   | %-5.2f   | %-5s  | %-4s | %-5s   | %-6s  |  %-4s  |   %-8d   |        %-6.2f |     %-8.2f",
                            product1.getProductid(), product1.getProductModel(), product1.getBrand(),
                            product1.getSerialnumber(), product1.getWeight(), product1.getColor(),
                            product1.getDisplay(), product1.getStorage(), product1.getOperatin_system(),
                            product1.getRam(), product1.getWarranty(), product1.getActual_price(),
                            product1.getSaling_price()));
                System.out.println("===========================================================================================================================================================");
                }
            } else {
                System.out.println("Record not found.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("An error occurred while retrieving product details.");
        }
    }

    public static void viewAllProduct(){
        try {
            List<Product> productList = ShopService.getAllProduct(); 
            
            if (productList != null && !productList.isEmpty()) {
                  System.out.println("========================================================================================================================================================");
                  System.out.println("Sr/No.|productModel   |brand   |serialnumber |weight   |color  |display    |storage   |operating_system|ram   |warranty(years)|actual_pric|selling_price");
                  System.out.println("=========================================================================================================================================================");

                for (Product product1 : productList) {
                   
              System.out.println(String.format("%-4d  |  %-7s   |  %-4s | %-7s   | %-5.1f   | %-5s  | %-4s | %-5s    | %-6s   |  %-4s   |%-2d  |%-4.2f |   %-5.2f",
                            product1.getProductid(), product1.getProductModel(), product1.getBrand(),
                            product1.getSerialnumber(), product1.getWeight(), product1.getColor(),
                            product1.getDisplay(), product1.getStorage(), product1.getOperatin_system(),
                            product1.getRam(), product1.getWarranty(), product1.getActual_price(),
                            product1.getSaling_price()));
                System.out.println("=========================================================================================================================================================");
                }
            } else {
                System.out.println("Record not found.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("An error occurred while retrieving product details.");
        }

    }
   
    public static void addnewStock(){

        System.out.println("Enter Product's Model Name:");
        String productModel=sc.nextLine();
        System.out.println("Enter Product's Brand Name:");
        String brand=sc.nextLine();
        System.out.println("Enter Product's Serial Number:");
        String serialNo=sc.nextLine();
        System.out.println("Enter Product's Model weight:");
        double weight=sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter Product's Model Colour:");
        String color=sc.nextLine();
        System.out.println("Enter Product's Model Display:");
        String display=sc.nextLine();
        System.out.println("Enter Product's Model Storage Capacity:");
        String storage=sc.nextLine();
        System.out.println("Enter Product's Model Operating System:");
        String OperatingSystem=sc.nextLine();
        System.out.println("Enter Product's Model Ram Capacity:");
        String Ram=sc.nextLine();
        System.out.println("Enter Product's Warranty in year's:");
        int warranty=sc.nextInt();
        System.out.println("Enter Product's Actual price:");
        double actualPrice=sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter Product's selling price:");
        double sellingPrice=sc.nextDouble();
       
        try {
            ShopService.newStock(productModel, brand, serialNo, weight, color, display, storage, OperatingSystem,warranty, actualPrice, sellingPrice,Ram);
        } catch (SQLException ex) {
        }
    }


    public static void viewStockbyName(){

        System.out.println("Enter Product's Model Name:");
        String productName = sc.nextLine();

        try {
            List<Stocks> productList = ShopService.getStockbyname(productName); 
            
            if (productList != null && !productList.isEmpty()) {
                  System.out.println("=========================================================================================================================================================");
                  System.out.println("Sr/No.|productModel   |brand   |serialnumber |weight   |color  |display    |storage   |operating_system|ram   |warranty(years)|actual_price|selling_price");
                  System.out.println("==========================================================================================================================================================");

                for (Stocks product1 : productList) {
                   
              System.out.println(String.format("%-4d |%-7s | %-4s | %-7s   | %-5.1f   | %-5s  | %-4s | %-5s   | %-6s  |  %-4s  |   %-8d   |        %-6.2f |     %-8.2f",
                            product1.getStockid(), product1.getProductModel(), product1.getBrand(),
                            product1.getSerialnumber(), product1.getWeight(), product1.getColor(),
                            product1.getDisplay(), product1.getStorage(), product1.getOperatin_system(),
                            product1.getRam(), product1.getWarranty(), product1.getActual_price(),
                            product1.getSaling_price()));
                System.out.println("===========================================================================================================================================================");
                }
            } else {
                System.out.println("Record not found.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("An error occurred while retrieving product details.");
        }
    }
       

    public static void viewAllStocks(){

        try {
            List<Stocks> productList = ShopService.getAllStocks(); 
            
            if (productList != null && !productList.isEmpty()) {
                  System.out.println("=========================================================================================================================================================");
                  System.out.println("Sr/No.|productModel   |brand   |serialnumber |weight   |color  |display    |storage   |operating_system|ram   |warranty(years)|actual_price|selling_price");
                  System.out.println("==========================================================================================================================================================");

                for (Stocks product1 : productList) {
                   
              System.out.println(String.format("%-4d |%-7s | %-4s | %-7s   | %-5.1f   | %-5s  | %-4s | %-5s   | %-6s  |  %-4s  |   %-8d   |        %-6.2f |     %-8.2f",
                            product1.getStockid(), product1.getProductModel(), product1.getBrand(),
                            product1.getSerialnumber(), product1.getWeight(), product1.getColor(),
                            product1.getDisplay(), product1.getStorage(), product1.getOperatin_system(),
                            product1.getRam(), product1.getWarranty(), product1.getActual_price(),
                            product1.getSaling_price()));
                System.out.println("===========================================================================================================================================================");
                }
            } else {
                System.out.println("Record not found.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("An error occurred while retrieving product details.");
        }
    }


    public static void addNewCustomer(){
        System.out.println("Enter Customer Name");
        String customerName=sc.nextLine();
        System.out.println("Enter Customer Phone Number");
        long phone =sc.nextLong();
        sc.nextLine();
        System.out.println("Enter Customer Email Id");
        String email=sc.nextLine();
        System.out.println("Enter Customer Address Details:");
        System.out.println("Enter Street:");
        String street=sc.nextLine();
        System.out.println("Enter City:");
        String city=sc.nextLine();
        System.out.println("Enter State:");
        String state =sc.nextLine();
        System.out.println("Enter Pin:");
        int pin =sc.nextInt();

        Address address=new Address();
        address.setStreet(street);
        address.setCity(city);
        address.setState(state);
        address.setPin(pin);

        try {
            ShopService.addCustomer(customerName, phone, email, address);
        } catch (SQLException ex) {
        }


    }



    public static void viewcustomerbyphone(){
        System.out.println("Enter Customer's Phone Number :");
        long phone =sc.nextLong();
        try {
            Customer customer=ShopService.viewCustomerByphone(phone);
       
           
           System.out.println("============= Customer Details ==================");
           System.out.println("Customer Name: "+ customer.getCustomer_name());
           System.out.println("Customer Phone: "+ customer.getPhone());
           System.out.println("Customer Email Id : "+ customer.getEmail());
           System.out.println("Customer Street: "+ customer.address.getStreet());
           System.out.println("Customer City : "+ customer.address.getCity());
           System.out.println("Customer State : "+ customer.address.getState());
           System.out.println("Customer Pin Code : "+ customer.address.getPin());
        System.out.println(" =======================================================");

    }
    catch (SQLException ex) {
    }
    }


    public static void viewallcustomer(){

        try {
            List<Customer> customerList = ShopService.viewAllCustomer(); 
            
            if (customerList != null && !customerList.isEmpty()) {
                    System.out.println("==================================================================================================================================================");
                    System.out.println("|Sr/No.|Customer Name     | Phone Number      | Email-Id               | Street            | City          | State                 |Pin Code     |");
                    System.out.println("|================================================================================================================================================|");

                for (Customer customer1 : customerList) {
                   
 System.out.println(String.format("| %-3d |%-4s        | %-4d        | %-4s          | %-5s       | %-5s      | %-4s      | %-4d       |",
                            customer1.getCustomer_id(), customer1.getCustomer_name(), customer1.getPhone(),
                            customer1.getEmail(), customer1.address.getStreet(), customer1.address.getCity(),
                            customer1.address.getState(), customer1.address.getPin()));
                   System.out.println("|================================================================================================================================================|");
                }
            } else {
                System.out.println("Record not found.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("An error occurred while retrieving product details.");
        }
    }



            public static void generateNewBill(){

                 System.out.println("============= Enter Billing Details =============");
                 System.out.println(" Enter Customer Name: ");
                 String customer_name=sc.nextLine();

                 System.out.println("Enter phone Number");
                 long phone=sc.nextLong();
                   sc.nextLine();
                 System.out.println("Enter email ID");
                 String email=sc.nextLine();

                 System.out.println("Enter Street:");
                 String street=sc.nextLine();

                 System.out.println("Enter City:");
                 String city=sc.nextLine();

                 System.out.println("Enter State:");
                 String state =sc.nextLine();

                 System.out.println("Enter Pin Code:");
                 int pin=sc.nextInt();

                 System.out.print("Enter billing date (yyyy-mm-dd): ");
                 String billingDateInput = sc.next();
                 Date billingDate = Date.valueOf(billingDateInput); 
             sc.nextLine();
                 System.out.print("Enter type of payment (e.g., Credit, Cash, Debit): ");
                 String Payment = sc.nextLine();
                 sc.nextLine();
                 System.out.print("Enter product model: ");
                 String productModel = sc.nextLine();
         
                 System.out.print("Enter product brand: ");
                 String brand = sc.nextLine();
         
                 System.out.print("Enter product serial number: ");
                 String serialnumber = sc.nextLine();
         
                 System.out.print("Enter product weight (kg): ");
                 double Weight = sc.nextDouble();
                 sc.nextLine();  
         
                 System.out.print("Enter product color: ");
                 String color = sc.nextLine();
         
                 System.out.print("Enter product display Configuration: ");
                 String display = sc.nextLine();
         
                 System.out.print("Enter product storage capacity (GB): ");
                 String storage = sc.nextLine();
         
                 System.out.print("Enter operating system (e.g., Windows, Android, iOS): ");
                 String operating_system = sc.nextLine();
         
                 System.out.print("Enter RAM size (GB): ");
                 String ram = sc.nextLine();
         
                 System.out.print("Enter warranty period (in years): ");
                 int warranty = sc.nextInt();
         
                 System.out.print("Enter the amount : ");
                 double amount = sc.nextDouble();

                 long invoice_number=invoiceNumber();

                 Address address=new Address();
                 address.setStreet(street);
                address.setCity(city);
                address.setState(state);
                address.setPin(pin);

        try {
            ShopService.generateBill(customer_name, phone, email, address, invoice_number, billingDate, Payment, productModel, brand, serialnumber, Weight, color, display, storage, operating_system, ram, warranty, amount);
        } catch (SQLException ex) {
        }

                    System.out.println("------ INVOICE ---");
             System.out.println("==================================================");
               System.out.println("|Invoice Number: " + invoice_number);
               System.out.println("|Billing Date: " + new SimpleDateFormat("yyyy-MM-dd").format(billingDate));
               System.out.println("|Payment Type: " + Payment);
             System.out.println("|Customer Information:");
               System.out.println("|Name: " + customer_name);
               System.out.println("|Phone: " + phone);
               System.out.println("|Email: " + email);
               System.out.println("|Address: " + address);
             System.out.println(" ---------------------------------------------------");
             System.out.println("|          Product Information:");
             System.out.println("-----------------------------------------------------");
               System.out.println("|Product Model: " + productModel);
               System.out.println("|Brand: " + brand);
               System.out.println("|Serial Number: " + serialnumber);
               System.out.println("|Weight: " + Weight + " kg");
               System.out.println("|Color: " + color);
               System.out.println("|Display: " + display);
               System.out.println("|Storage: " + storage);
               System.out.println("|Operating System: " + operating_system);
               System.out.println("|RAM: " + ram + " GB");
               System.out.println("|Warranty: " + warranty + " years");
             System.out.println("|----------------------------------------------------");
               System.out.println("|   Amount: " + amount);
             System.out.println("|----------------------------------------------------");



             try {
                ShopService.addCustomer(customer_name, phone, email, address);
            } catch (SQLException ex) {
            }


             EntityManagerFactory emf  = Persistence.createEntityManagerFactory("ShopUnit");
		
             EntityManager em = emf.createEntityManager() ;
            
                em.getTransaction().begin();
                int rowsAffected = em.createQuery("DELETE FROM Stocks s WHERE s.serialnumber = :serialnumber")
                .setParameter("serialnumber", serialnumber)
                .executeUpdate(); 
                em.getTransaction().commit();
                em.close();

    }

               public static long invoiceNumber() {
              Random random = new Random();
             long accountNumber = 0;
             for (int i = 0; i < 10; i++) {
            accountNumber = accountNumber * 10 + random.nextInt(10); 
        }
        
        return accountNumber;
    }




    public static void viewBillbyPhone(){
            System.out.println("Enter the Customer's Phone Number: ");
            long phone=sc.nextLong();

        try {
            Bill bill = ShopService.getbillByphone(phone);

            if(bill!=null){
                System.out.println("-------------- BILL No."+bill.getBill_id()+"--------------------------");
                System.out.println("==================================================");
                  System.out.println("|Invoice Number: " + bill.getInvoice_number());
                  System.out.println("|Billing Date: " + new SimpleDateFormat("yyyy-MM-dd").format(bill.getBilliDate()));
                  System.out.println("|Payment Type: " + bill.getTypesofPayment());
                System.out.println("|\nCustomer Information:");
                  System.out.println("|Name: " + bill.getCustomer_name());
                  System.out.println("|Phone: " + bill.getPhone());
                  System.out.println("|Email: " + bill.getEmail());
                  System.out.println("|Address: " + bill.getAddress());
                System.out.println(" ---------------------------------------------------");
                System.out.println("|          Product Information:");
                System.out.println("-----------------------------------------------------");
                  System.out.println("|Product Model: " + bill.getProductModel());
                  System.out.println("|Brand: " + bill.getBrand());
                  System.out.println("|Serial Number: " + bill.getSerialnumber());
                  System.out.println("|Weight: " + bill.getWeight() + " kg");
                  System.out.println("|Color: " + bill.getColor());
                  System.out.println("|Display: " + bill.getDisplay());
                  System.out.println("|Storage: " + bill.getStorage());
                  System.out.println("|Operating System: " + bill.getOperatin_system());
                  System.out.println("|RAM: " + bill.getRam() + " GB");
                  System.out.println("|Warranty: " + bill.getWarranty() + " years");
                System.out.println("|----------------------------------------------------");
                  System.out.println("|   Amount: " + bill.getAmount());
                System.out.println("|----------------------------------------------------");
                     
            } 
            else{
                System.out.println("Sorry Customer not exist for this Phone Number :");
            }  
        } catch (SQLException ex) {
        }

             
    }



       public static void viewAllBill(){
        try {
            List<Bill>bills=ShopService.getAllBills();

            if(bills!=null){
                for (Bill bill  : bills) {
                    System.out.println("-------------- BILL No."+bill.getBill_id()+"--------------------------");
                    System.out.println("==================================================");
                      System.out.println("|Invoice Number: " + bill.getInvoice_number());
                      System.out.println("|Billing Date: " + new SimpleDateFormat("yyyy-MM-dd").format(bill.getBilliDate()));
                      System.out.println("|Payment Type: " + bill.getTypesofPayment());
                    System.out.println("|\nCustomer Information:");
                      System.out.println("|Name: " + bill.getCustomer_name());
                      System.out.println("|Phone: " + bill.getPhone());
                      System.out.println("|Email: " + bill.getEmail());
                      System.out.println("|Address: " + bill.getAddress());
                    System.out.println(" ---------------------------------------------------");
                    System.out.println("|          Product Information:");
                    System.out.println("-----------------------------------------------------");
                      System.out.println("|Product Model: " + bill.getProductModel());
                      System.out.println("|Brand: " + bill.getBrand());
                      System.out.println("|Serial Number: " + bill.getSerialnumber());
                      System.out.println("|Weight: " + bill.getWeight() + " kg");
                      System.out.println("|Color: " + bill.getColor());
                      System.out.println("|Display: " + bill.getDisplay());
                      System.out.println("|Storage: " + bill.getStorage());
                      System.out.println("|Operating System: " + bill.getOperatin_system());
                      System.out.println("|RAM: " + bill.getRam() + " GB");
                      System.out.println("|Warranty: " + bill.getWarranty() + " years");
                    System.out.println("|----------------------------------------------------");
                      System.out.println("|   Amount: " + bill.getAmount());
                    System.out.println("|----------------------------------------------------");
                    System.out.println("==================================================");

                }
            }
            else{
                System.out.println("Bill Table is Empty:");
            }
        } catch (SQLException ex) {
        }
       }

}
