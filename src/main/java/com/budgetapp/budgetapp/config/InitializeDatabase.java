package com.budgetapp.budgetapp.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitializeDatabase {

    public InitializeDatabase() {
    }

    @PostConstruct
    public void initialize() {
    }
}
