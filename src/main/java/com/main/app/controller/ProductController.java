package com.main.app.controller;

import com.main.app.entity.Product;
import com.main.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping(value = "/product", params = "sort")
    public ResponseEntity<Page<Product>> getAllProduct(
            @RequestParam("sort") @Nullable String sort, @PageableDefault(size = 5) Pageable pageable) {
        return ResponseEntity.ok(productService.getAllProduct(sort, pageable));
    }
}
