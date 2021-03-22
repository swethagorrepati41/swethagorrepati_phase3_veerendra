package com.simplilearn.shoestore.controller;

import com.simplilearn.shoestore.exception.RecordNotFoundException;
import com.simplilearn.shoestore.model.Product;
import com.simplilearn.shoestore.model.User;
import com.simplilearn.shoestore.service.ProductService;
import com.simplilearn.shoestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoes")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/all")
    public ResponseEntity<Iterable<Product>> getAll() {
        Iterable<Product> list = service.getAllShoes();
        return new ResponseEntity<Iterable<Product>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> getProductByBrand(@PathVariable String brand) throws RecordNotFoundException {
        List<Product> list = service.getProductByBrand(brand);
        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<Product>> getProductByColor(@PathVariable String color) throws RecordNotFoundException {
        List<Product> list = service.getProductByColor(color);
        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/price/{order}")
    public ResponseEntity<List<Product>> getProductByPrice(@PathVariable String order) throws RecordNotFoundException {
        List<Product> list = service.getProductByPrice(order);
        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category) throws RecordNotFoundException {
        List<Product> list = service.getProductByCategory(category);
        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/latest")
    public ResponseEntity<List<Product>> getProductByLatestDate() throws RecordNotFoundException {
        List<Product> list = service.getProductByLatestUpdated();
        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/season/{season}")
    public ResponseEntity<List<Product>> getProductBySeason(@PathVariable String season) throws RecordNotFoundException {
        List<Product> list = service.getProductBySeason(season);
        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addOrUpdateProduct(@RequestBody Product product) throws RecordNotFoundException {
        Product list = service.addOrUpdateProduct(product.getId(),product);
        return new ResponseEntity<Product>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id) throws RecordNotFoundException {
        service.deleteProduct(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
