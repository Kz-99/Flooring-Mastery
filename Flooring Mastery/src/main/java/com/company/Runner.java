package com.company;

import com.company.controller.OrderController;
import com.company.dao.ProductDAOImpl;
import com.company.dao.StateTaxDAOImpl;
import com.company.view.MenuImp;


public class Runner {

    public static void main(String[] args)
    {

        MenuImp menuImp = new MenuImp();
        StateTaxDAOImpl taxes = new StateTaxDAOImpl();
        ProductDAOImpl products = new ProductDAOImpl();

        OrderController orderController = new OrderController(taxes,products, menuImp);
        try {
            orderController.runProgram();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
