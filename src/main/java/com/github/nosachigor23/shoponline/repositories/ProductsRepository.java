package com.github.nosachigor23.shoponline.repositories;
import com.github.nosachigor23.shoponline.model.AProductEntity;
import com.github.nosachigor23.shoponline.model.ProductType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ProductsRepository extends CrudRepository<AProductEntity,Integer> {

    List<AProductEntity> findByType(String type);


}
