package com.github.nosachigor23.shopOnline.services;

import com.github.nosachigor23.shopOnline.exceptions.ProductNotFoundException;
import com.github.nosachigor23.shopOnline.model.AProductEntity;
import com.github.nosachigor23.shopOnline.repositories.ProductsRepository;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class ProductService {

    private ProductsRepository repository;

    @Autowired
    public ProductService(ProductsRepository repository) {
        this.repository = repository;
    }

    public List<AProductEntity> getAllProducts() {
        return repository.findAll();
    }


    public AProductEntity getProductById(int id) {
        AProductEntity entity = repository.findOne(id);
        if (entity != null) {
            return entity;
        } else {
            throw new ProductNotFoundException(String.format("User with [%s] id doesn't exist", id));
        }
    }

    public void deleteProductById(int id) {
        if (repository.exists(id)) {
            repository.delete(id);
        } else {
            throw new ProductNotFoundException(String.format("User with [%s] id doesn't exist", id));
        }
    }

    private int calcualateDyscontForProduct(){
        return 0;
    }

    public void saveOrUpdateProduct(AProductEntity aProductEntity) {

    }
}
