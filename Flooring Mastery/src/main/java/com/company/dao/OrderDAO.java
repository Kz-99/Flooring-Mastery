package com.company.dao;

import com.company.dto.OrderDTO;
import com.company.entity.Order;

import java.io.IOException;
import java.util.List;

public interface OrderDAO {

    List<Order> readAllOrders(String date) throws IOException;
    void addNewOrder(OrderDTO newOrderDto, String dateOfOrder) throws Exception;
    void writeOrdersToFile(Order order, String date) throws IOException;
    void removeOrder(String dateOfOrder, String id) throws Exception;
    void writeOrderToFile(List<Order> orders, String date) throws IOException;
}
