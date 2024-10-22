package com.example.Products.Domain;

import com.example.Products.DTO.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table (name="product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id @GeneratedValue (strategy = GenerationType.UUID)
    private UUID idProduct;
    private String name;
    private float price;
    private boolean available;


    public UUID getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Product(ProductDTO dto){
        this.name = dto.name();
        this.price = dto.price();
        this.available = dto.available();
    }
}
