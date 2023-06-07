package com.company.service;

import com.company.dto.OrderDTO;
import com.company.entity.Order;
import com.company.entity.Product;
import com.company.entity.StateTax;

import static com.company.entity.Order.getCounter;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order createOrderFromDTO(OrderDTO newOrderDto, StateTax currentTax, Product currentProduct) {
        Order order = new Order();
        // Set the order details from the DTO, currentTax, and currentProduct
        order.setOrderNumber(getCounter());
        order.setCustomerName(newOrderDto.getCustomerName());
        order.setStateName(newOrderDto.getStateName());
        order.setTaxRate(currentTax.getStateRate());
        order.setProductType(newOrderDto.getProductType());
        order.setArea(newOrderDto.getArea());
        order.setCostPerSquareFoot(currentProduct.getCostPerSqFoot());
        order.setLaborCostPerSquareFoot(currentProduct.getLabourCostPerSqFoot());
        // Calculate and set the remaining fields (materialCost, laborCost, tax, total, etc.)
        // based on the order details
        order.setMaterialCost(order.getArea() * order.getCostPerSquareFoot());
        order.setLaborCost(order.getArea() * order.getLaborCostPerSquareFoot());
        order.setTax((order.getMaterialCost() + order.getLaborCost()) * (order.getTaxRate() / 100));
        order.setTotal(order.getMaterialCost() + order.getLaborCost() + order.getTax());

        return order;
    }
}
