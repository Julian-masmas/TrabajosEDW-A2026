package com.epw.activities.product.service;

import com.epw.activities.product.dto.CreateProductRequest;
import com.epw.activities.product.dto.ProductResponse;
import com.epw.activities.product.dto.UpdateProductRequest;

import java.util.List;

public interface ProductService {
    ProductResponse create(CreateProductRequest request);

    List<ProductResponse> list();

    ProductResponse getById(Long id);

    ProductResponse update(Long id, UpdateProductRequest request);

    void delete(Long id);
}
