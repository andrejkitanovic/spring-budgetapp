package com.it355pz.IT355PZV2.dao;

import com.it355pz.IT355PZV2.domain.User;

public interface UserDao extends Dao<User, Integer> {
    User findByEmail(String email);
}
