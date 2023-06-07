package com.company.entity;

public class Order {

    private static int counter = 0;
    private int orderNumber;
    private String customerName;
    private String stateName;
    private double taxRate;
    private String productType;
    private double area ;
    private double costPerSquareFoot ;
    private double laborCostPerSquareFoot ;
    private double materialCost ;
    private double laborCost ;
    private double tax ;
    private double total ;

    public Order() {
    }

    public Order(String customerName, String stateName, String productType, double area) {
        this.orderNumber = getCounter();
        this.customerName = customerName;
        this.stateName = stateName;
        this.productType = productType;
        this.area = area;
        this.materialCost = area * costPerSquareFoot;
        this.laborCost = area * laborCostPerSquareFoot;
        this.tax = (materialCost + laborCost) * taxRate / 100;
        this.total = materialCost + laborCost + tax;
    }

    public Order(int orderNumber, String customerName, String stateName, double taxRate,
                 String productType, double area, double costPerSquareFoot,
                 double laborCostPerSquareFoot, double materialCost, double laborCost,
                 double tax, double total) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.stateName = stateName;
        this.taxRate = taxRate;
        this.productType = productType;
        this.area = area;
        this.costPerSquareFoot = costPerSquareFoot;
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
        this.materialCost = materialCost;
        this.laborCost = laborCost;
        this.tax = tax;
        this.total = total;
    }

    public static int getCounter() {
        return counter++;
    }

    public static void setCounter(int counter) {
        Order.counter = counter;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    public void setCostPerSquareFoot(double costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }

    public double getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    public void setLaborCostPerSquareFoot(double laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", customerName='" + customerName + '\'' +
                ", stateName='" + stateName + '\'' +
                ", taxRate=" + taxRate +
                ", productType='" + productType + '\'' +
                ", area=" + area +
                ", costPerSquareFoot=" + costPerSquareFoot +
                ", laborCostPerSquareFoot=" + laborCostPerSquareFoot +
                ", materialCost=" + materialCost +
                ", laborCost=" + laborCost +
                ", tax=" + tax +
                ", total=" + total +
                '}';
    }

   /*private OrderService orderService = new OrderService(); // Associated Service Layer class
    private String dateOfOrder;
    private String name;
    private String state;
    private String product_type;
    private String area;*/

    /*
    Constructor to be used when reading from the file - All the values already exist
    and no calculations are needed!!
     */
    /*public Order(int orderNumber, String customerName,
                 String state, double taxRate,
                 String productType, double area,
                 double costPerSquareFoot, double laborCostPerSquareFoot,
                 double materialCost, double laborCost,
                 double tax, double total) {
        OrderNumber = orderNumber;
        CustomerName = customerName;
        State = state;
        TaxRate = taxRate;
        ProductType = productType;
        Area = area;
        CostPerSquareFoot = costPerSquareFoot;
        LaborCostPerSquareFoot = laborCostPerSquareFoot;
        MaterialCost = materialCost;
        LaborCost = laborCost;
        Tax = tax;
        Total = total;
    }*/

    /*
    Creating an order from scratch ... Feed in most values but there are some calculations
     */
    /*public Order(int orderNumber, String customerName,
                 String state, double taxRate,
                 String productType, double area,
                 double costPerSquareFoot, double laborCostPerSquareFoot) {
        this.OrderNumber = orderNumber;
        CustomerName = customerName;
        State = state;
        TaxRate = taxRate;
        ProductType = productType;
        Area = area;
        CostPerSquareFoot = costPerSquareFoot;
        LaborCostPerSquareFoot = laborCostPerSquareFoot;


        this.MaterialCost = orderService.CalculateMaterialCosts(this);
         this.LaborCost = orderService.CalculateLabourCosts(this);*/
        /*
        this.Tax = tax;
        this.Total = total;
      */
/*
    }*/


}
