package ua.hillelit.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.hillelit.lms.model.Address;

/**
 * {@link AddressRepository}
 *
 * @author Dmytro Trotsenko on 1/26/23
 */

@Repository
public interface AddressRepository extends CrudRepository<Address,Integer> {

}
