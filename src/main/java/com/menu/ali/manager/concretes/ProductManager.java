package com.menu.ali.manager.concretes;
import com.menu.ali.Model.Product;
import com.menu.ali.Model.User;
import com.menu.ali.core.results.*;
import com.menu.ali.manager.abstracts.ProductService;
import com.menu.ali.repositroy.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductManager implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Result add(Product product) {
        productRepository.save(product);
        return new SuccessResult("product added.");
    }

    @Override
    public Result update(Product product) {
        productRepository.save(product);
        return new SuccessResult("product added.");
    }

    @Override
    public Result delete(int id) {
        productRepository.deleteById(id);
        return new SuccessResult("silindi");
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<>(productRepository.findAll());
    }

    @Override
    public DataResult<Product> getById(int id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return new SuccessDataResult<Product>(product, "Kullanıcı bulundu");
        } else {
            return new ErrorDataResult<Product>("Kullanıcı bulunamadı");
        }

    }
}
