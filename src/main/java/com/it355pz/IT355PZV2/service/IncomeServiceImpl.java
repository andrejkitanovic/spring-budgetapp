package com.it355pz.IT355PZV2.service;

import com.it355pz.IT355PZV2.dao.IncomeDao;
import com.it355pz.IT355PZV2.domain.Income;
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
    public List<Income> list() {
//        List<Income> allIncomes = dao.findAll();
//        List<Income> userIncomes = new ArrayList<>();
//        System.out.println("userId: " + userID);
//        System.out.println("allIncomes: " + allIncomes.toString());
//        for (Income b : allIncomes) {
//            Set<User> incomeUsers = b.getUsers();
//            for (User u : incomeUsers) {
//                if(u.getId() == userID) {
//                    userIncomes.add(b);
//                }
//            }
//        }
        return dao.findAll();
    }

    @Override
    public Income findByName(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Income find(int incomeID) {
        return dao.findById(incomeID);
    }
    
}
