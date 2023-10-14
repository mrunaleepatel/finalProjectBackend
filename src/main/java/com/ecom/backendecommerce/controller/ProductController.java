package com.ecom.backendecommerce.controller;

import com.ecom.backendecommerce.exceptions.NoProductExistInRepository;
import com.ecom.backendecommerce.models.Product;
import com.ecom.backendecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/check")
    public String check(){
        return "Working...!";
    }

    @GetMapping("/all")
    public ResponseEntity getAll(){
        try{
            return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
        }catch (NoProductExistInRepository e){
            return new ResponseEntity("List Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Product> add1(@RequestBody Product product)  throws IOException {
        Product user=productService.add1(product);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/get/by/pid/{pid}")
    public ResponseEntity getById(@PathVariable Long pid){
        try {
            return new ResponseEntity<>(productService.getById(pid), HttpStatus.OK);
        }catch (NoProductExistInRepository e) {
            return new ResponseEntity("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{pid}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long pid) {
        try {
            productService.deleteProduct(pid);
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        } catch (NoProductExistInRepository e) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }
}
