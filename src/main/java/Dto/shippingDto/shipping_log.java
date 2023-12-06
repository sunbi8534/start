package Dto.shippingDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class shipping_log {
    int log_id;
    int shipping_id;
    int place_id;
    int status_id;
    String time;
}
