package com.company.dao;

import com.company.dto.OrderDTO;
import com.company.entity.Order;
import com.company.entity.Product;
import com.company.entity.StateTax;
import com.company.service.OrderServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OrderDAOImpl implements OrderDAO {
    public final static String FILE_HEADINGS = "OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total";

    public OrderDAOImpl(String dateOfOrder) {
        System.out.println("Orders_" + dateOfOrder + ".txt");
    }

    @Override
    public List<Order> readAllOrders(String date) throws IOException {
        String filename = "src/main/resources/file/Orders_" + date + ".txt";
        List<Order> orders = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Order order = new Order(
                        Integer.parseInt(values[0]),
                        values[1],
                        values[2],
                        Double.parseDouble(values[3]),
                        values[4],
                        Double.parseDouble(values[5]),
                        Double.parseDouble(values[6]),
                        Double.parseDouble(values[7]),
                        Double.parseDouble(values[8]),
                        Double.parseDouble(values[9]),
                        Double.parseDouble(values[10]),
                        Double.parseDouble(values[11])
                );
                orders.add(order);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No orders found for date: " + date);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return orders;
    }

    @Override
    public void addNewOrder(OrderDTO newOrderDto, String dateOfOrder) throws Exception {
        List<StateTax> taxes = new StateTaxDAOImpl().readTaxes();
        List<Product> products = new ProductDAOImpl().readProducts();
        // System.out.println(taxes);
        // System.out.println(products);

        String stateNameToMatch = newOrderDto.getStateName();
        StateTax currentTax = taxes.stream()
                .filter(tax -> tax.getStateName().equalsIgnoreCase(stateNameToMatch))
                .findFirst()
                .orElse(null); // or throw an exception if necessary

        Product currentProduct = products.stream()
                .filter(product -> product.getProductType().equalsIgnoreCase(newOrderDto.getProductType()))
                .findFirst()
                .orElse(null); // or throw an exception if necessary

        Order currentOrder = new OrderServiceImpl().createOrderFromDTO(newOrderDto,
                Objects.requireNonNull(currentTax), Objects.requireNonNull(currentProduct));

        // System.out.println(currentOrder);

        writeOrdersToFile(currentOrder, dateOfOrder);
    }

    @Override
    public void writeOrdersToFile(Order order, String date) {
        String filename = "src/main/resources/file/Orders_" + date + ".txt";
        try {
            File file = new File(filename);
            boolean fileExists = file.exists();

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            if (!fileExists) {
                bw.write("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total");
                bw.newLine();
            }

            bw.write(order.getOrderNumber() + ",");
            bw.write(order.getCustomerName() + ",");
            bw.write(order.getStateName() + ",");
            bw.write(order.getTaxRate() + ",");
            bw.write(order.getProductType() + ",");
            bw.write(order.getArea() + ",");
            bw.write(order.getCostPerSquareFoot() + ",");
            bw.write(order.getLaborCostPerSquareFoot() + ",");
            bw.write(order.getMaterialCost() + ",");
            bw.write(order.getLaborCost() + ",");
            bw.write(order.getTax() + ",");
            bw.write(order.getTotal() + "");

            bw.newLine();
            bw.close();
            System.out.println("Order written to file successfully.");

        } catch (IOException e) {
            System.out.println("Error writing order to file.");
            e.printStackTrace();
        }

    }

    @Override
    public void removeOrder(String dateOfOrder, String id) {
        List<Order> orders;
        try {
            orders = readAllOrders(dateOfOrder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Optional<Order> optionalOrder = orders.stream()
                .filter(order -> order.getOrderNumber() == Integer.parseInt(id))
                .findFirst();
        if (optionalOrder.isPresent()) {
            orders.remove(optionalOrder.get());
            try {
                writeOrderToFile(orders, dateOfOrder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("Order with order number " + id + " not found on " + dateOfOrder);
        }
    }

    @Override
    public void writeOrderToFile(List<Order> orders, String date) throws IOException {
        String filename = "src/main/resources/file/Orders_" + date + ".txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(FILE_HEADINGS);
            for (Order order : orders) {
                writer.println(order.getOrderNumber() + "," + order.getCustomerName() + "," + order.getStateName() + "," + order.getTaxRate() + "," +
                        order.getProductType() + "," + order.getArea() + "," + order.getCostPerSquareFoot() + "," + order.getLaborCostPerSquareFoot() + "," +
                        order.getMaterialCost() + "," + order.getLaborCost() + "," + order.getTax() + "," + order.getTotal());
            }
        }
    }
}