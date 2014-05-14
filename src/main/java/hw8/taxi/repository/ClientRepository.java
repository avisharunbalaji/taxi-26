package hw8.taxi.repository;

import hw8.taxi.domain.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
        List<Client> findByName(String name);
    }
