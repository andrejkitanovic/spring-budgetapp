package com.budgetapp.budgetapp.dao;

import com.budgetapp.budgetapp.domain.Log;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LogDaoImpl extends HibernateDao<Log, Integer> implements LogDao {

    @Autowired
    public LogDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, Log.class);
    }
}
