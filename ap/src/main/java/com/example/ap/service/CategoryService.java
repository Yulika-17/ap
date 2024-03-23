package com.example.ap.service;

import com.example.ap.entity.Category;
import com.example.ap.entity.Product;
import com.example.ap.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> readAll() {
        return categoryRepository.findAll();
    }

    public Category readById(Long id) {

        return categoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Category not found" + id));
    }
}
