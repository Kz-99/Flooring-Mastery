package com.company.view;

public class MenuImp implements Menu {

    @Override
    public void mainMenu() {

        System.out.println("=== EP Products ===");
        System.out.println("1. Display Orders");
        System.out.println("2. Add Order");
        System.out.println("3. Edit Order");
        System.out.println("4. Remove Order");
        System.out.println("5. Exit");
        System.out.println("Enter your option ===> ");

    }

    @Override
    public void provideDate() {
        printDateFormat();
    }

    @Override
    public void addOrder() {
        printDateFormat();
    }

    @Override
    public void editOrder() {
        printDateFormat();
    }

    @Override
    public void RemoveOrder() {

    }

    private void printDateFormat() {
        System.out.println("Enter Date of Order to be removed in DDMMYYYY Format ===> ");
    }
}
