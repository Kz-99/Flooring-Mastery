package com.company.entity;

import java.util.HashMap;
import java.util.Map;

public class Product {
    private String productType;
    private double costPerSqFoot;
    private double labourCostPerSqFoot;
    public static Map<String, Product> allProducts = new HashMap<>();

    public Product() {
    }

    public Product(String productType, double costPerSqFoot, double labourCostPerSqFoot) {
        this.productType = productType;
        this.costPerSqFoot = costPerSqFoot;
        this.labourCostPerSqFoot = labourCostPerSqFoot;
        allProducts.put(this.productType, this);
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getCostPerSqFoot() {
        return costPerSqFoot;
    }

    public void setCostPerSqFoot(double costPerSqFoot) {
        this.costPerSqFoot = costPerSqFoot;
    }

    public double getLabourCostPerSqFoot() {
        return labourCostPerSqFoot;
    }

    public void setLabourCostPerSqFoot(double labourCostPerSqFoot) {
        this.labourCostPerSqFoot = labourCostPerSqFoot;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productType='" + productType + '\'' +
                ", costPerSqFoot=" + costPerSqFoot +
                ", labourCostPerSqFoot=" + labourCostPerSqFoot +
                '}';
    }
}
