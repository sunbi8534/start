package Dto.orderDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class order {
    int order_id;
    int customer_id;
    String order_date;
    int total_payment;
}
