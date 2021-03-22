package com.simplilearn.shoestore.repository;

import com.simplilearn.shoestore.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository
        extends CrudRepository<Product, Integer> {

    List<Product> findByBrand(String name);
    List<Product> findByColor(String color);
    List<Product> findByCategory(String category);
    List<Product> findByOrderByPriceAsc();
    List<Product> findByOrderByPriceDesc();
    List<Product> findByOrderByLastupdatedDesc();
    List<Product> findBySeason(String season);
}