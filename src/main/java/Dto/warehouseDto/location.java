package Dto.warehouseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class location {
    int location_id;
    String location_name;
    int warehouse_id;
}
