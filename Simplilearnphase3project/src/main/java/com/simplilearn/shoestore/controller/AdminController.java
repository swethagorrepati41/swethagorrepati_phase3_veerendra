package com.simplilearn.shoestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.simplilearn.shoestore.exception.RecordNotFoundException;
import com.simplilearn.shoestore.model.ShAdmin;
import com.simplilearn.shoestore.service.AdminService;

import javax.validation.Valid;

@RestController
@RequestMapping("/admins")
public class AdminController
{
    @Autowired
    AdminService service;
 
    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<ShAdmin>> getAllAdmins() {
        List<ShAdmin> list = service.getAllAdmins();
 
        return new ResponseEntity<List<ShAdmin>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<ShAdmin> getAdminById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        ShAdmin entity = service.getAdminById(id);
 
        return new ResponseEntity<ShAdmin>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/changepassword/{id}")
    public ResponseEntity<ShAdmin> createOrUpdateAdmin(@PathVariable Long id , @Valid @RequestBody String newPassword)
                                                    throws RecordNotFoundException {
        ShAdmin updated = service.createOrUpdateAdmin(id, newPassword);
        return new ResponseEntity<ShAdmin>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
 
}