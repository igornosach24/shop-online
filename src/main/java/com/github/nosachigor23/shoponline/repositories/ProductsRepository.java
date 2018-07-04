package com.github.nosachigor23.shoponline.repositories;

import com.github.nosachigor23.shoponline.model.AProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<AProductEntity, Integer> {

	/*

      The database is accessed through this implementation of the interface "CrudRepository", which is part of the Spring Data.

      All products are subclasses of the abstract class "AProductEntity", and CRUD operations are conducted through
      "AProductEntity" class.

	 */

}
