package Dto.orderDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class order_item {
    int order_item_id;
    int order_id;
    int product_id;
    int order_quantity;
}
