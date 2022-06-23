package com.budgetapp.budgetapp.service;

import com.budgetapp.budgetapp.dao.OutcomeDao;
import com.budgetapp.budgetapp.domain.User;
import com.budgetapp.budgetapp.domain.Outcome;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutcomeServiceImpl implements OutcomeService {

    @Autowired
    private OutcomeDao dao;

    @Override
    public void add(Outcome outcome) {
        dao.insert(outcome);
    }

    @Override
    public void update(Outcome outcome) {
        dao.update(outcome);
    }

    @Override
    public void remove(int outcomeID) {
        dao.delete(outcomeID);
    }

    @Override
    public List<Outcome> list(Integer userID) {
        List<Outcome> allOutcomes = dao.findAll();
        List<Outcome> userOutcomes = new ArrayList<>();

        for (Outcome outcome : allOutcomes) {
            User user = outcome.getUser();

            if (user.getId() == userID) {
                userOutcomes.add(outcome);
            }

        }
        return userOutcomes;
    }

    @Override
    public Outcome findByName(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public Outcome find(int outcomeID) {
        return dao.findById(outcomeID);
    }

}
