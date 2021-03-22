package com.simplilearn.shoestore.repository;

import com.simplilearn.shoestore.model.Orders;
import com.simplilearn.shoestore.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository
        extends CrudRepository<Orders, Integer> {

    List<Orders> findByOrderByOrderedonDesc();


}