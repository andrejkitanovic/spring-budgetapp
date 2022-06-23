package com.budgetapp.budgetapp.dao;

import com.budgetapp.budgetapp.domain.Outcome;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OutcomeDaoImpl extends HibernateDao<Outcome, Integer> implements OutcomeDao {

    @Autowired
    public OutcomeDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, Outcome.class);
    }
}
