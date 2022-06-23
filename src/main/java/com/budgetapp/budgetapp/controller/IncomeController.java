package com.budgetapp.budgetapp.controller;

import com.budgetapp.budgetapp.domain.Income;
import com.budgetapp.budgetapp.domain.User;
import com.budgetapp.budgetapp.service.IncomeService;
import com.budgetapp.budgetapp.service.UserService;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class IncomeController {

    private final IncomeService incomeService;
    private final UserService userService;

    public IncomeController(IncomeService incomeService, UserService userService) {
        this.incomeService = incomeService;
        this.userService = userService;
    }

    @GetMapping("/incomes")
    public List getIncomes(@RequestHeader("user") int userID) {
        return incomeService.list(userID);
    }

    @GetMapping("/incomes/{id}")
    public ResponseEntity<Income> getIncome(@PathVariable("id") int id) {
        Income income = incomeService.find(id);
        if (income == null) {
            return new ResponseEntity("No Income found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(income, HttpStatus.OK);
    }

    @PostMapping(value = "/incomes", consumes = { "application/xml", "application/json" })
    @Transactional
    public ResponseEntity createIncome(@RequestBody Income income, @RequestHeader("user") int userID) {
        User user = userService.find(userID);
        income.setUser(user);
        incomeService.add(income);

        return new ResponseEntity(income, HttpStatus.OK);
    }

    @DeleteMapping(value = "/incomes/{id}")
    public ResponseEntity deleteIncome(@PathVariable int id) {
        Income income = incomeService.find(id);

        if (income != null) {
            incomeService.remove(id);
            return new ResponseEntity(id, HttpStatus.OK);
        }

        return new ResponseEntity("No Income found for ID " + id, HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/incomes/{id}", consumes = { "application/xml",
            "application/json" })
    @Transactional
    public ResponseEntity updateIncome(@PathVariable int id, @RequestBody Income income) {
        Income newIncome = incomeService.find(id);

        if (null == newIncome) {
            return new ResponseEntity("No Income found for ID " + id,
                    HttpStatus.NOT_FOUND);
        }

        newIncome.setValue(income.getValue());
        newIncome.setDescription(income.getDescription());
        newIncome.setDate(income.getDate());
        incomeService.update(newIncome);
        return new ResponseEntity(newIncome, HttpStatus.OK);
    }
}
