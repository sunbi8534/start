package logistic;

import org.springframework.jdbc.core.JdbcTemplate;
import Dto.orderDto.customer;
import Dto.orderDto.order_item;
import Dto.orderDto.order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Order {
    public JdbcTemplate jdbcTemplate;

    public Order(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateOrder(int order_id, int customer_id, String order_date, int total_payment) {
        String sql = "update order set customer_id = ?, order_date = ?, total_payment = ? where order_id = ?;";
        jdbcTemplate.update(sql, customer_id, order_date, total_payment, order_id);
    }

    public void deleteOrder(int order_id) {
        String sql = "delete from order where order_id = ?;";
        jdbcTemplate.update(sql, order_id);
    }

    public List<order> readOrderAll() {
        String sql = "select order_id, customer_id, order_date, total_payment from order;";
        List<order> orderList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new order(rs.getInt("order_id"), rs.getInt("customer_id"),
                        rs.getString("order_date"), rs.getInt("total_payment")));
        return orderList;
    }

    public order readOrder(int order_id) {
        String sql = "select order_id, customer_id, order_date, total_payment from order where order_id = ?;";
        order o = jdbcTemplate.queryForObject(sql, order.class, order_id);
        return o;
    }

    public void createOrder(int customer_id, String order_date, int total_payment) {
        String sql = "insert into order (customer_id, order_date, total_payment) values (?, ?, ?);";
        jdbcTemplate.update(sql, customer_id, order_date, total_payment);
    }

    public void updateOrderItem(int order_item_id, int order_id, int product_id, int order_quantity) {
        String sql = "update order_item set order_id = ?, product_id = ?, order_quantity = ? where order_item_id = ?;";
        jdbcTemplate.update(sql, order_id, product_id, order_quantity, order_item_id);
    }

    public void deleteOrderItem(int order_item_id) {
        String sql = "delete from order_item where order_item_id = ?;";
        jdbcTemplate.update(sql, order_item_id);
    }

    public List<order_item> readOrderItemAll() {
        String sql = "select order_item_id, order_id, product_id, order_quantity from order_item;";
        List<order_item> orderItemList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new order_item(rs.getInt("order_item_id"), rs.getInt("order_id"),
                        rs.getInt("product_id"), rs.getInt("order_quantity")));
        return orderItemList;
    }

    public order_item readOrderItem(int order_item_id) {
        String sql = "select order_item_id, order_id, product_id, order_quantity from order_item where order_item_id = ?;";
        order_item orderItem = jdbcTemplate.queryForObject(sql, order_item.class, order_item_id);
        return orderItem;
    }

    public void createOrderItem(int order_id, int product_id, int order_quantity) {
        String sql = "insert into order_item (order_id, product_id, order_quantity) values (?, ?, ?);";
        jdbcTemplate.update(sql, order_id, product_id, order_quantity);
    }

    public void updateCustomer(int customer_id, String name, int customer_info_id) {
        String sql = "update customer set name = ?, customer_info_id = ? where customer_id = ?;";
        jdbcTemplate.update(sql, name, customer_info_id, customer_id);
    }

    public void deleteCustomer(int customer_id) {
        String sql = "delete from customer where customer_id = ?;";
        jdbcTemplate.update(sql, customer_id);
    }

    public List<customer> readCustomerAll() {
        String sql = "select customer_id, name, customer_info_id from customer;";
        List<customer> customerList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new customer(rs.getInt("customer_id"), rs.getString("name"),
                        rs.getInt("customer_info_id")));
        return customerList;
    }

    public customer readCustomer(int customer_id) {
        String sql = "select customer_id, name, customer_info_id from customer where customer_id = ?;";
        customer customer = jdbcTemplate.queryForObject(sql, customer.class, customer_id);
        return customer;
    }

    public void createCustomer(String name, int customer_info_id) {
        String sql = "insert into customer (name, customer_info_id) values (?, ?);";
        jdbcTemplate.update(sql, name, customer_info_id);
    }
}

