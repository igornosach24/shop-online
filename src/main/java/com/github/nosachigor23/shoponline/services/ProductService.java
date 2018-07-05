package com.github.nosachigor23.shoponline.services;

import com.github.nosachigor23.shoponline.model.AProductEntity;

import java.util.List;

public interface ProductService {
    List<AProductEntity> getAllProducts();

    AProductEntity getProductById(int id);

    void deleteProductById(int id);

    void saveOrUpdateProduct(AProductEntity aProductEntity);
}
