package hw8.tmp.dao;

import hw8.taxi.domain.Client;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by yar on 3/18/14.
 */
@Repository
public class ClientHibernateDaoImpl implements ClientDao {
    private static Logger log = Logger.getLogger(ClientHibernateDaoImpl.class);

    @Autowired
    private SessionFactory factory;

    public ClientHibernateDaoImpl() {
    }

//    public ClientHibernateDaoImpl(SessionFactory factory) {
//        this.factory = factory;
//    }


    @Override
    public void create(Client client) {

        org.hibernate.Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Client read(Long id) {
        Session session = factory.openSession();
        Criteria crit = session.createCriteria(Client.class);
//        Query query = session.createQuery("from Client");
//        return query.list();
        crit.add(Restrictions.eq("id", id));
        return (Client) crit.uniqueResult();
    }

    @Override
    public void update(Client client) {
        org.hibernate.Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public void delete(Client client) {
        org.hibernate.Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Client> findAll() {
        Session session = factory.openSession();
        Criteria crit = session.createCriteria(Client.class);
//        Query query = session.createQuery("from Client");
//        return query.list();
        return crit.list();
    }

    @Override
    public List<Client> findByName(String name) {
        Session session = factory.openSession();
        Criteria crit = session.createCriteria(Client.class);
        crit.add(Restrictions.eq("name", name));
        //Query query = session.createQuery("from Client where name = :name");
        //query.setParameter("name", name);
        return crit.list();
    }
}
