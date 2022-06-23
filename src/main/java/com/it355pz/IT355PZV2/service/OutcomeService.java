package com.it355pz.IT355PZV2.service;

import com.it355pz.IT355PZV2.domain.Outcome;
import java.util.List;

public interface OutcomeService {
    
    void add(Outcome income);

    void update(Outcome income);

    void remove(int incomeID);

    List<Outcome> list();

    Outcome findByName(String username);

    Outcome find(int incomeID);
}
