package com.simplilearn.shoestore.controller;

import com.simplilearn.shoestore.exception.RecordNotFoundException;
import com.simplilearn.shoestore.model.Orders;
import com.simplilearn.shoestore.model.Product;
import com.simplilearn.shoestore.service.OrdersService;
import com.simplilearn.shoestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersService service;

    @GetMapping("/all")
    public ResponseEntity<Iterable<Orders>> getAll() {
        Iterable<Orders> list = service.getAllOrders();
        return new ResponseEntity<Iterable<Orders>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/latest")
    public ResponseEntity<Iterable<Orders>> getOrdersByDate() {
        Iterable<Orders> list = service.getOrdersByDate();
        return new ResponseEntity<Iterable<Orders>>(list, new HttpHeaders(), HttpStatus.OK);
    }

   }
