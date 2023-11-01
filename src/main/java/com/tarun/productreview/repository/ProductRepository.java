package com.tarun.productreview.repository;

import com.tarun.productreview.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findAllByProductName(String productName);

    public List<Product> findAllByProductBrand(String productBrand);

    public Product findByProductCode(String productCode);

    public Product findByProductId(Long productId);
}
