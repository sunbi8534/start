package Dto.productDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class category {
    int category_id;
    String category_name;
    int parent_category_id;
}
