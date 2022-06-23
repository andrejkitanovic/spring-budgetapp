package com.budgetapp.budgetapp.service;

import com.budgetapp.budgetapp.domain.Outcome;
import java.util.List;

public interface OutcomeService {
    
    void add(Outcome income);

    void update(Outcome income);

    void remove(int incomeID);

    List<Outcome> list();

    Outcome findByName(String username);

    Outcome find(int incomeID);
}
