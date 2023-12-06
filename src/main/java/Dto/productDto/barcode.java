package Dto.productDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class barcode {
    int barcode_id;
    String barcode;
    int product_id;
}
