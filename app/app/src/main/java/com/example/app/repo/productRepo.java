package com.example.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.buy.Product;

@Repository
public interface productRepo extends JpaRepository<Product,Long> {
	public Product getByName(String name);
	@Transactional
	@Query(value="SELECT setval(pg_get_serial_sequence('products','id'),(SELECT MAX(id) FROM products))",nativeQuery=true)
	void resetProductSequence();
}