package ua.hillelit.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@link AddressDto}
 *
 * @author Dmytro Trotsenko on 1/25/23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Integer id;

    private String country;

    private String city;

    private String street;

    private String house;

}
