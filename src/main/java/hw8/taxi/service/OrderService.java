package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;

import java.util.List;

/**
 * Created by yar on 3/18/14.
 */
public interface OrderService {
        Iterable<Order> getAllOrders();
        void addNewOrder(Order order);
}

