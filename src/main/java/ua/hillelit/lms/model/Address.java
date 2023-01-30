package ua.hillelit.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * {@link Address}
 *
 * @author Dmytro Trotsenko on 1/25/23
 */

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(schema = "my_store")
public class Address {

    @Id
    private Integer id;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String house;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Client client;

}
