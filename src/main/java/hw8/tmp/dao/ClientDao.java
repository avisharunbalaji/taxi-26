package hw8.tmp.dao;

import hw8.taxi.domain.Client;

import java.util.List;


/**
 * Created by yar on 3/17/14.
 */
public interface ClientDao {
    void create(Client client);
    Client read(Long id);
    void update(Client client);
    void delete(Client client);
    List<Client> findAll();
    List<Client> findByName(String name);
}
