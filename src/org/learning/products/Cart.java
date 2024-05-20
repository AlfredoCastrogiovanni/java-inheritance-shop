package org.learning.products;

import java.util.Scanner;

public class Cart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        Product[] cart = new Product[0];
        boolean fidelityCard = false;

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
                        System.out.println();

                        choice = Integer.parseInt(scanner.nextLine());
                        System.out.println();

                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.println();

                        System.out.print("Description: ");
                        String description = scanner.nextLine();
                        System.out.println();

                        System.out.print("Price: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        System.out.println();

                        System.out.print("VAT: ");
                        int vat = Integer.parseInt(scanner.nextLine());
                        System.out.println();

                        switch (choice) {
                            case 1:
                                System.out.print("IMEI: ");
                                String imei = scanner.nextLine();
                                System.out.println();

                                System.out.print("Memory: ");
                                double memory = Double.parseDouble(scanner.nextLine());

                                cart = addToCart(cart, new Smartphone(name, description, price, vat, imei, memory));
                                break;
                            case 2:
                                System.out.print("Inch: ");
                                double inch = Double.parseDouble(scanner.nextLine());
                                System.out.println();

                                System.out.println("Is Smart? (y/n)");
                                Boolean isSmart = scanner.nextLine().charAt(0) == ('y');

                                cart = addToCart(cart, new Tv(name, description, price, vat, inch, isSmart));
                                break;
                            case 3:
                                System.out.print("Color: ");
                                String color = scanner.nextLine();
                                System.out.println();

                                System.out.println("Is Wireless? (y/n)");
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
                        viewCart(cart, scanner, fidelityCard);
                        break;
                    case 3:
                        System.out.println("Fidelity card added.");
                        fidelityCard = true;
                        break;
                    case 4:
                        viewCart(cart, scanner, fidelityCard);
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Enter a valid input!");
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("|         CART MENU        |");
        System.out.println("----------------------------");
        System.out.println("1. Add product");
        System.out.println("2. View your cart");
        System.out.println("3. Add fidelity card");
        System.out.println("4. Exit");
        System.out.println("----------------------------");
        System.out.println();
    }

    private static void viewCart(Product[] cart, Scanner scanner, boolean fidelityCard) {
        System.out.println("-----------------------------");
        System.out.println("|           CART            |");
        System.out.println("-----------------------------");

        double total = 0;

        // if (cart.length <= 0) {
        //     System.out.println("          Is Empty           ");
        // } else if (fidelityCard) {
        //     for (int i = 0; i < cart.length; i++) {
        //         System.out.println(cart[i]);
        //         total += cart[i].priceWithFidelityCard().doubleValue();
        //     }
        // } else {
        //     for (int i = 0; i < cart.length; i++) {
        //         System.out.println(cart[i]);
        //         total += cart[i].getPriceWithVat().doubleValue();
        //     }
        // }

        if (cart.length <= 0) {
            System.out.println("          Is Empty           ");
        } else {
            for (int i = 0; i < cart.length; i++) {
                System.out.println(cart[i]);
                total += cart[i].getPrice(fidelityCard).doubleValue();
            }
        }


        System.out.println();
        System.out.println("Total: " + total);

        System.out.println();
        System.out.print("Enter to exit");
        scanner.nextLine();
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
