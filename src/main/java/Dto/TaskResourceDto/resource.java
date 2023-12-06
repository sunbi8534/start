package Dto.TaskResourceDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class resource {
    int resource_id;
    String resource_name;
    int quantity;
    int location_id;
}
