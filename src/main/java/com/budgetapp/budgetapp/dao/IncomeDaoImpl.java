package com.budgetapp.budgetapp.dao;

import com.budgetapp.budgetapp.domain.Income;
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
