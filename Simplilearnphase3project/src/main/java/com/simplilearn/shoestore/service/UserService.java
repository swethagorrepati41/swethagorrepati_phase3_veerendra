package com.simplilearn.shoestore.service;

import com.simplilearn.shoestore.exception.RecordNotFoundException;
import com.simplilearn.shoestore.model.ShAdmin;
import com.simplilearn.shoestore.model.User;
import com.simplilearn.shoestore.repository.ShAdminRepository;
import com.simplilearn.shoestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
     
    @Autowired
    UserRepository repository;
     
    public List<User> getAllUsers()
    {
        List<User> allUsers = repository.findAll();

        if(allUsers.size() > 0) {
            return allUsers;
        } else {
            return new ArrayList<User>();
        }
    }
}