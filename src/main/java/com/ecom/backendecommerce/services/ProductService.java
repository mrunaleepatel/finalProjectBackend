package com.ecom.backendecommerce.services;

import com.ecom.backendecommerce.exceptions.NoProductExistInRepository;
import com.ecom.backendecommerce.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll() throws NoProductExistInRepository;

    Product getById(Long pid) throws NoProductExistInRepository;

    Product add1(Product product);

    void deleteProduct(Long pid) throws NoProductExistInRepository;

    Product updateProduct(Long pid, Product product) throws NoProductExistInRepository;


}
