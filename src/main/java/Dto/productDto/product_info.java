package Dto.productDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class product_info {
    int product_id;
    String description;
    int supplier_id;
    int location_id;
    int quantity;
}
