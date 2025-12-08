package com.pizzasystem;

import com.pizzasystem.domain.*;
import com.pizzasystem.service.PizzaService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // --- Create mock data ---
        // Customers
        Customer customer1 = new Customer(1, "John Doe");
        Customer customer2 = new Customer(2, "Peter Jones");

        // Pizza menu
        List<Pizza> menu = List.of(
                new Pizza("Margarita", Size.MEDIUM, 350.0),
                new Pizza("Pepperoni", Size.LARGE, 450.0),
                new Pizza("Four Cheese", Size.MEDIUM, 400.0),
                new Pizza("Hawaiian", Size.SMALL, 300.0),
                new Pizza("Pepperoni", Size.MEDIUM, 400.0)
        );

        // Order history
        List<Order> orders = List.of(
                new Order(101, customer1, List.of(menu.get(0), menu.get(1))),
                new Order(102, customer2, List.of(menu.get(2))),
                new Order(103, customer1, List.of(menu.get(3)))
        );

        // Initialize the service
        PizzaService service = new PizzaService(menu, orders);

        // --- Demonstrate operations ---
        System.out.println("--- 1. Finding orders for customer (John Doe) ---");
        List<Order> johnOrders = service.findOrdersByCustomer(customer1);
        johnOrders.forEach(System.out::println);

        System.out.println("\n--- 2. Filtering pizzas by size (MEDIUM) ---");
        List<Pizza> mediumPizzas = service.filterPizzasBySize(Size.MEDIUM);
        mediumPizzas.forEach(System.out::println);
    }
}