package com.ecom.backendecommerce.services;

import com.ecom.backendecommerce.exceptions.NoProductExistInRepository;
import com.ecom.backendecommerce.exceptions.ProvideProperFileDetailException;
import com.ecom.backendecommerce.models.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> getAll() throws NoProductExistInRepository;
    Product getByID(Long pid) throws NoProductExistInRepository;
    Product add1(Product product) throws JsonProcessingException;
}
