package com.pizzasystem.service;

import com.pizzasystem.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PizzaServiceTest {

    private PizzaService pizzaService;
    private Customer customer1;
    private Customer customerWithNoOrders;

    @BeforeEach
    void setUp() {
        // Arrange: set up common data for all tests
        customer1 = new Customer(1, "John Doe");
        Customer customer2 = new Customer(2, "Peter Jones");
        customerWithNoOrders = new Customer(3, "Anna Smith");

        List<Pizza> menu = List.of(
                new Pizza("Margarita", Size.MEDIUM, 350.0),
                new Pizza("Pepperoni", Size.LARGE, 450.0),
                new Pizza("Four Cheese", Size.MEDIUM, 400.0)
        );

        List<Order> orders = List.of(
                new Order(101, customer1, List.of(menu.get(0), menu.get(1))),
                new Order(102, customer2, List.of(menu.get(2))),
                new Order(103, customer1, List.of(menu.get(0)))
        );

        pizzaService = new PizzaService(menu, orders);
    }

    @Test
    @DisplayName("Should find all orders for an existing customer")
    void shouldFindAllOrdersForExistingCustomer() {
        // Act
        List<Order> foundOrders = pizzaService.findOrdersByCustomer(customer1);

        // Assert
        assertEquals(2, foundOrders.size(), "Should find 2 orders for customer 1");
        assertTrue(foundOrders.stream().allMatch(order -> order.getCustomer().getId() == customer1.getId()));
    }

    // ... (остальные тесты остаются без изменений, так как они не зависят от имен)
    @Test
    @DisplayName("Should return an empty list for a customer with no orders")
    void shouldReturnEmptyListForCustomerWithNoOrders() {
        List<Order> foundOrders = pizzaService.findOrdersByCustomer(customerWithNoOrders);
        assertNotNull(foundOrders);
        assertTrue(foundOrders.isEmpty());
    }

    @Test
    @DisplayName("Should correctly filter pizzas by MEDIUM size")
    void shouldFilterPizzasBySizeMedium() {
        List<Pizza> mediumPizzas = pizzaService.filterPizzasBySize(Size.MEDIUM);
        assertEquals(2, mediumPizzas.size());
        assertTrue(mediumPizzas.stream().allMatch(pizza -> pizza.getSize() == Size.MEDIUM));
    }

    @Test
    @DisplayName("Should return an empty list if no pizzas of the given size exist")
    void shouldReturnEmptyListForSizeWithNoPizzas() {
        List<Pizza> smallPizzas = pizzaService.filterPizzasBySize(Size.SMALL);
        assertNotNull(smallPizzas);
        assertTrue(smallPizzas.isEmpty());
    }
}