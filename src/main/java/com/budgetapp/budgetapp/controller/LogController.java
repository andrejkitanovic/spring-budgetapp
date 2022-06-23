package com.budgetapp.budgetapp.controller;

import com.budgetapp.budgetapp.service.LogService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/logs")
    public List getLogs(@RequestHeader("user") int userID) {
        return logService.list(userID);
    }
}
