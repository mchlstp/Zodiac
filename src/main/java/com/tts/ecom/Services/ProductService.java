package com.tts.ecom.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.ecom.Models.Product;
import com.tts.ecom.Repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = null;

        if(optionalProduct.isPresent()){
         product = optionalProduct.get();
         return product;
        }else {
         return product;
        }
     }

    public List<String> findDistinctSign() {
        return productRepository.findDistinctSign();
    }

    public List<String> findDistinctCategories() {
        return productRepository.findDistinctCategories();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findBySignAndOrCategory(String sign, String category) {
        if(category == null && sign == null)
            return productRepository.findAll();
        else if(category == null)
            return productRepository.findBySign(sign);
        else if(sign == null)
            return  productRepository.findByCategory(category);
        else
            return productRepository.findBySignAndCategory(sign, category);
    }
}