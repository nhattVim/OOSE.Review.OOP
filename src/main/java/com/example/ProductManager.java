package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {

    Scanner scanner = new Scanner(System.in);

    public ArrayList<Product> products = new ArrayList<>(
            List.of(
                    new Product(2, "Apple watch", 20.99, 30, "Watch", "A great watch"),
                    new Product(3, "Sony TV", 30.99, 15, "TV", "TV 4K"),
                    new Product(1, "Macbook", 10.99, 60, "Laptop", "The best laptop")));

    public void printProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void printProductByCategory() {
        ArrayList<Product> sortedProducts = new ArrayList<>(products);
        sortedProducts.sort((p1, p2) -> p1.getCategory().compareTo(p2.getCategory()));
        for (Product product : sortedProducts) {
            System.out.println(product);
        }
    }

    public void printProductByPrice() {
        ArrayList<Product> sortedProducts = new ArrayList<>(products);
        sortedProducts.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        for (Product product : sortedProducts) {
            System.out.println(product);
        }
    }

    public void addProduct() {
        System.out.println("Enter product id: ");
        int id = scanner.nextInt();
        System.out.println("Enter product name: ");
        String name = scanner.next();
        System.out.println("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter product quantity: ");
        int quantity = scanner.nextInt();
        System.out.println("Enter product category: ");
        String category = scanner.next();
        System.out.println("Enter product description: ");
        String description = scanner.next();
        products.add(new Product(id, name, price, quantity, category, description));
    }

    public void updateProduct() {
        System.out.println("Enter product id: ");
        int id = scanner.nextInt();
        System.out.println("Enter product name: ");
        String name = scanner.next();
        System.out.println("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter product category: ");
        String category = scanner.next();
        System.out.println("Enter product description: ");
        String description = scanner.next();
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(name);
                product.setPrice(price);
                product.setCategory(category);
                product.setDescription(description);
            }
        }
    }

    public void totalInventoryPriceForCategory() {
        ArrayList<String> categories = new ArrayList<>();
        for (Product product : products) {
            if (!categories.contains(product.getCategory())) {
                categories.add(product.getCategory());
            }
        }
        for (String category : categories) {
            double totalInventoryPrice = 0;
            for (Product product : products) {
                if (product.getCategory().equals(category)) {
                    totalInventoryPrice += product.getPrice();
                }
            }
            System.out.println("Total inventory price for " + category + " is: " + totalInventoryPrice);
        }
    }

    public void saleProduct() {
        System.out.println("Enter product id: ");
        int id = scanner.nextInt();
        System.out.println("Enter sale percentage (%): ");
        double salePercentage = scanner.nextDouble();
        for (Product product : products) {
            if (product.getId() == id) {
                product.setPrice(product.getPrice() * salePercentage / 100);
            }
        }
    }

    public void orderProduct() {
        System.out.println("Enter product id: ");
        int id = scanner.nextInt();
        System.out.println("Enter number of products: ");
        int quantity = scanner.nextInt();
        for (Product product : products) {
            if (quantity <= 0 || quantity > product.getQuantity()) {
                System.out.println("Invalid quantity");
                return;
            } else if (product.getId() == id) {
                System.out.println("Ordered " + quantity + " " + product.getName());
                System.out.println("Total price: " + product.getPrice() * quantity);
                product.setQuantity(product.getQuantity() - quantity);
            }
        }
    }
}
