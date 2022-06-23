package com.it355pz.IT355PZV2.controller;

import com.it355pz.IT355PZV2.domain.Log;
import com.it355pz.IT355PZV2.service.LogService;
import java.util.List;
// import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/logs")
    public List getLogs() {
        return logService.list();
    }

    @PostMapping(value = "/logs", consumes = { "application/xml", "application/json" })
    @Transactional
    public ResponseEntity createLog(@RequestBody Log log) {
        // Board board = boardService.find(boardID);
        // Set<Log> boardLogs = board.getLogs();
        // boardLogs.add(log);
        // boardService.update(board);
        logService.add(log);

        return new ResponseEntity(log, HttpStatus.OK);
    }
}
