package com.example.restaurant.admin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "admin")
@Data
public class admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String aemail;
    String apassword;
}
