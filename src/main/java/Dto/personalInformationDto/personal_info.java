package Dto.personalInformationDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class personal_info {
    int personal_info_id;
    String phone_number;
    String address;
    int age;
}
