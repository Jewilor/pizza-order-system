package com.pizzasystem;

import com.pizzasystem.domain.*;
import com.pizzasystem.service.PizzaService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // --- Создаем тестовые данные ---
        // Клиенты
        Customer customer1 = new Customer(1, "Иван Иванов");
        Customer customer2 = new Customer(2, "Петр Петров");

        // Пиццы в меню
        List<Pizza> menu = List.of(
                new Pizza("Маргарита", Size.MEDIUM, 350.0),
                new Pizza("Пепперони", Size.LARGE, 450.0),
                new Pizza("Четыре сыра", Size.MEDIUM, 400.0),
                new Pizza("Гавайская", Size.SMALL, 300.0),
                new Pizza("Пепперони", Size.MEDIUM, 400.0)
        );

        // История заказов
        List<Order> orders = List.of(
                new Order(101, customer1, List.of(menu.get(0), menu.get(1))),
                new Order(102, customer2, List.of(menu.get(2))),
                new Order(103, customer1, List.of(menu.get(3)))
        );

        // Инициализируем сервис
        PizzaService service = new PizzaService(menu, orders);

        // --- Демонстрация операций ---
        System.out.println("--- 1. Поиск заказов по клиенту (Иван Иванов) ---");
        List<Order> ivanOrders = service.findOrdersByCustomer(customer1);
        ivanOrders.forEach(System.out::println);

        System.out.println("\n--- 2. Фильтрация пицц по размеру (MEDIUM) ---");
        List<Pizza> mediumPizzas = service.filterPizzasBySize(Size.MEDIUM);
        mediumPizzas.forEach(System.out::println);
    }
}