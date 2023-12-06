package logistic;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Init {
    JdbcTemplate jdbcTemplate;
    public Init(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        productInit();
        orderInit();
        warehouseInit();
        personalInformationInit();
        shippingInit();
        taskResourceInit();
        employeeInit();
    }

    public void productInit() {
        String categorySql = "create table category(" +
                "category_id integer auto_increment," +
                "category_name varchar(50)," +
                "parent_category_id integer," +
                "primary key(category_id));";
        String product_categorySql = "create table product_category(" +
                "product_id integer," +
                "category_id integer," +
                "primary key(product_id));";
        String product_infoSql = "create table product_info(" +
                "product_id integer," +
                "description text," +
                "supplier_id integer," +
                "location_id integer," +
                "quantity integer," +
                "primary key(product_id));";
        String barcodeSql = "create table barcode(" +
                "barcode_id integer auto_increment," +
                "barcode varchar(70)," +
                "product_id integer," +
                "primary key(barcode_id));";
        String productSql = "create table product(" +
                "product_id integer auto_increment," +
                "name varchar(50)," +
                "price integer," +
                "primary key(product_id));";
        String supplierSql = "create table supplier(" +
                "supplier_id integer auto_increment," +
                "name varchar(50)," +
                "description text," +
                "primary key(supplier_id));";
        jdbcTemplate.update(categorySql);
        jdbcTemplate.update(product_categorySql);
        jdbcTemplate.update(product_infoSql);
        jdbcTemplate.update(barcodeSql);
        jdbcTemplate.update(productSql);
        jdbcTemplate.update(supplierSql);
    }

    public void orderInit() {
        String orderSql = "create table order(" +
                "order_id integer auto_increment," +
                "customer_id integer," +
                "order_date varchar(50)," +
                "total_payment integer," +
                "primary key(order_id));";
        String order_itemSql = "create table order_item(" +
                "order_item_id integer auto_increment," +
                "order_id integer," +
                "product_id integer," +
                "order_quantity integer," +
                "primary key(order_item_id));";
        String customerSql = "create table customer(" +
                "customer_id integer auto_increment," +
                "customer_info_id integer," +
                "name varchar(50)," +
                "primary key(customer_id));";
        jdbcTemplate.update(orderSql);
        jdbcTemplate.update(order_itemSql);
        jdbcTemplate.update(customerSql);
    }

    public void warehouseInit() {
        String warehouseSql = "create table warehouse(" +
                "warehouse_id integer auto_increment," +
                "address varchar(70)," +
                "primary key(warehouse_id));";
        String locationSql = "create table location(" +
                "location_id integer auto_increment," +
                "location_name varchar(60)," +
                "warehouse_id integer," +
                "primary key(location_id));";
        String occupancySql = "create table occupancy(" +
                "warehouse_id integer," +
                "occupancy_rate integer," +
                "primary key(warehouse_id));";
        jdbcTemplate.update(warehouseSql);
        jdbcTemplate.update(locationSql);
        jdbcTemplate.update(occupancySql);
    }

    public void personalInformationInit() {
        String personal_infoSql = "create table personal_info(" +
                "personal_info_id integer auto_increment," +
                "phone_number varchar(30)," +
                "address varchar(50)," +
                "age integer," +
                "primary key(personal_info_id));";
        String accountSql = "create table account(" +
                "customer_id integer," +
                "password varchar(50)," +
                "account_authority_id integer," +
                "primary key(customer_id));";
        String account_authoritySql = "create table account_authority(" +
                "account_authority integer auto_increment," +
                "authority_name varchar(50)," +
                "primary key(account_authority));";

        jdbcTemplate.update(personal_infoSql);
        jdbcTemplate.update(accountSql);
        jdbcTemplate.update(account_authoritySql);
    }

    public void shippingInit() {
        String shippingSql = "create table shipping(" +
                "shipping_id integer auto_increment," +
                "transfer_status_id integer," +
                "destination_id integer," +
                "shipping_date varchar(40)," +
                "order_id integer," +
                "primary key(shipping_id));";
        String placeSql = "create table place(" +
                "place_id integer auto_increment," +
                "place_name varchar(50)," +
                "place_info text," +
                "primary key(place_id));";
        String transfer_statusSql = "create table transfer_status(" +
                "status_id integer auto_increment," +
                "status varchar(50)," +
                "primary key(status_id));";
        String shipping_logSql = "create table shipping_log(" +
                "log_id integer auto_increment," +
                "shipping_id integer," +
                "place_id integer," +
                "status_id integer," +
                "time varchar(50)," +
                "primary key(log_id));";
        String shipping_requirementSql = "create table shipping_requirement(" +
                "shipping_id integer," +
                "requirement text," +
                "primary key(shipping_id));";
        jdbcTemplate.update(shippingSql);
        jdbcTemplate.update(placeSql);
        jdbcTemplate.update(transfer_statusSql);
        jdbcTemplate.update(shipping_logSql);
        jdbcTemplate.update(shipping_requirementSql);
    }

    public void employeeInit() {
        String employeeSql = "create table employee(" +
                "employee_id integer auto_increment," +
                "name varchar(50)," +
                "role_id integer," +
                "department_id integer," +
                "team_id integer," +
                "personal_info integer," +
                "primary key(employee_id));";
        String departmentSql = "create table department(" +
                "department_id integer auto_increment," +
                "department_name varchar(50)," +
                "primary key(department_id));";
        String roldSql = "create table role(" +
                "role_id integer auto_increment," +
                "role_name varchar(50)," +
                "primary key(role_id));";
        String teamSql = "create table team(" +
                "team_id integer auto_increment," +
                "department_id integer," +
                "team_name varchar(50)," +
                "primary key(team_id));";
        jdbcTemplate.update(employeeSql);
        jdbcTemplate.update(departmentSql);
        jdbcTemplate.update(roldSql);
        jdbcTemplate.update(teamSql);

        String insertDepartment = "INSERT INTO department (department_name) VALUES " +
                "('Sales'), " +
                "('Marketing'), " +
                "('Finance'), " +
                "('Human Resources'), " +
                "('Research and Development'), " +
                "('Customer Service'), " +
                "('IT'), " +
                "('Operations'), " +
                "('Legal'), " +
                "('Administration');";

    }

    public void taskResourceInit() {
        String taskSql = "create table task(" +
                "task_id integer auto_increment," +
                "task_name varchar(50)," +
                "task_description text," +
                "start_date varchar(50)," +
                "end_date varchar(50)," +
                "primary key(task_id));";
        String resource_allocationSql = "create table resource_allocation(" +
                "allocation_id integer auto_increment," +
                "task_id integer," +
                "resource_id integer," +
                "primary key(allocation_id));";
        String task_assignmentSql = "create table task_assignment(" +
                "employee_id integer," +
                "task_id integer," +
                "primary key(employee_id));";
        String resourceSql = "create table resource(" +
                "resource_id integer auto_increment," +
                "resource_name varchar(50)," +
                "quantity integer," +
                "location_id integer," +
                "primary key(resource_id));";
        String vehicleSql = "create table vehicle(" +
                "vehicle_id integer auto_increment," +
                "car_model varchar(50)," +
                "employee_id integer," +
                "primary key(vehicle_id));";
        jdbcTemplate.update(taskSql);
        jdbcTemplate.update(resource_allocationSql);
        jdbcTemplate.update(task_assignmentSql);
        jdbcTemplate.update(resourceSql);
        jdbcTemplate.update(vehicleSql);
    }

}
