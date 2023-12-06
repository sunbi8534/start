package logistic;

import Dto.personalInformationDto.account;
import Dto.personalInformationDto.account_authority;
import Dto.personalInformationDto.personal_info;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonalInformation {
    JdbcTemplate jdbcTemplate;

    public PersonalInformation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateAccount(int customer_id, String password, int account_authority_id) {
        String sql = "update account set password = ?, account_authority_id = ? where customer_id = ?;";
        jdbcTemplate.update(sql, password, account_authority_id, customer_id);
    }

    public void deleteAccount(int customer_id) {
        String sql = "delete from account where customer_id = ?;";
        jdbcTemplate.update(sql, customer_id);
    }

    public List<account> readAccountAll() {
        String sql = "select customer_id, password, account_authority_id from account;";
        List<account> accountList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new account(rs.getInt("customer_id"), rs.getString("password"),
                        rs.getInt("account_authority_id")));
        return accountList;
    }

    public account readAccount(int customer_id) {
        String sql = "select customer_id, password, account_authority_id from account where customer_id = ?;";
        account account = jdbcTemplate.queryForObject(sql, account.class, customer_id);
        return account;
    }

    public void createAccount(int customer_id, String password, int account_authority_id) {
        String sql = "insert into account (customer_id, password, account_authority_id) values (?, ?, ?);";
        jdbcTemplate.update(sql, customer_id, password, account_authority_id);
    }

    public void updateAccountAuthority(int account_authority_id, String authority_name) {
        String sql = "update account_authority set authority_name = ? where account_authority_id = ?;";
        jdbcTemplate.update(sql, authority_name, account_authority_id);
    }

    public void deleteAccountAuthority(int account_authority_id) {
        String sql = "delete from account_authority where account_authority_id = ?;";
        jdbcTemplate.update(sql, account_authority_id);
    }

    public List<account_authority> readAccountAuthorityAll() {
        String sql = "select account_authority_id, authority_name from account_authority;";
        List<account_authority> accountAuthorityList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new account_authority(rs.getInt("account_authority_id"), rs.getString("authority_name")));
        return accountAuthorityList;
    }

    public account_authority readAccountAuthority(int account_authority_id) {
        String sql = "select account_authority_id, authority_name from account_authority where account_authority_id = ?;";
        account_authority accountAuthority = jdbcTemplate.queryForObject(sql, account_authority.class, account_authority_id);
        return accountAuthority;
    }

    public void createAccountAuthority(String authority_name) {
        String sql = "insert into account_authority (authority_name) values (?);";
        jdbcTemplate.update(sql, authority_name);
    }

    public void updatePersonalInfo(int personal_info_id, String phone_number, String address, int age) {
        String sql = "update personal_info set phone_number = ?, address = ?, age = ? where personal_info_id = ?;";
        jdbcTemplate.update(sql, phone_number, address, age, personal_info_id);
    }

    public void deletePersonalInfo(int personal_info_id) {
        String sql = "delete from personal_info where personal_info_id = ?;";
        jdbcTemplate.update(sql, personal_info_id);
    }

    public List<personal_info> readPersonalInfoAll() {
        String sql = "select personal_info_id, phone_number, address, age from personal_info;";
        List<personal_info> personalInfoList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new personal_info(rs.getInt("personal_info_id"), rs.getString("phone_number"),
                        rs.getString("address"), rs.getInt("age")));
        return personalInfoList;
    }

    public personal_info readPersonalInfo(int personal_info_id) {
        String sql = "select personal_info_id, phone_number, address, age from personal_info where personal_info_id = ?;";
        personal_info personalInfo = jdbcTemplate.queryForObject(sql, personal_info.class, personal_info_id);
        return personalInfo;
    }

    public void createPersonalInfo(String phone_number, String address, int age) {
        String sql = "insert into personal_info (phone_number, address, age) values (?, ?, ?);";
        jdbcTemplate.update(sql, phone_number, address, age);
    }
}
