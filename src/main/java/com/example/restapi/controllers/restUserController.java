package com.example.restapi.controllers;

import com.example.restapi.entities.user;
import com.example.restapi.exceptionsPackage.noSuchUserException;
import com.example.restapi.services.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class restUserController {

    @Autowired
    private service service;

    @GetMapping(path = "/users")
    public List<user> getAllUsers(){
        List<user> resultList = service.findAllUsers();

        return resultList;
    }

    @GetMapping(path = "/users/{userid}")
    public user getUserById(@PathVariable(name = "userid") Long userId) {
        user user = service.findById(userId);

        if (user == null)
            throw new noSuchUserException("can`t find user with id = " + userId);

        return user;
    }

    @PostMapping(path = "/users")
    public user saveNewUser(@RequestBody user user){
        service.saveNewUser(user);

        return user;
    }

    @PutMapping(path = "/users")
    public user updateUser(@RequestBody user user){
        service.saveChangesUser(user);

        return user;
    }

    @DeleteMapping(path = "/users/{id}")
    public String deleteUser(@PathVariable(name = "id") Long userToDeleteId){
        user user = service.findById(userToDeleteId);

        if (user == null)
            throw new noSuchUserException("can`t find user with id = " + userToDeleteId);

        service.deleteUser(userToDeleteId);

        return "user with id = " + userToDeleteId + " was deleted";
    }
}
