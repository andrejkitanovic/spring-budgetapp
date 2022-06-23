package com.budgetapp.budgetapp.dao;

import com.budgetapp.budgetapp.domain.User;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends HibernateDao<User, Integer> implements UserDao {
    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

    @Override
    public User findByEmail(String email) {
        List<User> allUsers = findAll();
        User foundUser = null;
        
        for(User u : allUsers) {
            if(u.getEmail().equals(email)) {
                foundUser = u;
                foundUser.setId(u.getId());
            }
        }
            
        return foundUser;
    }
}
