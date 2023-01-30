package ua.hillelit.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * {@link ClientFullDto}
 *
 * @author Dmytro Trotsenko on 1/25/23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientFullDto {

    private Integer id;

    private String name;

    private String email;

    private String phone;

    private AddressDto address;

    private List<OrderDto> ordersHistory;

}
