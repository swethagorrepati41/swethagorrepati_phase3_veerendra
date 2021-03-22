package com.simplilearn.shoestore.service;

import com.simplilearn.shoestore.exception.RecordNotFoundException;
import com.simplilearn.shoestore.model.Product;
import com.simplilearn.shoestore.model.ShAdmin;
import com.simplilearn.shoestore.repository.ProductRepository;
import com.simplilearn.shoestore.repository.ShAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
     
    @Autowired
    ProductRepository repository;
     
    public Iterable<Product> getAllShoes()
    {
        Iterable<Product> shoesList = repository.findAll();
         
        if(shoesList!=null) {
            return shoesList;
        } else {
            return new ArrayList<Product>();
        }
    }
     
    public Product getProductById(Integer id) throws RecordNotFoundException
    {
        Optional<Product> shoe = repository.findById(id);
         
        if(shoe.isPresent()) {
            return shoe.get();
        } else {
            throw new RecordNotFoundException("No record exist for given id");
        }
    }

    public List<Product> getProductByBrand(String brand) throws RecordNotFoundException
    {
        List<Product> shoes = repository.findByBrand(brand);

        if(shoes.size()>0) {
            return shoes;
        } else {
            throw new RecordNotFoundException("No record exist for given brand");
        }
    }

    public List<Product> getProductByColor(String color) throws RecordNotFoundException
    {
        List<Product> shoes = repository.findByColor(color);

        if(shoes.size()>0) {
            return shoes;
        } else {
            throw new RecordNotFoundException("No record exist for given color");
        }
    }
    public List<Product> getProductByPrice(String order) throws RecordNotFoundException
    {
        List<Product> shoes = null;
        if(order.equalsIgnoreCase("asc"))
            shoes = repository.findByOrderByPriceAsc();

        if(order.equalsIgnoreCase("desc"))
            shoes = repository.findByOrderByPriceDesc();

        if(shoes.size() >0) {
            return shoes;
        } else {
            throw new RecordNotFoundException("No record exist for given Price");
        }
    }

    public List<Product> getProductByCategory(String category) throws RecordNotFoundException
    {
        List<Product> shoes = repository.findByCategory(category);

        if(shoes.size()>0) {
            return shoes;
        } else {
            throw new RecordNotFoundException("No record exist for given Category");
        }
    }
    public List<Product> getProductByLatestUpdated() throws RecordNotFoundException
    {
        List<Product> shoes = repository.findByOrderByLastupdatedDesc();

        if(shoes.size()>0) {
            return shoes;
        } else {
            throw new RecordNotFoundException("No record exist for latest date");
        }
    }
    public List<Product> getProductBySeason(String season) throws RecordNotFoundException
    {
        List<Product> shoes = repository.findBySeason(season);

        if(shoes.size()>0) {
            return shoes;
        } else {
            throw new RecordNotFoundException("No record exist for given season");
        }
    }

    public Product addOrUpdateProduct(Integer id , Product product) throws RecordNotFoundException
    {
        Optional<Product> admin = repository.findById(id);

        if(admin.isPresent())
        {
            Product newEntity = admin.get();
            newEntity.setId(product.getId());
            newEntity.setShoe_name(product.getShoe_name());
            newEntity.setSeason(product.getSeason());
            newEntity.setPrice(product.getPrice());
            newEntity.setColor(product.getColor());
            newEntity.setCategory(product.getCategory());
            newEntity.setBrand(product.getBrand());
            newEntity.setLastupdated(new Date());
            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            Product productAdded = repository.save(product);
            return productAdded;
        }
    }

    public void deleteProduct(Integer id) throws RecordNotFoundException
    {
        Optional<Product> admin = repository.findById(id);

        if(admin.isPresent())
        {
           repository.delete(admin.get());

        }
    }

}