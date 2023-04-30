package com.sportyshoes.service;

import com.sportyshoes.model.Product;
import com.sportyshoes.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public String storeProduct(Product product) {
        productRepository.save(product);
        return "Product successfully stored!";
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public void decrementQuantity(int pid) {
        Optional<Product> result = productRepository.findById(pid);
        if(result.isPresent()) {
            Product p = result.get();
            p.setQuantity(p.getQuantity()-1);
            productRepository.saveAndFlush(p);
        }
    }

    public String deleteProduct(int pid) {
        Optional<Product> result = productRepository.findById(pid);
        if(result.isPresent()) {
            Product p = result.get();
            productRepository.delete(p);
            return "Product deleted successfully.";
        }else {
            return "Product is not present!";
        }
    }

}
