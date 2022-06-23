package com.it355pz.IT355PZV2.service;

import com.it355pz.IT355PZV2.dao.OutcomeDao;
import com.it355pz.IT355PZV2.domain.Outcome;
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
    public List<Outcome> list() {
//        List<Outcome> allOutcomes = dao.findAll();
//        List<Outcome> userOutcomes = new ArrayList<>();
//        System.out.println("userId: " + userID);
//        System.out.println("allOutcomes: " + allOutcomes.toString());
//        for (Outcome b : allOutcomes) {
//            Set<User> outcomeUsers = b.getUsers();
//            for (User u : outcomeUsers) {
//                if(u.getId() == userID) {
//                    userOutcomes.add(b);
//                }
//            }
//        }
        return dao.findAll();
    }

    @Override
    public Outcome findByName(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Outcome find(int outcomeID) {
        return dao.findById(outcomeID);
    }
    
}
