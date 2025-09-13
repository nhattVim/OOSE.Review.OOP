package com.example;

import java.util.Scanner;

/**
 * Product management
 */
public class App {

    public static void main(String[] args) {

        ProductManager productManager = new ProductManager();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println();
                System.out.println("---- Product Management ----");
                System.out.println("Enter 1 to add a product");
                System.out.println("Enter 2 to print all products");
                System.out.println("Enter 3 to print products by filter");
                System.out.println("Enter 4 to update a product");
                System.out.println("Enter 5 to print total inventory price for each category");
                System.out.println("Enter 6 to sale a product");
                System.out.println("Enter 7 to order product");
                System.out.println("Enter 0 to exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                System.out.println();

                if (choice == 1) {
                    productManager.addProduct();
                } else if (choice == 2) {
                    productManager.printProducts();
                } else if (choice == 3) {
                    System.out.println("Enter 1 to filter product by category");
                    System.out.println("Enter 2 to filter product by price");
                    int nestedChoice = scanner.nextInt();
                    if (nestedChoice == 1) {
                        productManager.printProductByCategory();
                    } else if (nestedChoice == 2) {
                        productManager.printProductByPrice();
                    }
                } else if (choice == 4) {
                    productManager.updateProduct();
                } else if (choice == 5) {
                    productManager.totalInventoryPriceForCategory();
                } else if (choice == 6) {
                    productManager.saleProduct();
                } else if (choice == 7) {
                    productManager.orderProduct();
                } else if (choice == 0) {
                    System.exit(0);
                }
            }
        }

    }
}
