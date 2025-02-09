package com.shop;

import java.util.Scanner;

import com.shop.util.ShopOps;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("================= Main Menu =================");
            System.out.println("Click 1: for Products");
            System.out.println("Click 2: for Customers");
            System.out.println("Click 3: for Bill");
            System.out.println("Click 4: for Stocks");
            System.out.println("Click 0: for Exit");
            int ch = sc.nextInt();

            if (ch == 0) {
                System.out.println("Exiting...");
                break; 
            } else if (ch == 1) {
                while (true) {
                    System.out.println("Click 1: view Product By Name:");
                    System.out.println("Click 2: view All Product :");
                    System.out.println("Click 0: Back to Main Menu:");
                    int pr = sc.nextInt();

                    if (pr == 1) {
                        ShopOps.viewProductByName(); 
                    } else if (pr == 2) {
                        ShopOps.viewAllProduct(); 
                    } else if (pr == 0) {
                        break;
                    } else {
                        System.out.println("Invalid choice, please try again.");
                    }
                }
            } else if (ch == 2) {
                while (true) {
                    System.out.println("Click 1: Add New Customer:");
                    System.out.println("Click 2: view Customer Details By Phone Number :");
                    System.out.println("Click 3: View All Customer Details:");
                    System.out.println("Click 0: Back to Main Menu:");
                    int cs = sc.nextInt();

                    if (cs == 1) {
                        ShopOps.addNewCustomer(); 
                    } else if (cs == 2) {
                        ShopOps.viewcustomerbyphone();
                    } else if (cs == 3) {
                        ShopOps.viewallcustomer();
                    } else if(cs==0){
                        break;
                    }
                    else {
                        System.out.println("Invalid choice, please try again.");
                    }
                }
            } else if (ch == 3) {
                while (true) {
                    System.out.println("Click 1:Generate New Bill:");
                    System.out.println("Click 2: view  Customer Bill Details By Phone Number :");
                    System.out.println("Click 3: View All Customer's Bill Details:");
                    System.out.println("Click 0: Back to Main Menu:");
                    int bl = sc.nextInt();

                    if (bl == 1) {
                        ShopOps.generateNewBill();
                    } else if (bl == 2) {
                        ShopOps.viewBillbyPhone();
                    } else if (bl == 3) {
                        ShopOps.viewAllBill();
                    } else if(bl==0){
                        break;
                    }
                    else {
                        System.out.println("Invalid choice, please try again.");
                    }
                }
            } else if (ch == 4) {
                while (true) {
                    System.out.println("Click 1: Add New Stock:");
                    System.out.println("Click 2: view Stock Details By Product Name:");
                    System.out.println("Click 3: View All Stock Details:");
                    System.out.println("Click 0: Back to Main Menu:");
                    int stk = sc.nextInt();

                    if (stk == 1) {
                        ShopOps.addnewStock();
                    } else if (stk == 2) {
                        ShopOps.viewStockbyName();
                    } else if (stk == 3) {
                        ShopOps.viewAllStocks();
                    } else if(stk==0){
                        break;
                    }
                    else {
                        System.out.println("Invalid choice, please try again.");
                    }
                }
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }

        sc.close();
    }
}
