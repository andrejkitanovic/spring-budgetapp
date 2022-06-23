package com.budgetapp.budgetapp.controller;

import com.budgetapp.budgetapp.domain.Income;
import com.budgetapp.budgetapp.service.IncomeService;
import java.util.List;
// import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class IncomeController {

    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/incomes")
    public List getIncomes() {
        return incomeService.list();
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
    public ResponseEntity createIncome(@RequestBody Income income) {
        // Board board = boardService.find(boardID);
        // Set<Income> boardIncomes = board.getIncomes();
        // boardIncomes.add(income);
        // boardService.update(board);
        incomeService.add(income);

        return new ResponseEntity(income, HttpStatus.OK);
    }

    @DeleteMapping(value = "/incomes/{id}")
    public ResponseEntity deleteIncome(@PathVariable int id) {

        if (incomeService.find(id) != null) {
            // Board board = boardService.find(boardId);
            // if (board != null) {
            // Set<Income> boardIncomes = board.getIncomes();
            // for (Income t : boardIncomes) {
            // if (t.getId().equals(incomeId)) {
            // boardIncomes.remove(t);
            // break;
            // }
            // }
            // board.setIncomes(boardIncomes);
            // boardService.update(board);

            // incomeService.remove(incomeId);
            // return new ResponseEntity(incomeId, HttpStatus.OK);
            // } else {
            // return new ResponseEntity("No Board found for ID " + boardId,
            // HttpStatus.NOT_FOUND);
            // }
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
