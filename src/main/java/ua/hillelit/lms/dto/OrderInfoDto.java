package ua.hillelit.lms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@link OrderInfoDto}
 *
 * @author Dmytro Trotsenko on 1/28/23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderInfoDto {

    private Integer id;

}
