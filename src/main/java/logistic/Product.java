package logistic;

import Dto.productDto.barcode;
import Dto.productDto.product;
import Dto.productDto.category;
import Dto.productDto.product_category;
import Dto.productDto.product_info;
import Dto.productDto.supplier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Product {
    JdbcTemplate jdbcTemplate;

    public Product(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateProduct(int product_id, String name, int price) {
        String sql = "update product set name = ? and price = ? where product_id = ?;";
        jdbcTemplate.update(sql, name, price, product_id);
    }

    public void deleteProduct(int product_id) {
        String sql = "delete from product where product_id = ?;";
        jdbcTemplate.update(sql, product_id);
    }

    public List<product> readProductAll() {
        String sql = "select product_id, name, price from product;";
        List<product> productList = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return new product(rs.getInt("product_id"), rs.getString("name"), rs.getInt("price"));
        });
        return productList;
    }

    public product readProduct(int product_id) {
        String sql = "select product_id, name, price from product where product_id = ?;";
        product p = jdbcTemplate.queryForObject(sql, product.class, product_id);
        return p;
    }

    public void createProduct(String name, int price) {
        String sql = "insert into product (name, price) values (?, ?);";
        jdbcTemplate.update(sql, name, price);
    }

    public void updateBarcode(int barcode_id, String barcode, int product_id) {
        String sql = "update barcode set barcode = ? and product_id = ? where barcode_id = ?;";
        jdbcTemplate.update(sql, barcode, product_id, barcode_id);
    }

    public void deleteBarcode(int barcode_id) {
        String sql = "delete from barcode where barcode_id = ?;";
        jdbcTemplate.update(sql, barcode_id);
    }

    public List<barcode> readBarcodeAll() {
        String sql = "select barcode_id, barcode, product_id from barcode;";
        List<barcode> barcodeList = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return new barcode(rs.getInt("barcode_id"), rs.getString("barcode"), rs.getInt("product_id"));
        });
        return barcodeList;
    }

    public barcode readBarcode(int barcode_id) {
        String sql = "select barcode_id, barcode, product_id from barcode where barcode_id = ?;";
        barcode bar = jdbcTemplate.queryForObject(sql, barcode.class, barcode_id);
        return bar;
    }

    public void createBarcode(String barcode, int product_id) {
        String sql = "insert into barcode (barcode, product_id) values (?, ?);";
        jdbcTemplate.update(sql, barcode, product_id);
    }

    public void updateCategory(int category_id, String category_name, int parent_category_id) {
        String sql = "update category set category_name = ? and parent_category_id = ? where category_id = ?;";

        //parent_category_id == 0이라면 null이 들어갈 수 있도록 했다.
        if(parent_category_id != 0)
            jdbcTemplate.update(sql, category_name, parent_category_id, category_id);
        else
            jdbcTemplate.update(sql, category_name, null, category_id);
    }

    public void deleteCategory(int category_id) {
        String sql = "delete from category where category_id = ?;";
        jdbcTemplate.update(sql, category_id);
    }

    public List<category> readCategoryAll() {
        String sql = "select category_id, category_name, parent_category_id from category;";
        List<category> categoryList = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return new category(rs.getInt("category_id"), rs.getString("category_name"), rs.getInt("parent_category_id"));
        });

        return categoryList;
    }

    public category readCategory(int category_id) {
        String sql = "select category_id, category_name, parent_category_id from category where category_id = ?;";
        category c = jdbcTemplate.queryForObject(sql, category.class, category_id);
        return c;
    }

    public void createCategory(int category_name, int parent_category_id) {
        String sql = "insert into category (category_name, parent_category_id) values (?, ?);";
        jdbcTemplate.update(sql, category_name, parent_category_id);
    }

    public void updateProductCategory(int product_id, int category_id) {
        String sql = "update product_category set category_id = ? where product_id = ?;";
        jdbcTemplate.update(sql, category_id, product_id);
    }

    public void deleteProductCategory(int product_id) {
        String sql = "delete from product_category where product_id = ?;";
        jdbcTemplate.update(sql, product_id);
    }

    public List<product_category> readProductCategoryAll() {
        String sql = "select product_id, category_id from product_category;";
        List<product_category> productCategoryList = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return new product_category(rs.getInt("product_id"), rs.getInt("category_id"));
        });

        return productCategoryList;
    }

    public product_category readProductCategory(int product_id) {
        String sql = "select product_id, category_id from product_category where product_id = ?;";
        product_category pc = jdbcTemplate.queryForObject(sql, product_category.class, product_id);
        return pc;
    }

    public void createProductCategory(int product_id, int category_id) {
        String sql = "insert into product_category (product_id, category_id) values (?, ?);";
        jdbcTemplate.update(sql, product_id, category_id);
    }

    public void updateProductInfo(int product_id, String description, int supplier_id, int location_id, int quantity) {
        String sql = "update product_info set description = ? and supplier_id = ? and location_id = ? and quantity = ? where product_id = ?;";
        jdbcTemplate.update(sql, description, supplier_id, location_id, quantity, product_id);
    }

    public void deleteProductInfo(int product_id) {
        String sql = "delete from product_info where product_id = ?;";
        jdbcTemplate.update(sql, product_id);
    }

    public List<product_info> readProductInfoAll() {
        String sql = "select product_id, description, supplier_id, location_id, quantity from product_info;";
        List<product_info> productInfoList = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return new product_info(rs.getInt("product_id"), rs.getString("description"),
                    rs.getInt("supplier_id"), rs.getInt("location_id"), rs.getInt("quantity"));
        });

        return productInfoList;
    }

    public product_info readProductInfo(int product_id) {
        String sql = "select product_id, description, supplier_id, location_id, quantity from product_info where product_id = ?;";
        product_info pi = jdbcTemplate.queryForObject(sql, product_info.class, product_id);
        return pi;
    }

    public void createProductInfo(int product_id, String description, int supplier_id, int location_id, int quantity) {
        String sql = "insert into product_info (product_id, description, supplier_id, location_id, quantity) values (?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, product_id, description, supplier_id, location_id, quantity);
    }

    public void updateSupplier(int supplier_id, String name, String description) {
        String sql = "update supplier set name = ? and description = ? where supplier_id = ?;";
        jdbcTemplate.update(sql, name, description, supplier_id);
    }

    public void deleteSupplier(int supplier_id) {
        String sql = "delete from supplier where supplier_id = ?;";
        jdbcTemplate.update(sql, supplier_id);
    }

    public List<supplier> readSupplierAll() {
        String sql = "select supplier_id, name, description from supplier;";
        List<supplier> supplierList = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return new supplier(rs.getInt("supplier_id"), rs.getString("name"),
                    rs.getString("description"));
        });

        return supplierList;
    }

    public supplier readSupplier(int supplier_id) {
        String sql = "select supplier_id, name, description from supplier where supplier_id = ?;";
        supplier s = jdbcTemplate.queryForObject(sql, supplier.class, supplier_id);
        return s;
    }

    public void createSupplier(String name, String description) {
        String sql = "insert into supplier (name, description) values (?, ?);";
        jdbcTemplate.update(sql, name, description);
    }
}
