package com.ecom.backendecommerce.services;

import com.ecom.backendecommerce.exceptions.NoProductExistInRepository;
import com.ecom.backendecommerce.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll() throws NoProductExistInRepository;
    Product add1(Product product);
    Product getByID(Long pid) throws NoProductExistInRepository;
}
