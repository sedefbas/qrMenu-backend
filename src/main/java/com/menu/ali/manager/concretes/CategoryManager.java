package com.menu.ali.manager.concretes;

import com.menu.ali.Model.Category;
import com.menu.ali.Model.User;
import com.menu.ali.core.results.*;
import com.menu.ali.manager.abstracts.CategoryService;
import com.menu.ali.repositroy.CategoryRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;

     @Autowired
    public CategoryManager(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Result add(Category category) {
        categoryRepository.save(category);
        return new SuccessResult("category added.");
    }

    @Override
    public Result update(Category category) {
        categoryRepository.save(category);
        return new SuccessResult("category added.");
    }

    @Override
    public Result delete(int id) {
        categoryRepository.deleteById(id);
        return new SuccessResult("silindi");
    }

    @Override
    public DataResult<List<Category>> getAll() {
        return new SuccessDataResult<>(categoryRepository.findAll());
    }

    @Override
    public DataResult<Category> getById(int id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            return new SuccessDataResult<Category>(category, "Kullanıcı bulundu");
        } else {
            return new ErrorDataResult<Category>("Kullanıcı bulunamadı");
        }
    }
}
