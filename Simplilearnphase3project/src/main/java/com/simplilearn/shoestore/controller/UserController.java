package com.simplilearn.shoestore.controller;

import com.simplilearn.shoestore.exception.RecordNotFoundException;
import com.simplilearn.shoestore.model.ShAdmin;
import com.simplilearn.shoestore.model.User;
import com.simplilearn.shoestore.service.AdminService;
import com.simplilearn.shoestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    UserService service;
 
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        List<User> list = service.getAllUsers();
 
        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
    }

}