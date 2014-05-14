package hw8.taxi.service;

import hw8.taxi.repository.ClientRepository;
import hw8.taxi.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yar on 3/18/14.
 */
@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository repository;

    public ClientServiceImpl() {
    }

    @Override
    public void addNewUser(Client user) {
        repository.save(user);
    }

    @Override
    public Iterable<Client> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Client getByName(String name) {
        List<Client> clist = repository.findByName(name);
        if (clist.size()>0){
            return clist.get(0);
        }
        return null;
    }
}
