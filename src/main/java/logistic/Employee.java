package logistic;

import org.springframework.jdbc.core.JdbcTemplate;
import Dto.employeeDto.department;
import Dto.employeeDto.employee;
import Dto.employeeDto.role;
import Dto.employeeDto.saraly;
import Dto.employeeDto.team;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Employee {
    JdbcTemplate jdbcTemplate;

    public Employee(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateDepartment(int department_id, String department_name) {
        String sql = "update department set department_name = ? where department_id = ?;";
        jdbcTemplate.update(sql, department_name, department_id);
    }

    public void deleteDepartment(int department_id) {
        String sql = "delete from department where department_id = ?;";
        jdbcTemplate.update(sql, department_id);
    }

    public List<department> readDepartmentAll() {
        String sql = "select department_id, department_name from department;";
        List<department> departmentList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new department(rs.getInt("department_id"), rs.getString("department_name")));
        return departmentList;
    }

    public department readDepartment(int department_id) {
        String sql = "select department_id, department_name from department where department_id = ?;";
        department d = jdbcTemplate.queryForObject(sql, department.class, department_id);
        return d;
    }

    public void createDepartment(String department_name) {
        String sql = "insert into department (department_name) values (?);";
        jdbcTemplate.update(sql, department_name);
    }

    public void updateEmployee(int employee_id, String name, int role_id, int department_id, int team_id, int personal_info_id) {
        String sql = "update employee set name = ?, role_id = ?, department_id = ?, team_id = ?, personal_info_id = ? where employee_id = ?;";
        jdbcTemplate.update(sql, name, role_id, department_id, team_id, personal_info_id, employee_id);
    }

    public void deleteEmployee(int employee_id) {
        String sql = "delete from employee where employee_id = ?;";
        jdbcTemplate.update(sql, employee_id);
    }

    public List<employee> readEmployeeAll() {
        String sql = "select employee_id, name, role_id, department_id, team_id, personal_info_id from employee;";
        List<employee> employeeList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new employee(rs.getInt("employee_id"), rs.getString("name"),
                        rs.getInt("role_id"), rs.getInt("department_id"),
                        rs.getInt("team_id"), rs.getInt("personal_info_id")));
        return employeeList;
    }

    public employee readEmployee(int employee_id) {
        String sql = "select employee_id, name, role_id, department_id, team_id, personal_info_id from employee where employee_id = ?;";
        employee employee = jdbcTemplate.queryForObject(sql, employee.class, employee_id);
        return employee;
    }

    public void createEmployee(String name, int role_id, int department_id, int team_id, int personal_info_id) {
        String sql = "insert into employee (name, role_id, department_id, team_id, personal_info_id) values (?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, name, role_id, department_id, team_id, personal_info_id);
    }

    public void updateRole(int role_id, String role_name) {
        String sql = "update role set role_name = ? where role_id = ?;";
        jdbcTemplate.update(sql, role_name, role_id);
    }

    public void deleteRole(int role_id) {
        String sql = "delete from role where role_id = ?;";
        jdbcTemplate.update(sql, role_id);
    }

    public List<role> readRoleAll() {
        String sql = "select role_id, role_name from role;";
        List<role> roleList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new role(rs.getInt("role_id"), rs.getString("role_name")));
        return roleList;
    }

    public role readRole(int role_id) {
        String sql = "select role_id, role_name from role where role_id = ?;";
        role role = jdbcTemplate.queryForObject(sql, role.class, role_id);
        return role;
    }

    public void createRole(String role_name) {
        String sql = "insert into role (role_name) values (?);";
        jdbcTemplate.update(sql, role_name);
    }

    public void updateSalary(int employee_id, int salary_amount) {
        String sql = "update salary set salary_amount = ? where employee_id = ?;";
        jdbcTemplate.update(sql, salary_amount, employee_id);
    }

    public void deleteSalary(int employee_id) {
        String sql = "delete from salary where employee_id = ?;";
        jdbcTemplate.update(sql, employee_id);
    }

    public List<saraly> readSalaryAll() {
        String sql = "select employee_id, salary_amount from salary;";
        List<saraly> salaryList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new saraly(rs.getInt("employee_id"), rs.getInt("salary_amount")));
        return salaryList;
    }

    public saraly readSalary(int employee_id) {
        String sql = "select employee_id, salary_amount from salary where employee_id = ?;";
        saraly salary = jdbcTemplate.queryForObject(sql, saraly.class, employee_id);
        return salary;
    }

    public void createSalary(int employee_id, int salary_amount) {
        String sql = "insert into salary (employee_id, salary_amount) values (?, ?);";
        jdbcTemplate.update(sql, employee_id, salary_amount);
    }

    public void updateTeam(int team_id, int department_id, String team_name) {
        String sql = "update team set department_id = ?, team_name = ? where team_id = ?;";
        jdbcTemplate.update(sql, department_id, team_name, team_id);
    }

    public void deleteTeam(int team_id) {
        String sql = "delete from team where team_id = ?;";
        jdbcTemplate.update(sql, team_id);
    }

    public List<team> readTeamAll() {
        String sql = "select team_id, department_id, team_name from team;";
        List<team> teamList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new team(rs.getInt("team_id"), rs.getInt("department_id"), rs.getString("team_name")));
        return teamList;
    }

    public team readTeam(int team_id) {
        String sql = "select team_id, department_id, team_name from team where team_id = ?;";
        team team = jdbcTemplate.queryForObject(sql, team.class, team_id);
        return team;
    }

    public void createTeam(int department_id, String team_name) {
        String sql = "insert into team (department_id, team_name) values (?, ?);";
        jdbcTemplate.update(sql, department_id, team_name);
    }
}
