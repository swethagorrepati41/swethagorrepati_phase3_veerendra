package com.simplilearn.shoestore.repository;

import com.simplilearn.shoestore.model.ShAdmin;
import com.simplilearn.shoestore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
    extends JpaRepository<User, Long>{}

