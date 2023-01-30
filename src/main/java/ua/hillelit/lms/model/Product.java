package ua.hillelit.lms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * {@link Product}
 *
 * @author Dmytro Trotsenko on 1/25/23
 */

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(schema = "my_store")
public class Product {

    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Double price;

}
