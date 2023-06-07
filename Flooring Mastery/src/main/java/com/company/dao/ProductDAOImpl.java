package com.company.dao;

import com.company.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    public final String PRODUCTS_FILE = "src/main/resources/data/Products.txt";

    @Override
    public List<Product> readProducts() throws Exception {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PRODUCTS_FILE))) {

            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Product product = new Product();
                product.setProductType(fields[0]);
                product.setCostPerSqFoot(Double.parseDouble(fields[1]));
                product.setLabourCostPerSqFoot(Double.parseDouble(fields[2]));
                products.add(product);
            }
        }

        return products;
    }
}
