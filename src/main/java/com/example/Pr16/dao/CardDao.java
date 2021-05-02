package com.example.Pr16.dao;

import com.example.Pr16.models.Card;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class CardDao {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    public void init() {
        this.session = sessionFactory.openSession();
    }

    public void save(Card card) {
        session.saveOrUpdate(card);
    }

    public void delete(Long id) {
        Transaction transaction = session.beginTransaction();

        session.createQuery("delete from Card where id=:id")
                .setParameter("id", id)
                .executeUpdate();

        transaction.commit();
    }

    public List<Card> getAllCards() {
        return session.createQuery("from Card", Card.class)
                .getResultList();
    }

}
