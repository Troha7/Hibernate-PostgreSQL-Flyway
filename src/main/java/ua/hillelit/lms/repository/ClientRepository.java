package ua.hillelit.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.hillelit.lms.model.Client;

import java.util.List;

/**
 * {@link ClientRepository}
 *
 * @author Dmytro Trotsenko on 1/25/23
 */

@Repository
public interface ClientRepository extends CrudRepository<Client,Integer> {
    List<Client> findClientById(Integer id);
}
