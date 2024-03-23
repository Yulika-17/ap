package com.example.ap.service;

import com.example.ap.dto.ProductDTO;
import com.example.ap.entity.Product;
import com.example.ap.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final CategoryService categoryService;
    public Product create(ProductDTO dto) {
        Product product = Product.builder()
                .name(dto.getName())
                .amount(dto.getAmount())
                .category(categoryService.readById(dto.getCategoryId()))
                .build();
        return productRepository.save(product);
    }

    public List<Product> readAll() {
        return productRepository.findAll();
    }

    public List<Product> readByCategoryId(Long id) {
        return productRepository.findByCategoryId(id);
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
