package com.ecom.backendecommerce.services;

import com.ecom.backendecommerce.exceptions.NoProductExistInRepository;
import com.ecom.backendecommerce.models.Product;
import com.ecom.backendecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() throws NoProductExistInRepository {
        List<Product> all = productRepository.findAll();

        if (all.isEmpty()) {
            throw new NoProductExistInRepository();
        } else {
            return all;
        }
    }

    @Override
    public Product getById(Long pid) throws NoProductExistInRepository {
        Optional<Product> product = productRepository.findById(pid);
        if(product.isEmpty()){
            throw new NoProductExistInRepository();
        }else{
            return product.get();
        }
    }

    @Override
    public Product add1(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long pid) throws NoProductExistInRepository {
        Optional<Product> product = productRepository.findById(pid);
        if(product.isEmpty()){
            throw new NoProductExistInRepository();
        }else{
            productRepository.delete(product.get());
        }
    }

    @Override
    public Product updateProduct(Long pid, Product product) throws NoProductExistInRepository {
        Optional<Product> product1 = productRepository.findById(pid);
        if(product1.isEmpty()){
            throw new NoProductExistInRepository();
        }else{
            product.setPid(pid);
            return productRepository.save(product);
        }
    }


}
