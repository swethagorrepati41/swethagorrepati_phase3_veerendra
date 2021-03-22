package com.simplilearn.shoestore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.shoestore.exception.RecordNotFoundException;
import com.simplilearn.shoestore.model.ShAdmin;
import com.simplilearn.shoestore.repository.ShAdminRepository;

@Service
public class AdminService {
     
    @Autowired
    ShAdminRepository repository;
     
    public List<ShAdmin> getAllAdmins()
    {
        List<ShAdmin> adminList = repository.findAll();
         
        if(adminList.size() > 0) {
            return adminList;
        } else {
            return new ArrayList<ShAdmin>();
        }
    }
     
    public ShAdmin getAdminById(Long id) throws RecordNotFoundException
    {
        Optional<ShAdmin> admin = repository.findById(id);
         
        if(admin.isPresent()) {
            return admin.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public ShAdmin createOrUpdateAdmin(Long id , String  newPassword) throws RecordNotFoundException
    {
        Optional<ShAdmin> admin = repository.findById(id);
         
        if(admin.isPresent())
        {
            ShAdmin newEntity = admin.get();
            newEntity.setPwd(newPassword);
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            throw new RecordNotFoundException("No Admin available");
        }
    }
  
}