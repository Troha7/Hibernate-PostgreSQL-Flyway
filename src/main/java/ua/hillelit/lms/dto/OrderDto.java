package ua.hillelit.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * {@link OrderDto}
 *
 * @author Dmytro Trotsenko on 1/28/23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Integer id;

    private List<OrderItemDto> orderItems;

}
