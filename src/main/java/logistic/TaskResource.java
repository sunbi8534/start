package logistic;

import org.springframework.jdbc.core.JdbcTemplate;
import Dto.TaskResourceDto.resource;
import Dto.TaskResourceDto.resource_allocation;
import Dto.TaskResourceDto.task;
import Dto.TaskResourceDto.task_assignment;
import Dto.TaskResourceDto.vehicle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskResource {
    JdbcTemplate jdbcTemplate;

    public TaskResource(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateResource(int resource_id, String resource_name, int quantity, int location_id) {
        String sql = "update resource set resource_name = ?, quantity = ?, location_id = ? where resource_id = ?;";
        jdbcTemplate.update(sql, resource_name, quantity, location_id, resource_id);
    }

    public void deleteResource(int resource_id) {
        String sql = "delete from resource where resource_id = ?;";
        jdbcTemplate.update(sql, resource_id);
    }

    public List<resource> readResourceAll() {
        String sql = "select resource_id, resource_name, quantity, location_id from resource;";
        List<resource> resourceList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new resource(rs.getInt("resource_id"), rs.getString("resource_name"),
                        rs.getInt("quantity"), rs.getInt("location_id")));
        return resourceList;
    }

    public resource readResource(int resource_id) {
        String sql = "select resource_id, resource_name, quantity, location_id from resource where resource_id = ?;";
        resource resource = jdbcTemplate.queryForObject(sql, resource.class, resource_id);
        return resource;
    }

    public void createResource(String resource_name, int quantity, int location_id) {
        String sql = "insert into resource (resource_name, quantity, location_id) values (?, ?, ?);";
        jdbcTemplate.update(sql, resource_name, quantity, location_id);
    }

    public void updateResourceAllocation(int allocation_id, int task_id, int resource_id) {
        String sql = "update resource_allocation set task_id = ?, resource_id = ? where allocation_id = ?;";
        jdbcTemplate.update(sql, task_id, resource_id, allocation_id);
    }

    public void deleteResourceAllocation(int allocation_id) {
        String sql = "delete from resource_allocation where allocation_id = ?;";
        jdbcTemplate.update(sql, allocation_id);
    }

    public List<resource_allocation> readResourceAllocationAll() {
        String sql = "select allocation_id, task_id, resource_id from resource_allocation;";
        List<resource_allocation> resourceAllocationList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new resource_allocation(rs.getInt("allocation_id"), rs.getInt("task_id"), rs.getInt("resource_id")));
        return resourceAllocationList;
    }

    public resource_allocation readResourceAllocation(int allocation_id) {
        String sql = "select allocation_id, task_id, resource_id from resource_allocation where allocation_id = ?;";
        resource_allocation resourceAllocation = jdbcTemplate.queryForObject(sql, resource_allocation.class, allocation_id);
        return resourceAllocation;
    }

    public void createResourceAllocation(int task_id, int resource_id) {
        String sql = "insert into resource_allocation (task_id, resource_id) values (?, ?);";
        jdbcTemplate.update(sql, task_id, resource_id);
    }

    public void updateTask(int task_id, String task_name, String task_description, String start_date, String end_date) {
        String sql = "update task set task_name = ?, task_description = ?, start_date = ?, end_date = ? where task_id = ?;";
        jdbcTemplate.update(sql, task_name, task_description, start_date, end_date, task_id);
    }

    public void deleteTask(int task_id) {
        String sql = "delete from task where task_id = ?;";
        jdbcTemplate.update(sql, task_id);
    }

    public List<task> readTaskAll() {
        String sql = "select task_id, task_name, task_description, start_date, end_date from task;";
        List<task> taskList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new task(rs.getInt("task_id"), rs.getString("task_name"),
                        rs.getString("task_description"), rs.getString("start_date"), rs.getString("end_date")));
        return taskList;
    }

    public task readTask(int task_id) {
        String sql = "select task_id, task_name, task_description, start_date, end_date from task where task_id = ?;";
        task t = jdbcTemplate.queryForObject(sql, task.class, task_id);
        return t;
    }

    public void createTask(String task_name, String task_description, String start_date, String end_date) {
        String sql = "insert into task (task_name, task_description, start_date, end_date) values (?, ?, ?, ?);";
        jdbcTemplate.update(sql, task_name, task_description, start_date, end_date);
    }

    public void updateTaskAssignment(int employee_id, int task_id) {
        String sql = "update task_assignment set task_id = ? where employee_id = ?;";
        jdbcTemplate.update(sql, task_id, employee_id);
    }

    public void deleteTaskAssignment(int employee_id) {
        String sql = "delete from task_assignment where employee_id = ?;";
        jdbcTemplate.update(sql, employee_id);
    }

    public List<task_assignment> readTaskAssignmentAll() {
        String sql = "select employee_id, task_id from task_assignment;";
        List<task_assignment> taskAssignmentList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new task_assignment(rs.getInt("employee_id"), rs.getInt("task_id")));
        return taskAssignmentList;
    }

    public task_assignment readTaskAssignment(int employee_id) {
        String sql = "select employee_id, task_id from task_assignment where employee_id = ?;";
        task_assignment taskAssignment = jdbcTemplate.queryForObject(sql, task_assignment.class, employee_id);
        return taskAssignment;
    }

    public void createTaskAssignment(int employee_id, int task_id) {
        String sql = "insert into task_assignment (employee_id, task_id) values (?, ?);";
        jdbcTemplate.update(sql, employee_id, task_id);
    }

    public void updateVehicle(int vehicle_id, String car_model, int employee_id) {
        String sql = "update vehicle set car_model = ?, employee_id = ? where vehicle_id = ?;";
        jdbcTemplate.update(sql, car_model, employee_id, vehicle_id);
    }

    public void deleteVehicle(int vehicle_id) {
        String sql = "delete from vehicle where vehicle_id = ?;";
        jdbcTemplate.update(sql, vehicle_id);
    }

    public List<vehicle> readVehicleAll() {
        String sql = "select vehicle_id, car_model, employee_id from vehicle;";
        List<vehicle> vehicleList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new vehicle(rs.getInt("vehicle_id"), rs.getString("car_model"), rs.getInt("employee_id")));
        return vehicleList;
    }

    public vehicle readVehicle(int vehicle_id) {
        String sql = "select vehicle_id, car_model, employee_id from vehicle where vehicle_id = ?;";
        vehicle v = jdbcTemplate.queryForObject(sql, vehicle.class, vehicle_id);
        return v;
    }

    public void createVehicle(String car_model, int employee_id) {
        String sql = "insert into vehicle (car_model, employee_id) values (?, ?);";
        jdbcTemplate.update(sql, car_model, employee_id);
    }
}
