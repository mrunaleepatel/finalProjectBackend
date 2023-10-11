package com.ecom.backendecommerce.controller;

import com.ecom.backendecommerce.exceptions.NoProductExistInRepository;
import com.ecom.backendecommerce.models.Product;
import com.ecom.backendecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/check")
    public String check() {
        return "Working...!";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        try {
            return new ResponseEntity<List<Product>>(productService.getAll(), HttpStatus.OK);
        } catch (NoProductExistInRepository e){
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Product> add1(@RequestBody Product product) throws IOException {
        Product user=productService.add1(product);
        return new ResponseEntity<Product>(user, HttpStatus.OK);
    }

    @GetMapping("/get/by/pid/{pid}")
    public ResponseEntity<Product> getByID(@PathVariable Long pid){
        try {
            return new ResponseEntity<Product>(productService.getByID(pid), HttpStatus.OK);
        } catch (NoProductExistInRepository e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
}
