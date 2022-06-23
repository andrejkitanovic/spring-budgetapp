package com.budgetapp.budgetapp.service;

import com.budgetapp.budgetapp.dao.IncomeDao;
import com.budgetapp.budgetapp.domain.Income;
import com.budgetapp.budgetapp.domain.User;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeDao dao;

    @Override
    public void add(Income income) {
        dao.insert(income);
    }

    @Override
    public void update(Income income) {
        dao.update(income);
    }

    @Override
    public void remove(int incomeID) {
        dao.delete(incomeID);
    }

    @Override
    public List<Income> list(Integer userID) {
        List<Income> allIncomes = dao.findAll();
        List<Income> userIncomes = new ArrayList<>();

        for (Income income : allIncomes) {
            User user = income.getUser();

            if (user.getId() == userID) {
                userIncomes.add(income);
            }

        }
        return userIncomes;
    }

    @Override
    public Income findByName(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public Income find(int incomeID) {
        return dao.findById(incomeID);
    }

}
