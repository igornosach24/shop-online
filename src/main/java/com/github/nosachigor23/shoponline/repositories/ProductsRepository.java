package com.github.nosachigor23.shoponline.repositories;

import com.github.nosachigor23.shoponline.model.AProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ProductsRepository extends CrudRepository<AProductEntity, Integer> {

	/*

      The database is accessed through this implementation of the interface, which is part of the Spring Data.

      All products are heirs of the abstract class, and CRUD operations are conducted through "AProductEntity" class.

	 */

}
