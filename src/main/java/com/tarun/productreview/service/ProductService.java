package com.tarun.productreview.service;

import com.tarun.productreview.entity.Product;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product);

    public List<Product> fetchProductList();

    public Product fetchProductById(Long productId);

    public List<Product> fetchAllByProductName(String productName);

    List<Product> fetchAllByProductBrand(String productBrand);

    Product fetchProductByCode(String productCode);
}
