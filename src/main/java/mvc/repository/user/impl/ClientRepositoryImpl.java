package mvc.repository.user.impl;

import mvc.entity.user.Client;
import mvc.repository.user.ClientRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void create(Client client) {
        manager.persist(client);
    }

    @Override
    public Client read(int id) {
        Client client = manager.find(Client.class, id);
        if (!client.getOrders().isEmpty())
            Hibernate.initialize(client.getOrders());
        return client;
    }

    @Override
    public void update(Client client) {
        manager.merge(client);
    }

    @Override
    public void delete(int id) {
        Client client = manager.find(Client.class, id);
        manager.remove(client);
    }

    @Override
    public Client read(String email) {
        Client client = manager.createQuery("from Client c where c.email = :email", Client.class)
                .setParameter("email", email)
                .getSingleResult();
        if (!client.getOrders().isEmpty())
            Hibernate.initialize(client.getOrders());
        return client;
    }
}
