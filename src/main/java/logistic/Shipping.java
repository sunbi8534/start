package logistic;

import Dto.shippingDto.shipping_requirement;
import Dto.shippingDto.place;
import Dto.shippingDto.shipping;
import Dto.shippingDto.shipping_log;
import Dto.shippingDto.transfer_status;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Shipping {
    JdbcTemplate jdbcTemplate;
    public Shipping(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateShippingRequirement(int shipping_id, String requirement) {
        String sql = "update shipping_requirement set requirement = ? where shipping_id = ?;";
        jdbcTemplate.update(sql, requirement, shipping_id);
    }

    public void deleteShippingRequirement(int shipping_id) {
        String sql = "delete from shipping_requirement where shipping_id = ?;";
        jdbcTemplate.update(sql, shipping_id);
    }

    public List<shipping_requirement> readShippingRequirementAll() {
        String sql = "select shipping_id, requirement from shipping_requirement;";
        List<shipping_requirement> shippingRequirementList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new shipping_requirement(rs.getInt("shipping_id"), rs.getString("requirement")));
        return shippingRequirementList;
    }

    public shipping_requirement readShippingRequirement(int shipping_id) {
        String sql = "select shipping_id, requirement from shipping_requirement where shipping_id = ?;";
        shipping_requirement shippingRequirement = jdbcTemplate.queryForObject(sql, shipping_requirement.class, shipping_id);
        return shippingRequirement;
    }

    public void createShippingRequirement(int shipping_id, String requirement) {
        String sql = "insert into shipping_requirement (shipping_id, requirement) values (?, ?);";
        jdbcTemplate.update(sql, shipping_id, requirement);
    }

    public void updatePlace(int place_id, String place_name, String place_info) {
        String sql = "update place set place_name = ?, place_info = ? where place_id = ?;";
        jdbcTemplate.update(sql, place_name, place_info, place_id);
    }

    public void deletePlace(int place_id) {
        String sql = "delete from place where place_id = ?;";
        jdbcTemplate.update(sql, place_id);
    }

    public List<place> readPlaceAll() {
        String sql = "select place_id, place_name, place_info from place;";
        List<place> placeList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new place(rs.getInt("place_id"), rs.getString("place_name"),
                        rs.getString("place_info")));
        return placeList;
    }

    public place readPlace(int place_id) {
        String sql = "select place_id, place_name, place_info from place where place_id = ?;";
        place place = jdbcTemplate.queryForObject(sql, place.class, place_id);
        return place;
    }

    public void createPlace(String place_name, String place_info) {
        String sql = "insert into place (place_name, place_info) values (?, ?);";
        jdbcTemplate.update(sql, place_name, place_info);
    }

    public void updateShipping(int shipping_id, int transfer_status_id, int destination_id, String shipping_date, int order_id) {
        String sql = "update shipping set transfer_status_id = ?, destination_id = ?, shipping_date = ?, order_id = ? where shipping_id = ?;";
        jdbcTemplate.update(sql, transfer_status_id, destination_id, shipping_date, order_id, shipping_id);
    }

    public void deleteShipping(int shipping_id) {
        String sql = "delete from shipping where shipping_id = ?;";
        jdbcTemplate.update(sql, shipping_id);
    }

    public List<shipping> readShippingAll() {
        String sql = "select shipping_id, transfer_status_id, destination_id, shipping_date, order_id from shipping;";
        List<shipping> shippingList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new shipping(rs.getInt("shipping_id"), rs.getInt("transfer_status_id"),
                        rs.getInt("destination_id"), rs.getString("shipping_date"), rs.getInt("order_id")));
        return shippingList;
    }

    public shipping readShipping(int shipping_id) {
        String sql = "select shipping_id, transfer_status_id, destination_id, shipping_date, order_id from shipping where shipping_id = ?;";
        shipping shipping = jdbcTemplate.queryForObject(sql, shipping.class, shipping_id);
        return shipping;
    }

    public void createShipping(int transfer_status_id, int destination_id, String shipping_date, int order_id) {
        String sql = "insert into shipping (transfer_status_id, destination_id, shipping_date, order_id) values (?, ?, ?, ?);";
        jdbcTemplate.update(sql, transfer_status_id, destination_id, shipping_date, order_id);
    }

    public void updateShippingLog(int log_id, int shipping_id, int place_id, int status_id, String time) {
        String sql = "update shipping_log set shipping_id = ?, place_id = ?, status_id = ?, time = ? where log_id = ?;";
        jdbcTemplate.update(sql, shipping_id, place_id, status_id, time, log_id);
    }

    public void deleteShippingLog(int log_id) {
        String sql = "delete from shipping_log where log_id = ?;";
        jdbcTemplate.update(sql, log_id);
    }

    public List<shipping_log> readShippingLogAll() {
        String sql = "select log_id, shipping_id, place_id, status_id, time from shipping_log;";
        List<shipping_log> shippingLogList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new shipping_log(rs.getInt("log_id"), rs.getInt("shipping_id"),
                        rs.getInt("place_id"), rs.getInt("status_id"), rs.getString("time")));
        return shippingLogList;
    }

    public shipping_log readShippingLog(int log_id) {
        String sql = "select log_id, shipping_id, place_id, status_id, time from shipping_log where log_id = ?;";
        shipping_log shippingLog = jdbcTemplate.queryForObject(sql, shipping_log.class, log_id);
        return shippingLog;
    }

    public void createShippingLog(int shipping_id, int place_id, int status_id, String time) {
        String sql = "insert into shipping_log (shipping_id, place_id, status_id, time) values (?, ?, ?, ?);";
        jdbcTemplate.update(sql, shipping_id, place_id, status_id, time);
    }

    public void updateTransferStatus(int status_id, String status) {
        String sql = "update transfer_status set status = ? where status_id = ?;";
        jdbcTemplate.update(sql, status, status_id);
    }

    public void deleteTransferStatus(int status_id) {
        String sql = "delete from transfer_status where status_id = ?;";
        jdbcTemplate.update(sql, status_id);
    }

    public List<transfer_status> readTransferStatusAll() {
        String sql = "select status_id, status from transfer_status;";
        List<transfer_status> transferStatusList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new transfer_status(rs.getInt("status_id"), rs.getString("status")));
        return transferStatusList;
    }

    public transfer_status readTransferStatus(int status_id) {
        String sql = "select status_id, status from transfer_status where status_id = ?;";
        transfer_status transferStatus = jdbcTemplate.queryForObject(sql, transfer_status.class, status_id);
        return transferStatus;
    }

    public void createTransferStatus(String status) {
        String sql = "insert into transfer_status (status) values (?);";
        jdbcTemplate.update(sql, status);
    }


}
