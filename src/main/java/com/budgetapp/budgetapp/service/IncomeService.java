package com.budgetapp.budgetapp.service;

import com.budgetapp.budgetapp.domain.Income;
import java.util.List;

public interface IncomeService {
    
    void add(Income income);

    void update(Income income);

    void remove(int incomeID);

    List<Income> list();

    Income findByName(String username);

    Income find(int incomeID);
}
