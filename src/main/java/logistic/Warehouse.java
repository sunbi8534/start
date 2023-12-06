package logistic;

import org.springframework.jdbc.core.JdbcTemplate;
import Dto.warehouseDto.warehouse;
import Dto.warehouseDto.location;
import Dto.warehouseDto.occupancy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Warehouse {
    JdbcTemplate jdbcTemplate;
    public Warehouse(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void updateWarehouse(int warehouse_id, String address) {
        String sql = "update warehouse set address = ? where warehouse_id = ?;";
        jdbcTemplate.update(sql, address, warehouse_id);

    }

    public void deleteWarehouse(int warehouse_id) {
        String sql = "delete from warehouse where warehouse_id = ?;";
        jdbcTemplate.update(sql, warehouse_id);
    }

    public List<warehouse> readWarehouseAll() {
        String sql = "select warehouse_id, address from warehouse;";
        List<warehouse> warehouseList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new warehouse(rs.getInt("warehouse_id"), rs.getString("address")));
        return warehouseList;
    }

    public warehouse readWarehouse(int warehouse_id) {
        String sql = "select warehouse_id, address from warehouse where warehouse_id = ?;";
        warehouse warehouse = jdbcTemplate.queryForObject(sql, warehouse.class, warehouse_id);
        return warehouse;
    }

    public void createWarehouse(String address) {
        String sql = "insert into warehouse (address) values (?);";
        jdbcTemplate.update(sql, address);
    }

    public void updateLocation(int location_id, String location_name, int warehouse_id) {
        String sql = "update location set location_name = ?, warehouse_id = ? where location_id = ?;";
        jdbcTemplate.update(sql, location_name, warehouse_id, location_id);
    }

    public void deleteLocation(int location_id) {
        String sql = "delete from location where location_id = ?;";
        jdbcTemplate.update(sql, location_id);
    }

    public List<location> readLocationAll() {
        String sql = "select location_id, location_name, warehouse_id from location;";
        List<location> locationList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new location(rs.getInt("location_id"), rs.getString("location_name"),
                        rs.getInt("warehouse_id")));
        return locationList;
    }

    public location readLocation(int location_id) {
        String sql = "select location_id, location_name, warehouse_id from location where location_id = ?;";
        location location = jdbcTemplate.queryForObject(sql, location.class, location_id);
        return location;
    }

    public void createLocation(String location_name, int warehouse_id) {
        String sql = "insert into location (location_name, warehouse_id) values (?, ?);";
        jdbcTemplate.update(sql, location_name, warehouse_id);
    }

    public void updateOccupancy(int warehouse_id, int occupancy_rate) {
        String sql = "update occupancy set occupancy_rate = ? where warehouse_id = ?;";
        jdbcTemplate.update(sql, occupancy_rate, warehouse_id);
    }

    public void deleteOccupancy(int warehouse_id) {
        String sql = "delete from occupancy where warehouse_id = ?;";
        jdbcTemplate.update(sql, warehouse_id);
    }

    public List<occupancy> readOccupancyAll() {
        String sql = "select warehouse_id, occupancy_rate from occupancy;";
        List<occupancy> occupancyList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new occupancy(rs.getInt("warehouse_id"), rs.getInt("occupancy_rate")));
        return occupancyList;
    }

    public occupancy readOccupancy(int warehouse_id) {
        String sql = "select warehouse_id, occupancy_rate from occupancy where warehouse_id = ?;";
        occupancy occupancy = jdbcTemplate.queryForObject(sql, occupancy.class, warehouse_id);
        return occupancy;
    }

    public void createOccupancy(int warehouse_id, int occupancy_rate) {
        String sql = "insert into occupancy (warehouse_id, occupancy_rate) values (?, ?);";
        jdbcTemplate.update(sql, warehouse_id, occupancy_rate);
    }
}
