package com.company.service;

import com.company.dto.OrderDTO;
import com.company.entity.Order;
import com.company.entity.Product;
import com.company.entity.StateTax;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OrderServiceImplTest {

    @Test
    public void testCreateOrderFromDTO() {
        // Create a mock OrderDTO
        OrderDTO newOrderDto = mock(OrderDTO.class);
        when(newOrderDto.getCustomerName()).thenReturn("Kevin");
        when(newOrderDto.getStateName()).thenReturn("Texas");
        when(newOrderDto.getProductType()).thenReturn("Tile");
        when(newOrderDto.getArea()).thenReturn(100.0);

        // Create a mock StateTax
        StateTax currentTax = mock(StateTax.class);
        when(currentTax.getStateRate()).thenReturn(4.45);

        // Create a mock Product
        Product currentProduct = mock(Product.class);
        when(currentProduct.getCostPerSqFoot()).thenReturn(3.5);
        when(currentProduct.getLabourCostPerSqFoot()).thenReturn(4.15);

        // Create an instance of OrderService
        OrderServiceImpl orderService = new OrderServiceImpl();

        // Call the method under test
        Order order = orderService.createOrderFromDTO(newOrderDto, currentTax, currentProduct);

        // Assert the expected values
        assertEquals("Kevin", order.getCustomerName());
        assertEquals("Texas", order.getStateName());
        assertEquals(4.45, order.getTaxRate());
        assertEquals("Tile", order.getProductType());
        assertEquals(100.0, order.getArea());
        assertEquals(350.0, order.getMaterialCost());
        assertEquals(415.00000000000006, order.getLaborCost());
        assertEquals(34.042500000000004, order.getTax());
        assertEquals(799.0425, order.getTotal());
    }
}