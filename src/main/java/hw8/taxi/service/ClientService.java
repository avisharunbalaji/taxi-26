package hw8.taxi.service;

import hw8.taxi.domain.Client;

import java.util.List;

/**
 * Created by yar on 3/18/14.
 */
public interface ClientService {
        Iterable<Client> getAllUsers();
        void addNewUser(Client user);
        Client getByName(String name);
}

