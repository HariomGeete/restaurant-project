package com.example.restaurant.restaurant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "rest1")
@Data
public class rest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int samosa;
    int burger;
    int dosa;
    int idali;
    int badamshake;
    int bananashake;
    int colddrink;
    int mirinda;
}
