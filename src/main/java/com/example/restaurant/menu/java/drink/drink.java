package com.example.restaurant.menu.java.drink;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "drinks")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String drinkname;
    String drinkprize;

    @Lob
    byte[] drinkimage;
    @Transient
    String base64Image;

}
