package com.simplilearn.shoestore.repository;

import com.simplilearn.shoestore.model.ShAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShAdminRepository
        extends JpaRepository<ShAdmin, Long> {
 
}
