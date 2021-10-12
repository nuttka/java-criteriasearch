package com.gubee.teste.repository.criteria;

import java.util.List;

import com.gubee.teste.entity.Product;
import com.gubee.teste.filter.FilterProduct;

public interface ProductRepositoryCustom {
    List<Product> searchByFilter(FilterProduct filterProduct);
}
