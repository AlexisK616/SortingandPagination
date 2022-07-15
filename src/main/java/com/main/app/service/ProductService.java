package com.main.app.service;

import com.main.app.entity.Product;
import com.main.app.repository.IProductRepository;
import com.main.app.utils.PagingAndSortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    IProductRepository productRepository;

    public Page<Product> getAllProduct(String sort ,Pageable pageable){
        return productRepository.findAll(PagingAndSortUtils.buildPageable(sort,pageable));
    }

}
