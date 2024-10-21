package com.example.Products.Controller;

import com.example.Products.DTO.ProductDTO;
import com.example.Products.Domain.Product;
import com.example.Products.Repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping ("product")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @GetMapping
    public ResponseEntity GetAllProducts(){
        var getAll = repository.findAll();
        return ResponseEntity.ok(getAll);
    }

    @GetMapping ("/{id}")
    public  ResponseEntity FindByID(@PathVariable UUID id){
        Optional<Product> Exists = repository.findById(id);
        if (Exists.isPresent()){
            Exists.get();
            return ResponseEntity.ok(Exists);
        }else {
            return  ResponseEntity.notFound().build();
        }
    }

    @PostMapping ("/new")
    public  ResponseEntity AddProduct(@RequestBody @Valid ProductDTO data){
        Product add = new Product(data);
        repository.save(add);
        return  ResponseEntity.ok("Product added successfully");
    }

    @PutMapping ("/{id}")
    public  ResponseEntity UpdtProduct(@PathVariable UUID id, @RequestBody @Valid ProductDTO data){
        Optional<Product> Exists = repository.findById(id);
        if(Exists.isPresent()){

            Product product = Exists.get();
            product.setName(data.name());
            product.setPrice(data.price());
            product.setAvailable(data.available());
            repository.save(product);
            return  ResponseEntity.ok("Updated Successfully!");
        } else {
            return  ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity DeleteProduct(@PathVariable UUID id){
        Optional<Product> Exists = repository.findById(id);
        if (Exists.isPresent()){
            repository.deleteById(id);
            return  ResponseEntity.ok("Deleted Successfully");
        }
        else {
            return  ResponseEntity.notFound().build();
        }
    }
}
