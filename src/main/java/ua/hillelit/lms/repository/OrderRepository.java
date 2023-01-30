package ua.hillelit.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.hillelit.lms.model.Order;

/**
 * {@link OrderRepository}
 *
 * @author Dmytro Trotsenko on 1/28/23
 */

@Repository
public interface OrderRepository extends CrudRepository<Order,Integer> {
}
