package com.marcelocbasilio.ecommerce.services;

import com.marcelocbasilio.ecommerce.dto.ProductDTO;
import com.marcelocbasilio.ecommerce.entities.Product;
import com.marcelocbasilio.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product entity = productRepository.findById(id).get();
        return new ProductDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream().map(x -> new ProductDTO(x)).toList();
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        entity.setName(dto.getName());
        entity = productRepository.save(entity);
        return new ProductDTO(entity);
    }

}
