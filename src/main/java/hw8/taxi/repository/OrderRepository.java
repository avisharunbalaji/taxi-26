package hw8.taxi.repository;

import hw8.taxi.domain.Order;
import org.springframework.data.repository.CrudRepository;



public interface OrderRepository extends CrudRepository<Order, Long>{
}
