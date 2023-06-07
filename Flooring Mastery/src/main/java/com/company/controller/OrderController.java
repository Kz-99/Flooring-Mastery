package com.company.controller;

import com.company.dao.OrderDAOImpl;
import com.company.dao.ProductDAOImpl;
import com.company.dao.StateTaxDAOImpl;
import com.company.dto.OrderDTO;
import com.company.entity.Order;
import com.company.view.MenuImp;

import java.util.List;
import java.util.Scanner;

public class OrderController {
    StateTaxDAOImpl stateTaxDAOImpl;
    ProductDAOImpl productDAOImpl;
    MenuImp menuImp;


    public OrderController(StateTaxDAOImpl stateTaxDAOImpl, ProductDAOImpl productDAOImpl, MenuImp menuImp) {
        this.stateTaxDAOImpl = stateTaxDAOImpl;
        this.productDAOImpl = productDAOImpl;
        this.menuImp = menuImp;
    }

    public void runProgram() throws Exception {
        int choice;
        Scanner inputIn = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        Scanner inputDouble = new Scanner(System.in);
        stateTaxDAOImpl.readTaxes();
        productDAOImpl.readProducts();
        // Keep main menu shown until I select Exit
        // and also branch off to do other tasks
        do {
            menuImp.mainMenu();
            choice = inputIn.nextInt();
            switch (choice) {
                case 1:
                    menuImp.provideDate();
                    String dateOfOrder = inputString.next();
                    System.out.println("Finding Orders for " + dateOfOrder);
                    OrderDAOImpl orderDAOImpl = new OrderDAOImpl(dateOfOrder);
                    List<Order> orders = orderDAOImpl.readAllOrders(dateOfOrder);
                    for (Order o : orders) {
                        System.out.println(o.toString());
                    }
                    break;
                case 2:

                    menuImp.addOrder();
                    dateOfOrder = inputString.next();
                    OrderDAOImpl newOrderDaoImpl = new OrderDAOImpl(dateOfOrder);
                    // Put in prompts for user input of new order details
                    System.out.println("Enter Customer name");
                    String customerName = inputString.next();
                    System.out.println("Enter the state");
                    String state = inputString.next();
                    System.out.println("Enter the Product Type");
                    String productType = inputString.next();
                    System.out.println("Enter the area");
                    double area = inputDouble.nextDouble();
                    Order order = new Order(customerName, state, productType, area);

                    System.out.println("Your newest order contains " + order);
                    OrderDTO orderTemp = new OrderDTO(customerName, state, productType, area);

                    newOrderDaoImpl.addNewOrder(orderTemp, dateOfOrder);

                    break;
                case 3:
                    menuImp.editOrder();
                    dateOfOrder = inputString.next();
                    OrderDAOImpl editOrderDaoImpl = new OrderDAOImpl(dateOfOrder);

                    break;
                case 4:
                    menuImp.RemoveOrder();
                    dateOfOrder = inputString.next();
                    OrderDAOImpl removeOrderDaoImpl = new OrderDAOImpl(dateOfOrder);
                    System.out.println("Enter the ID of the order to be removed");
                    String id = inputString.next();
                    removeOrderDaoImpl.removeOrder(dateOfOrder, id);

                    break;
                case 5:
                    System.out.println("Exiting Program ....");
                    break;
                default:
                    System.out.println("Invalid choice. Re-select");
            }


        } while (choice != 5);
        // System.out.println(StateTax.allStateTaxes);
        // System.out.println(Product.allProducts);
    }
}
