package com.menu.ali.controller;

import com.menu.ali.Model.Category;
import com.menu.ali.Model.User;
import com.menu.ali.core.results.DataResult;
import com.menu.ali.core.results.Result;
import com.menu.ali.core.results.SuccessResult;
import com.menu.ali.manager.abstracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    private CategoryService categoryService;
     @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Category category) {
        return categoryService.add(category);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @GetMapping("/getAll")
    public DataResult<List<Category>> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Category> getById(@RequestParam int id) {
        return categoryService.getById(id);
    }

    @DeleteMapping("/delete")
    public void deleteCategory(@RequestParam int id) {
          categoryService.delete(id);
    }

}
