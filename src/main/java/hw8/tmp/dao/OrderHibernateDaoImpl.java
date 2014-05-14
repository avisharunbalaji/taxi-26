package hw8.tmp.dao;

import hw8.taxi.domain.Order;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yar on 3/18/14.
 */
@Repository
public class OrderHibernateDaoImpl implements OrderDao {
    private static Logger log = Logger.getLogger(OrderHibernateDaoImpl.class);

    @Autowired
    private SessionFactory factory;

    public OrderHibernateDaoImpl() {
    }

    @Override
    public void create(Order order) {

        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Order read(Long id) {
        return null;
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void delete(Order order) {

    }

    @Override
    public List<Order> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from Order");
        return query.list();
    }
}
