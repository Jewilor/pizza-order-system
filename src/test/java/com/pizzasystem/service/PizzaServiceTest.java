package com.pizzasystem.service;

import com.pizzasystem.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для класса PizzaService.
 */
class PizzaServiceTest {

    private PizzaService pizzaService;
    private Customer customer1;
    private Customer customer2;
    private Customer customerWithNoOrders;

    // Этот метод будет выполняться ПЕРЕД каждым тестом (@Test)
    // Он идеально подходит для подготовки тестовых данных.
    @BeforeEach
    void setUp() {
        // Arrange (Подготовка): создаем общие данные для всех тестов
        customer1 = new Customer(1, "Иван Иванов");
        customer2 = new Customer(2, "Петр Петров");
        customerWithNoOrders = new Customer(3, "Анна Сидорова");

        List<Pizza> menu = List.of(
                new Pizza("Маргарита", Size.MEDIUM, 350.0),
                new Pizza("Пепперони", Size.LARGE, 450.0),
                new Pizza("Четыре сыра", Size.MEDIUM, 400.0)
        );

        List<Order> orders = List.of(
                new Order(101, customer1, List.of(menu.get(0), menu.get(1))),
                new Order(102, customer2, List.of(menu.get(2))),
                new Order(103, customer1, List.of(menu.get(0)))
        );

        pizzaService = new PizzaService(menu, orders);
    }

    @Test
    @DisplayName("Должен находить все заказы для существующего клиента")
    void shouldFindAllOrdersForExistingCustomer() {
        // Act (Действие): вызываем тестируемый метод
        List<Order> foundOrders = pizzaService.findOrdersByCustomer(customer1);

        // Assert (Проверка): проверяем, что результат соответствует ожиданиям
        assertEquals(2, foundOrders.size(), "Должно быть найдено 2 заказа для клиента 1");
        // Убедимся, что все найденные заказы действительно принадлежат Ивану
        assertTrue(foundOrders.stream().allMatch(order -> order.getCustomer().getId() == customer1.getId()));
    }

    @Test
    @DisplayName("Должен возвращать пустой список для клиента без заказов")
    void shouldReturnEmptyListForCustomerWithNoOrders() {
        // Act
        List<Order> foundOrders = pizzaService.findOrdersByCustomer(customerWithNoOrders);

        // Assert
        assertNotNull(foundOrders, "Список не должен быть null");
        assertTrue(foundOrders.isEmpty(), "Список заказов для клиента без заказов должен быть пустым");
    }

    @Test
    @DisplayName("Должен правильно фильтровать пиццы по размеру MEDIUM")
    void shouldFilterPizzasBySizeMedium() {
        // Act
        List<Pizza> mediumPizzas = pizzaService.filterPizzasBySize(Size.MEDIUM);

        // Assert
        assertEquals(2, mediumPizzas.size(), "Должно быть найдено 2 пиццы размера MEDIUM");
        // Убедимся, что все найденные пиццы действительно среднего размера
        assertTrue(mediumPizzas.stream().allMatch(pizza -> pizza.getSize() == Size.MEDIUM));
    }

    @Test
    @DisplayName("Должен возвращать пустой список, если пицц нужного размера нет")
    void shouldReturnEmptyListForSizeWithNoPizzas() {
        // Act
        List<Pizza> smallPizzas = pizzaService.filterPizzasBySize(Size.SMALL);

        // Assert
        assertNotNull(smallPizzas, "Список не должен быть null");
        assertTrue(smallPizzas.isEmpty(), "Список пицц размера SMALL должен быть пустым");
    }
}