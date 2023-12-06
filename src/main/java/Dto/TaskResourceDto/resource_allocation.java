package Dto.TaskResourceDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class resource_allocation {
    int allocation_id;
    int task_id;
    int resource_id;
}
