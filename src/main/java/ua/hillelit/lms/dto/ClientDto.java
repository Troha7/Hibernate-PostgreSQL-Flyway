package ua.hillelit.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@link ClientDto}
 *
 * @author Dmytro Trotsenko on 1/25/23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private Integer id;

    private String name;

    private String email;

    private String phone;


}
