package com.budgetapp.budgetapp.service;

import com.budgetapp.budgetapp.dao.LogDao;
import com.budgetapp.budgetapp.domain.Log;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    
    @Autowired
    private LogDao dao;

    @Override
    public void add(Log income) {
        dao.insert(income);
    }

    @Override
    public void update(Log income) {
        dao.update(income);
    }

    @Override
    public void remove(int incomeID) {
        dao.delete(incomeID);
    }

    @Override
    public List<Log> list() {
//        List<Log> allLogs = dao.findAll();
//        List<Log> userLogs = new ArrayList<>();
//        System.out.println("userId: " + userID);
//        System.out.println("allLogs: " + allLogs.toString());
//        for (Log b : allLogs) {
//            Set<User> incomeUsers = b.getUsers();
//            for (User u : incomeUsers) {
//                if(u.getId() == userID) {
//                    userLogs.add(b);
//                }
//            }
//        }
        return dao.findAll();
    }

    @Override
    public Log findByName(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Log find(int incomeID) {
        return dao.findById(incomeID);
    }
    
}
