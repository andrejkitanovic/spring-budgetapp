package com.it355pz.IT355PZV2.dao;

import com.it355pz.IT355PZV2.domain.Income;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IncomeDaoImpl extends HibernateDao<Income, Integer> implements IncomeDao {

    @Autowired
    public IncomeDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, Income.class);
    }
}
