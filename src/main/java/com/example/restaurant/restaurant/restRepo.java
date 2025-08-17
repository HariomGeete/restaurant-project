package com.example.restaurant.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface restRepo extends JpaRepository<rest, Integer> {

    
    
}
