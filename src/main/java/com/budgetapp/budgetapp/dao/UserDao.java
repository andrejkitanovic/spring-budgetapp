package com.budgetapp.budgetapp.dao;

import com.budgetapp.budgetapp.domain.User;

public interface UserDao extends Dao<User, Integer> {
    User findByEmail(String email);
}
