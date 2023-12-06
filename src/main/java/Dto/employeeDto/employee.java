package Dto.employeeDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class employee {
    int employee_id;
    String name;
    int role_id;
    int department_id;
    int team_id;
    int personal_info;
}
