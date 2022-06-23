package com.budgetapp.budgetapp.controller;

import com.budgetapp.budgetapp.domain.Outcome;
import com.budgetapp.budgetapp.service.OutcomeService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class OutcomeController {

    private final OutcomeService outcomeService;

    public OutcomeController(OutcomeService outcomeService) {
        this.outcomeService = outcomeService;
    }

    @GetMapping("/outcomes")
    public List getOutcomes(@RequestHeader("user") int userID) {
        return outcomeService.list(userID);
    }

    @GetMapping("/outcomes/{id}")
    public ResponseEntity<Outcome> getOutcome(@PathVariable("id") int id) {
        Outcome outcome = outcomeService.find(id);

        if (outcome == null) {
            return new ResponseEntity("No Outcome found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(outcome, HttpStatus.OK);
    }

    @PostMapping(value = "/outcomes", consumes = { "application/xml", "application/json" })
    @Transactional
    public ResponseEntity createOutcome(@RequestBody Outcome outcome) {
        outcomeService.add(outcome);

        return new ResponseEntity(outcome, HttpStatus.OK);
    }

    @DeleteMapping(value = "/outcomes/{id}")
    public ResponseEntity deleteOutcome(@PathVariable int id) {
        Outcome outcome = outcomeService.find(id);

        if (outcome != null) {
            outcomeService.remove(id);
            return new ResponseEntity(id, HttpStatus.OK);
        }

        return new ResponseEntity("No Outcome found for ID " + id, HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/outcomes/{id}", consumes = { "application/xml",
            "application/json" })
    @Transactional
    public ResponseEntity updateOutcome(@PathVariable int id, @RequestBody Outcome outcome) {
        Outcome newOutcome = outcomeService.find(id);

        if (null == newOutcome) {
            return new ResponseEntity("No Outcome found for ID " + id,
                    HttpStatus.NOT_FOUND);
        }

        newOutcome.setValue(outcome.getValue());
        newOutcome.setDescription(outcome.getDescription());
        newOutcome.setDate(outcome.getDate());
        outcomeService.update(newOutcome);
        return new ResponseEntity(newOutcome, HttpStatus.OK);
    }
}
