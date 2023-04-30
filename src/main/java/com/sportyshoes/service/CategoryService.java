package com.sportyshoes.service;

import com.sportyshoes.model.Category;
import com.sportyshoes.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public String storeCategory(Category category) {
        categoryRepository.save(category);
        return "Category stored successfully!";
    }

    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}
