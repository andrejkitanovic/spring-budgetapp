package com.budgetapp.budgetapp.controller;

import com.budgetapp.budgetapp.domain.User;
import com.budgetapp.budgetapp.service.UserService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List getUsers() {
        return userService.list();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        User user = userService.find(id);
        if (user == null) {
            return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PostMapping(value = "/users/register", consumes = {"application/xml", "application/json"})
    @Transactional
    public ResponseEntity register(@RequestBody User user) {
        User foundUser = userService.findByEmail(user.getEmail());
        
        if (foundUser == null) {
            userService.add(user);
            return new ResponseEntity(user, HttpStatus.OK);
        } else {
            return new ResponseEntity("Email taken " + user.getEmail(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "/users/login", consumes = {"application/xml", "application/json"})
    @Transactional
    public ResponseEntity login(@RequestBody User user) {
        User foundUser = userService.findByEmail(user.getEmail());
        
        if (foundUser == null) {
            return new ResponseEntity("User not found ", HttpStatus.NOT_FOUND);
        } else {
            if(foundUser.getPassword().equals(user.getPassword())) {
                return new ResponseEntity(foundUser, HttpStatus.OK);
            } else {
                return new ResponseEntity("Incorrect password ", HttpStatus.UNAUTHORIZED);
            }
        }
    }
    
    @PutMapping(value = "/users/me", consumes = {"application/xml", "application/json"})
    @Transactional
    public ResponseEntity updateUser(@RequestHeader("user-id") int userID, @RequestBody User user) {
        User newUser = userService.find(userID);

        if (null == newUser) {
            return new ResponseEntity("No User found for ID " + userID, HttpStatus.NOT_FOUND);
        }
        
        newUser.setPassword(user.getPassword());
        return new ResponseEntity(newUser, HttpStatus.OK);
    }
}
