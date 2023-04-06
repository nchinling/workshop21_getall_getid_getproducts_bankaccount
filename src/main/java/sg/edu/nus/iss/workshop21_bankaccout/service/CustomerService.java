package sg.edu.nus.iss.workshop21_bankaccout.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.workshop21_bankaccout.model.Customer;
import sg.edu.nus.iss.workshop21_bankaccout.model.Product;
import sg.edu.nus.iss.workshop21_bankaccout.repository.CustomerRepo;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo custrepo;
    
    public List<Customer> findAll(int offset, int limit) throws IOException{
        return custrepo.findAll(offset, limit);
    }

    public Customer findById(final Integer customerId){
        return custrepo.findById(customerId);
    }  


    public List<Product> getCustomerProducts(final Integer customerId) throws IOException{
        return custrepo.getCustomerProducts(customerId);
    }



}
