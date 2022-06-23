package com.it355pz.IT355PZV2.service;

import com.it355pz.IT355PZV2.dao.UserDao;
import com.it355pz.IT355PZV2.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao dao;

    @Override
    public void add(User user) {
        dao.insert(user);
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public void remove(int userID) {
        dao.delete(userID);
    }

    @Override
    public List<User> list() {
        return dao.findAll();
    }

    @Override
    public User findByEmail(String email) {
        if(dao.findByEmail(email) != null) {
            return dao.findByEmail(email);
        }
        return null;
    }

    @Override
    public User find(int userID) {
        return dao.findById(userID);
    }
}
