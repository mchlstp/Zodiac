package com.tts.ecom.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.ecom.Models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
    Product findById(long id);
    List<Product> findBySign(String sign);
    List<Product> findByCategory(String category);
    List<Product> findBySignAndCategory(String sign, String category);

    @Query("SELECT DISTINCT p.sign FROM Product p")
    List<String> findDistinctSign();

    @Query("SELECT DISTINCT p.category FROM Product p")
    List<String> findDistinctCategories();
}
