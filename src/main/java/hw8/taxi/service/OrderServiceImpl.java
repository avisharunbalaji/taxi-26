package hw8.taxi.service;

import hw8.taxi.repository.OrderRepository;
import hw8.taxi.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yar on 3/18/14.
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository repository;

    public OrderServiceImpl() {
    }

    @Override
    public void addNewOrder(Order order) {
        repository.save(order);
    }

    @Override
    public Iterable<Order> getAllOrders() {
        return repository.findAll();
    }
}
