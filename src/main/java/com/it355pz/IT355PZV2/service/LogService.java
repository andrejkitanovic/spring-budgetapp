package com.it355pz.IT355PZV2.service;

import com.it355pz.IT355PZV2.domain.Log;
import java.util.List;

public interface LogService {
    
    void add(Log log);

    void update(Log log);

    void remove(int logID);

    List<Log> list();

    Log findByName(String username);

    Log find(int logID);
}
