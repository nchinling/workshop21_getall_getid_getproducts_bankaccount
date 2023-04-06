package sg.edu.nus.iss.workshop21_bankaccout.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonValue;

public class Customer  {
    
    private Integer id;
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;
    private String citizenship;
    
    
    
    public Customer() {
    }

    
    public Customer(Integer id, String lastName, String firstName, String email, String phoneNumber,
            String citizenship) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.citizenship = citizenship;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getCitizenship() {
        return citizenship;
    }
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }


    @Override
    public String toString() {
        return "Customer [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
                + ", phoneNumber=" + phoneNumber + ", citizenship=" + citizenship + "]";
    }


    //create customer object
    public static Customer create(SqlRowSet rs){
        Customer customer = new Customer();

        customer.setId(rs.getInt("id"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        customer.setEmail(rs.getString("email_address"));
        customer.setPhoneNumber(rs.getString("phone_number"));
        customer.setCitizenship(rs.getString("citizenship"));

        return customer;
    }

    //convert to JSON
    public JsonValue toJson(){
        return Json.createObjectBuilder()
            .add("id", getId())
            .add("first_name", getFirstName())
            .add("last_name", getLastName())
            .add("email_address", getEmail())
            .add("phone_number", getPhoneNumber())
            .add("citizenship", getCitizenship())
            .build();
    }

    
}



// -> id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
// -> last_name VARCHAR(50),
// -> first_name VARCHAR(50),
// -> email_address VARCHAR(50),
// -> phone_number VARCHAR(50),
// -> citizenship VARCHAR(50)
// -> );
