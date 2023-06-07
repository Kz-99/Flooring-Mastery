package com.company.dao;

import com.company.entity.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> readProducts() throws Exception;
}
