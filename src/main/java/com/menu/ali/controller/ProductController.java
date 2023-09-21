package com.menu.ali.controller;

import com.menu.ali.Model.Category;
import com.menu.ali.Model.Product;
import com.menu.ali.core.results.DataResult;
import com.menu.ali.core.results.Result;
import com.menu.ali.manager.abstracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    private ProductService productService;

     @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return productService.add(product);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Product product) {
        return productService.update(product);
    }

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll() {
        return productService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Product> getById(@RequestParam int id) {
        return productService.getById(id);
    }

    @DeleteMapping("/delete")
    public void deleteCategory(@RequestParam int id) {
        productService.delete(id);
    }

}
