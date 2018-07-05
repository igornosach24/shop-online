package com.github.nosachigor23.shoponline.repositories;

import com.github.nosachigor23.shoponline.model.PurchaseCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CheckRepository extends JpaRepository<PurchaseCheck, Integer> {

	/*

	The database is accessed through this implementation of the interface "CrudRepository", which is part of the Spring Data.
	The database stores information about purchases.

	 */

}
