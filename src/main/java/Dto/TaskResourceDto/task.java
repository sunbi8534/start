package Dto.TaskResourceDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class task {
    int task_id;
    String task_name;
    String task_description;
    String start_date;
    String end_date;
}
