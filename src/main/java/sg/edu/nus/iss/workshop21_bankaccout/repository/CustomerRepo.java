package sg.edu.nus.iss.workshop21_bankaccout.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import static sg.edu.nus.iss.workshop21_bankaccout.repository.DBQueries.*;

import sg.edu.nus.iss.workshop21_bankaccout.model.Customer;
import sg.edu.nus.iss.workshop21_bankaccout.model.Product;

@Repository
public class CustomerRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public List<Customer> findAll(int offset, int limit){
        
        // List<Customer> custs = new ArrayList<Customer>();
        // SqlRowSet rs =  jdbcTemplate.queryForRowSet(SELECT_ALL_CUSTOMERS, offset,
        //                                              limit);
        // while(rs.next()){
        //     custs.add(Customer.create(rs));
        // }

        List<Customer> customers = jdbcTemplate.query(SELECT_ALL_CUSTOMERS, 
        new CustomerRowMapper() , new Object[]{offset, limit});

        return customers;
    }


    public Customer findById(Integer customerId){
        List<Customer> customers = jdbcTemplate.query(SELECT_CUSTOMER_BY_ID, 
        new CustomerRowMapper() , new Object[]{customerId});
        
        return customers.get(0);

    }


    public List<Product> getCustomerProducts(Integer customerId ){
        
        List<Product> products = new ArrayList<Product>();
        SqlRowSet rs =  jdbcTemplate.queryForRowSet(SELECT_PRODUCTS_FOR_CUSTOMERS,
                                                        customerId);
        
        while(rs.next()){
            products.add(Product.create(rs));
        }

        // List<Product> customers = jdbcTemplate.query(SELECT_PRODUCTS_FOR_CUSTOMERS, 
        // new CustomerRowMapper() , new Object[]{customerId});

        return products;
    }

    



}
