package com.marcelocbasilio.ecommerce.repositories;

import com.marcelocbasilio.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
