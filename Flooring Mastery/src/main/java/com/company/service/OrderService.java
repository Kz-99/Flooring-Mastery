package com.company.service;

import com.company.dto.OrderDTO;
import com.company.entity.Order;
import com.company.entity.Product;
import com.company.entity.StateTax;

public interface OrderService {

    Order createOrderFromDTO(OrderDTO newOrderDto, StateTax currentTax, Product currentProduct);
}
