package com.budgetapp.budgetapp.service;

import com.budgetapp.budgetapp.domain.User;
import java.util.List;

public interface UserService {

    void add(User user);

    void update(User user);

    void remove(int userID);

    List<User> list();

    User findByEmail(String email);

    User find(int userID);
}
