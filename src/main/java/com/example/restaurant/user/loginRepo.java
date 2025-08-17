package com.example.restaurant.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface loginRepo extends JpaRepository<login,Integer>{

    
    
}