package com.marcelocbasilio.ecommerce.dto;

import com.marcelocbasilio.ecommerce.entities.User;

public class ClientDTO {

    private final Long id;
    private final String name;

    public ClientDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClientDTO(User user) {
        id = user.getId();
        name = user.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
