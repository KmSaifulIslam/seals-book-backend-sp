package org.example.sealsbookbackendsp.service;

import org.example.sealsbookbackendsp.model.Category;
import org.example.sealsbookbackendsp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Create or Update a Category
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Get a Category by ID
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    // Get all Categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Delete a Category by ID
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
