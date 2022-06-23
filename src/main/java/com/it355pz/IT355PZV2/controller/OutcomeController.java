package com.it355pz.IT355PZV2.controller;

import com.it355pz.IT355PZV2.domain.Outcome;
import com.it355pz.IT355PZV2.service.OutcomeService;
import java.util.List;
// import java.util.Set;
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
    public List getOutcomes() {
        return outcomeService.list();
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
        // Board board = boardService.find(boardID);
        // Set<Outcome> boardOutcomes = board.getOutcomes();
        // boardOutcomes.add(outcome);
        // boardService.update(board);
        outcomeService.add(outcome);

        return new ResponseEntity(outcome, HttpStatus.OK);
    }

    @DeleteMapping(value = "/outcomes/{id}")
    public ResponseEntity deleteOutcome(@PathVariable int id) {

        if (outcomeService.find(id) != null) {
            // Board board = boardService.find(boardId);
            // if (board != null) {
            // Set<Outcome> boardOutcomes = board.getOutcomes();
            // for (Outcome t : boardOutcomes) {
            // if (t.getId().equals(outcomeId)) {
            // boardOutcomes.remove(t);
            // break;
            // }
            // }
            // board.setOutcomes(boardOutcomes);
            // boardService.update(board);

            // outcomeService.remove(outcomeId);
            // return new ResponseEntity(outcomeId, HttpStatus.OK);
            // } else {
            // return new ResponseEntity("No Board found for ID " + boardId,
            // HttpStatus.NOT_FOUND);
            // }
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
