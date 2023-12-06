package Dto.shippingDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class shipping {
    int shipping_id;
    int transfer_status_id;
    int destination_id;
    String shipping_date;
    int order_id;
}
