package com.it355pz.IT355PZV2.service;

import com.it355pz.IT355PZV2.domain.Income;
import java.util.List;

public interface IncomeService {
    
    void add(Income income);

    void update(Income income);

    void remove(int incomeID);

    List<Income> list();

    Income findByName(String username);

    Income find(int incomeID);
}
