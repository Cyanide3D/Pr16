package com.example.Pr16.dao;

import com.example.Pr16.models.Bank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class BankDao {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    public void init() {
        this.session = sessionFactory.openSession();
    }

    public void save(Bank bank) {
        session.saveOrUpdate(bank);
    }

    public void delete(Long id) {
        Transaction transaction = session.beginTransaction();

        session.createQuery("delete from Bank where id=:id")
                .setParameter("id", id)
                .executeUpdate();

        transaction.commit();
    }

    public List<Bank> getAllBanks() {
        return session.createQuery("from Bank", Bank.class)
                .getResultList();
    }

}
