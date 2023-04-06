package sg.edu.nus.iss.workshop21_bankaccout.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import sg.edu.nus.iss.workshop21_bankaccout.model.Customer;
import sg.edu.nus.iss.workshop21_bankaccout.model.Product;
import sg.edu.nus.iss.workshop21_bankaccout.service.CustomerService;

@RestController
@RequestMapping(path = "/bank/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerRestController {
    
    @Autowired
    private CustomerService custsvc;

    @GetMapping()
    public ResponseEntity<String> getAllCustomers(@RequestParam(required=false, defaultValue ="0") String offset,
    @RequestParam(required=false, defaultValue ="5") String limit) throws NumberFormatException, IOException{

        List<Customer> customers = custsvc.findAll(Integer.parseInt(offset), 
                                    Integer.parseInt(limit));

        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        for (Customer c : customers){
            arrayBuilder.add(c.toJson());
        }

        //array is used as there is a list of customers
        JsonArray result = arrayBuilder.build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());
        
        
    }

    @GetMapping(path = "{customerId}")
    public ResponseEntity<String> getCustomerById(@PathVariable Integer customerId){
       
        JsonObject result;
        try{
            Customer customer = custsvc.findById(customerId); 
          
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
            objectBuilder.add("customer", customer.toJson());
            result = objectBuilder.build();
        } catch(Exception e){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"error msg\" : \"record not found\"}");
        }

        return ResponseEntity
        .status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(result.toString());
    }


    @GetMapping(path = "{customerId}/products")
    public ResponseEntity<String> getCustomerProducts(@PathVariable Integer customerId) throws IOException{
       List<Product> products = new ArrayList<Product>();
       JsonArray result = null;

       products = custsvc.getCustomerProducts(customerId);

       JsonArrayBuilder productArrayBuilder = Json.createArrayBuilder();

       for (Product p : products) {
           productArrayBuilder.add(p.toJson());
       }

       result = productArrayBuilder.build();
       if (result.size() == 0)
           return ResponseEntity
                   .status(HttpStatus.NOT_FOUND)
                   .contentType(MediaType.APPLICATION_JSON)
                //    .body("{\"error_msg\": \"record for\" "+ customerId +" \"not found \"}");
                   .body("{error_msg: record for customer "+ customerId +" not found :)}");

       return ResponseEntity
               .status(HttpStatus.OK)
               .contentType(MediaType.APPLICATION_JSON)
               .body(result.toString());

    }

}
