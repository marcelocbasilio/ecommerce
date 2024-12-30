package com.marcelocbasilio.ecommerce.repositories;

import com.marcelocbasilio.ecommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product>  searchByName(String name, Pageable pageable);
}
