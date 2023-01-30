package ua.hillelit.lms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * {@link Client}
 *
 * @author Dmytro Trotsenko on 1/25/23
 */

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(schema = "my_store")
public class Client {

    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address_id")
    private Address address;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> ordersHistory;

}
