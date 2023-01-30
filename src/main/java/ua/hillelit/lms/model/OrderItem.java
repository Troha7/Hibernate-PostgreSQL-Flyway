package ua.hillelit.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * {@link OrderItem}
 *
 * @author Dmytro Trotsenko on 1/25/23
 */

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(schema = "my_store")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_order_id")
    @JsonIgnore
    private Order order;

    @ManyToOne
    @JoinColumn(name = "fk_product_id")
    private Product product;

    @Column
    private Integer count;

}
