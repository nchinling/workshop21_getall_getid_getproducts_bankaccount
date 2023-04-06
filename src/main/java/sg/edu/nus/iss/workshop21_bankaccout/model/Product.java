package sg.edu.nus.iss.workshop21_bankaccout.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonValue;

public class Product {
    
    private Integer id;
    private String productName;
    private Customer customer;
    private Double value;
    
    public Product() {
    }

    public Product(Integer id, String productName, Customer customer, Double value) {
        this.id = id;
        this.productName = productName;
        this.customer = customer;
        this.value = value;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", productName=" + productName + ", customer=" + customer + ", value=" + value
                + "]";
    }


    public static Product create(SqlRowSet rs){
        Product product = new Product();
        Customer customer = new Customer();

        customer.setId(rs.getInt("customer_id"));
        customer.setFirstName(rs.getString("first_name"));
        product.setCustomer(customer);
        product.setId(rs.getInt("product_order_id"));
        product.setProductName(rs.getString("product_name"));
        product.setValue(rs.getDouble("value"));

        return product;

    }

    public JsonValue toJson(){
        return Json.createObjectBuilder()
        .add("customer_id", getCustomer().getId())
        .add("first_name",getCustomer().getFirstName())
        .add("product_order_id", getId())
        .add("product_name", getProductName())
        .add("value", getValue())
        .build();
    }

    
}



