package ua.hillelit.lms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@link ClientInfoDto}
 *
 * @author Dmytro Trotsenko on 1/25/23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientInfoDto {

    private Integer id;

    private String name;

    private String email;

    private String phone;

    private AddressDto address;

}
