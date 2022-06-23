package com.budgetapp.budgetapp.service;

import com.budgetapp.budgetapp.domain.Log;
import java.util.List;

public interface LogService {
    
    void add(Log log);

    void update(Log log);

    void remove(int logID);

    List<Log> list();

    Log findByName(String username);

    Log find(int logID);
}
