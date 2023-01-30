package ua.hillelit.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@link OrderItemDto}
 *
 * @author Dmytro Trotsenko on 1/28/23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {

    private Integer id;

    private ProductDto product;

    private Integer count;

}
