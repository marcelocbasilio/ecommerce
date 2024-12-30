package com.marcelocbasilio.ecommerce.dto;

import com.marcelocbasilio.ecommerce.entities.Category;

public class CategoryDTO {

    private final Long id;
    private final String name;

    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDTO(Category category) {
        id = category.getId();
        name = category.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
