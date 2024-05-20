package org.learning.products;

import java.util.Scanner;

public class Cart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        Product[] cart = new Product[0];

        while (true) {
            
            printMenu();

            try {
                choice = Integer.parseInt(scanner.nextLine());
                System.out.println();

                switch (choice) {
                    case 1:
                        System.out.println("Which type of product?");
                        System.out.println();
                        System.out.println("1. Smartphone");
                        System.out.println("2. Tv");
                        System.out.println("3. Headphones");
                        System.out.println("4. Generic Product");

                        choice = Integer.parseInt(scanner.nextLine());

                        System.out.print("Name:");
                        String name = scanner.nextLine();

                        System.out.print("Description:");
                        String description = scanner.nextLine();

                        System.out.print("Price:");
                        double price = Double.parseDouble(scanner.nextLine());

                        System.out.print("VAT:");
                        int vat = Integer.parseInt(scanner.nextLine());

                        switch (choice) {
                            case 1:
                                System.out.print("IMEI:");
                                String imei = scanner.nextLine();
        
                                System.out.print("Memory:");
                                double memory = Double.parseDouble(scanner.nextLine());

                                cart = addToCart(cart, new Smartphone(name, description, price, vat, imei, memory));
                                break;
                            case 2:
                                System.out.print("IMEI:");
                                double inch = Double.parseDouble(scanner.nextLine());
        
                                System.out.print("Is Smart ? (y/n)");
                                Boolean isSmart = scanner.nextLine().charAt(0) == ('y');

                                cart = addToCart(cart, new Tv(name, description, price, vat, inch, isSmart));
                                break;
                            case 3:
                                System.out.print("Color:");
                                String color = scanner.nextLine();
        
                                System.out.print("Is Wireless ? (y/n)");
                                Boolean isWireless = scanner.nextLine().charAt(0) == ('y');

                                cart = addToCart(cart, new Headphones(name, description, price, vat, color, isWireless));
                                break;
                            case 4:
                                cart = addToCart(cart, new Product(name, description, price, vat));
                                break;
                            default:
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("-----------------------------");
                        System.out.println("|           CART            |");
                        System.out.println("-----------------------------");

                        for (int i = 0; i < cart.length; i++) {
                            System.out.println(i + " - " + cart[i].getFullName());
                        }

                        System.out.println();
                        System.out.print("Enter to exit");
                        scanner.nextLine();

                        break;
                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Enter a valid input!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("----------------------------");
        System.out.println("|         CART MENU        |");
        System.out.println("----------------------------");
        System.out.println("1. Add product");
        System.out.println("2. View your cart");
        System.out.println("3. Exit");
        System.out.println("----------------------------");
        System.out.println();
    }

    public static Product[] addToCart(Product[] cart, Product item) {
        Product[] newCart = new Product[cart.length + 1];

        for (int i = 0; i < cart.length; i++) {
            newCart[i] = cart[i];
        }

        newCart[newCart.length - 1] = item;

        return newCart;
    }
}
