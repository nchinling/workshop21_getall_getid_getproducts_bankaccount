package sg.edu.nus.iss.workshop21_bankaccout.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sg.edu.nus.iss.workshop21_bankaccout.model.Customer;

public class CustomerRowMapper implements RowMapper<Customer>{
    
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

        Customer customer = new Customer();
        
        customer.setId(rs.getInt("id"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        customer.setEmail(rs.getString("email_address"));
        customer.setPhoneNumber(rs.getString("phone_number"));
        customer.setCitizenship(rs.getString("citizenship"));

        return customer;

    }
}
