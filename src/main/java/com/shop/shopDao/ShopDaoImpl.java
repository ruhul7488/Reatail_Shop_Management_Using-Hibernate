package com.shop.shopDao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.shop.shopModel.Address;
import com.shop.shopModel.Bill;
import com.shop.shopModel.Customer;
import com.shop.shopModel.Product;
import com.shop.shopModel.Stocks;

public  class ShopDaoImpl implements ShopDAO{


    EntityManagerFactory emf  = Persistence.createEntityManagerFactory("ShopUnit");
		
    EntityManager em = emf.createEntityManager() ;

    //  public List<Product> getproductDetailByname(String productModel) throws SQLException{
             
                
    //                    String sql = "SELECT * FROM product WHERE productModel = :productModel";
               
    //                    Query query = em.createNativeQuery(sql, Product.class);
               
    //                    query.setParameter("productModel",productModel);
               
    //                   List<Product> product = query.getResultList();
               
    //                    return product;
               
    //            }

   public List<Product> getproductDetailByname(String productModel) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShopUnit");
    EntityManager em = emf.createEntityManager();
    
    try {
        String sql = "SELECT * FROM product WHERE productModel = :productModel";
        Query query = em.createNativeQuery(sql, Product.class);  
        query.setParameter("productModel", productModel);
        
        List<Product> products = query.getResultList();
        return products;
    } catch (PersistenceException e) {
        e.printStackTrace();  
    } finally {
        em.close();  
    }
    return null;  
}



            //    public List<Product> getAllProduct() throws SQLException {
            //     try {

            //         String sql = "SELECT * FROM product";
            //         Query query = em.createNativeQuery(sql, Product.class);
        
            //         List<Product> productList = query.getResultList();
        
            //         return productList;
        
            //     } catch (Exception e) {
            //         throw new SQLException("Error fetching all products", e);
            //     }
            // }
            public List<Product> getAllProduct() {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShopUnit");
                EntityManager em = emf.createEntityManager();
                try {
                    String sql = "SELECT * FROM product";
                    Query query = em.createNativeQuery(sql, Product.class);
                    
                    List<Product> productList = query.getResultList();
                    
                    return productList;
                } catch (Exception e) {
                   
                    throw new RuntimeException("Error fetching all products", e);
                } finally {
                    em.close(); 
                }
            }
            

        //   public  void newStock(String productModel, String brand, String serialnumber, int weight, String color, String display, String storage, String operatin_system, String ram, int warranty, double actual_price,double saling_price)throws SQLException{

        //     Stocks st=new Stocks(productModel, brand, serialnumber, weight, color, display, storage, operatin_system, ram, warranty, actual_price, saling_price);

        //     em.getTransaction().begin();
        //     em.persist(st);
        //     em.getTransaction().commit();
        //     em.close();

        //   }

        public void newStock(String productModel, String brand, String serialNumber, double  weight, 
                     String color, String display, String storage, String operatingSystem, 
                     String ram, int warranty, double actualPrice, double sellingPrice) {
    EntityManager em = emf.createEntityManager();  
    
    try {
        Stocks st = new Stocks(productModel, brand, serialNumber, weight, color, display, 
                               storage, operatingSystem, ram, warranty, actualPrice, sellingPrice);
        
        em.getTransaction().begin();  
        em.persist(st);               
        em.getTransaction().commit(); 
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback(); 
        }
        throw new RuntimeException("Error adding new stock", e); 
    } finally {
        if (em.isOpen()) {
            em.close(); 
        }
    }
}


        //  public void addCustomer(String customer_name, long phone, String email, Address address)throws SQLException{

        //     Customer cs=new Customer(customer_name, phone, email, address);
        //     em.getTransaction().begin();
        //     em.persist(cs);
        //     em.getTransaction().commit();
        //     em.close();

        //   }

        public void addCustomer(String customerName, long phone, String email, Address address) {
            EntityManager em = emf.createEntityManager();  
            
            try {
                Customer cs = new Customer(customerName, phone, email, address);
                
                em.getTransaction().begin();  
                em.persist(cs);               
                em.getTransaction().commit(); 
            } catch (Exception e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback(); 
                }
                throw new RuntimeException("Error adding new customer", e); 
            } finally {
                if (em.isOpen()) {
                    em.close();  
                }
            }
        }
        
        //  public Customer viewCustomerByphone(long phone)throws SQLException{
             
        //     String qr1="select * from Customer where phone=:phone";

        //     Query query1 = em.createNativeQuery(qr1, Customer.class);
               
        //                query1.setParameter("phone",phone);
               
        //                Customer cst = (Customer) query1.getSingleResult();
               
        //                return cst;
           
        //  }

        public Customer viewCustomerByphone(long phone) {
    EntityManager em = emf.createEntityManager();  

    try {
        String qr1 = "SELECT * FROM Customer WHERE phone = :phone";
        
        Query query1 = em.createNativeQuery(qr1, Customer.class);
        query1.setParameter("phone", phone);

        try {
            Customer cst = (Customer) query1.getSingleResult(); 
            return cst;
        } catch (NoResultException e) {
            return null;  
        }
    } catch (PersistenceException e) {
        throw new RuntimeException("Error fetching customer by phone", e);
    } finally {
        if (em.isOpen()) {
            em.close();  
        }
    }
}



        //  public List<Customer> viewAllCustomer()throws SQLException {
          
        //     try {

        //         String sql = "SELECT * FROM Customer";
        //         Query query = em.createNativeQuery(sql, Customer.class);
    
        //         List<Customer> customerList = query.getResultList();
    
        //         return customerList;
    
        //     } catch (Exception e) {
        //         throw new SQLException("Error fetching all products", e);
        //     }
        //  }

        public List<Customer> viewAllCustomer() {
            EntityManager em = emf.createEntityManager();  
        
            try {
                String sql = "SELECT * FROM Customer";
                Query query = em.createNativeQuery(sql, Customer.class);
        
                List<Customer> customerList = query.getResultList();
                return customerList;
            } catch (PersistenceException e) {
                throw new RuntimeException("Error fetching all customers", e);
            } finally {
                if (em.isOpen()) {
                    em.close();  
                }
            }
        }
        

        //  public Stocks getStockbyname(String productModel)throws SQLException{
                
        //     String qr1="select * from Stocks where productModel=:productModel";

        //     Query query1 = em.createNativeQuery(qr1, Stocks.class);
               
        //                query1.setParameter("productModel",productModel);
               
        //                Stocks sct = (Stocks) query1.getSingleResult();
               
        //                return sct;
        //  }

        public List<Stocks>getStockbyname(String productModel) {
            EntityManager em = emf.createEntityManager();  
            
            try {
                String qr1 = "SELECT * FROM Stocks WHERE productModel = :productModel";
                Query query1 = em.createNativeQuery(qr1, Stocks.class);
                query1.setParameter("productModel", productModel);
        
                try {
                    List<Stocks> sct =  query1.getResultList();
                    return sct;
                } catch (NoResultException e) {
                    return null;  
                }
            } catch (PersistenceException e) {
                throw new RuntimeException("Error fetching stock by product model", e);
            } finally {
                if (em.isOpen()) {
                    em.close();  
                }
            }
        }
        

        //  public List<Stocks> getAllStocks()throws SQLException{

        //     try {

        //         String sql = "SELECT * FROM Stocks";
        //         Query query = em.createNativeQuery(sql, Stocks.class);
    
        //         List<Stocks> stockList = query.getResultList();
    
        //         return stockList;
    
        //     } catch (Exception e) {
        //         throw new SQLException("Error fetching all products", e);
        //     }
        //  }

        public List<Stocks> getAllStocks() {
            EntityManager em = emf.createEntityManager();  
            
            try {
                String sql = "SELECT * FROM Stocks";
                Query query = em.createNativeQuery(sql, Stocks.class);
                
                List<Stocks> stockList = query.getResultList();
                return stockList;
            } catch (PersistenceException e) {
               
                throw new RuntimeException("Error fetching all stocks", e);
            } finally {
                if (em.isOpen()) {
                    em.close(); 
                }
            }
        }
        
          
        //  public void generateBill(String customer_name, long phone, String email, Address address, String invoice_number,Date billiDate, String typesofPayment, String productModel, String brand, String serialnumber, int weight,String color, String display, String storage, String operatin_system, String ram, int warranty,double amount) throws SQLException{

        //     Bill bil =new Bill(customer_name, phone, email, address, invoice_number, billiDate, typesofPayment, productModel, brand, serialnumber, weight, color, display, storage, operatin_system, ram, warranty, amount);

        //     em.getTransaction().begin();
        //     em.persist(bil);
        //     em.getTransaction().commit();
        //     em.close();

        //  }

        public void generateBill(String customerName, long phone, String email, Address address, 
                         long invoiceNumber, Date billDate, String typesOfPayment, 
                         String productModel, String brand, String serialNumber, double  weight, 
                         String color, String display, String storage, String operatingSystem, 
                         String ram, int warranty, double amount) {
    EntityManager em = emf.createEntityManager();  
    
    try {
        Bill bil = new Bill(customerName, phone, email, address, invoiceNumber, billDate, 
                            typesOfPayment, productModel, brand, serialNumber, weight, color, 
                            display, storage, operatingSystem, ram, warranty, amount);

        em.getTransaction().begin();
        em.persist(bil);
        em.getTransaction().commit();
    } catch (PersistenceException e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();  
        }
        throw new RuntimeException("Error generating the bill", e);
    } finally {
        if (em.isOpen()) {
            em.close();  
        }
    }
}

            
        //   public Bill getbillByphone(long phone)throws SQLException{

        //     String qr1="select * from Bill where phone=:phone";

        //     Query query1 = em.createNativeQuery(qr1, Bill.class);
               
        //                query1.setParameter("phone",phone);
               
        //                Bill bil = (Bill) query1.getSingleResult();
               
        //                return bil;
        //   }

        public Bill getbillByphone(long phone) {
            EntityManager em = emf.createEntityManager();  
            
            try {
                String qr1 = "SELECT * FROM Bill WHERE phone = :phone";
                Query query1 = em.createNativeQuery(qr1, Bill.class);
                query1.setParameter("phone", phone);
        
                try {
                    Bill bil = (Bill) query1.getSingleResult();
                    return bil;
                } catch (NoResultException e) {
                    return null;  
                }
            } catch (PersistenceException e) {
                throw new RuntimeException("Error fetching bill by phone", e);
            } finally {
                if (em.isOpen()) {
                    em.close();  
                }
            }
        }
        

               
        // public  List <Bill> getAllBills() throws SQLException{

        //     try {

        //         String sql = "SELECT * FROM Bill";
        //         Query query = em.createNativeQuery(sql, Bill.class);
    
        //         List<Bill> billList = query.getResultList();
    
        //         return billList;
    
        //     } catch (Exception e) {
        //         throw new SQLException("Error fetching all products", e);
        //     }
        // }

          
        public List<Bill> getAllBills() {
            EntityManager em = emf.createEntityManager(); 
            
            try {
                String sql = "SELECT * FROM Bill";
                Query query = em.createNativeQuery(sql, Bill.class);
                
                List<Bill> billList = query.getResultList();
                return billList;
            } catch (PersistenceException e) {
                throw new RuntimeException("Error fetching all bills", e);
            } finally {
                if (em.isOpen()) {
                    em.close();  
                }
            }
        }
        


          }



