package com.company.dto;

import com.company.entity.Product;
import com.company.entity.StateTax;

public class OrderDTO {
    private String customerName;
    private StateTax tax;
    private String stateName;
    private String productType;
    private Product product;
    double area;

    public OrderDTO() {
    }

    public OrderDTO(String customerName, String stateName, String productType, double area) {
        this.customerName = customerName;
        this.stateName = stateName;
        this.productType = productType;
        this.area = area;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public StateTax getTax() {
        return tax;
    }

    public void setTax(StateTax tax) {
        this.tax = tax;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
