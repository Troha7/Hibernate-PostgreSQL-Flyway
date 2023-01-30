package ua.hillelit.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * {@link Order}
 *
 * @author Dmytro Trotsenko on 1/25/23
 */

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(schema = "my_store")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "fk_client_id")
    @JsonIgnore
    private Client client;

}
