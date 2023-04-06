package sg.edu.nus.iss.workshop21_bankaccout.repository;

public class DBQueries {
    public static final String SELECT_ALL_CUSTOMERS="select * from customers limit ?, ?";
    public static final String SELECT_CUSTOMER_BY_ID ="select * from customers where id = ?";
    
    public static final String SELECT_PRODUCTS_FOR_CUSTOMERS = "select c.id as customer_id, c.last_name, c.first_name, p.id as product_order_id, p.product_name, p.date_created, p.value, p.customer_id"
                                                                +" from customers c, products p where c.id = p.customer_id and customer_id = ?";
}
