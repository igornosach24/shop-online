package com.github.nosachigor23.shopOnline.repositories;

import com.github.nosachigor23.shopOnline.model.CheckProduct;
import org.springframework.data.repository.CrudRepository;

public interface CheckRepository extends CrudRepository<CheckProduct, Integer> {

	/*

	The database is accessed through this implementation of the interface "CrudRepository", which is part of the Spring Data.
	The database stores information about purchases.

	 */

}
