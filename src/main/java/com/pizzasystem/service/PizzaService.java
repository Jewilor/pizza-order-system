package com.pizzasystem.service;

import com.pizzasystem.domain.Customer;
import com.pizzasystem.domain.Order;
import com.pizzasystem.domain.Pizza;
import com.pizzasystem.domain.Size;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис для управления бизнес-логикой, связанной с пиццами и заказами.
 */
public class PizzaService {

    private final List<Pizza> availablePizzas;
    private final List<Order> orderHistory;

    public PizzaService(List<Pizza> availablePizzas, List<Order> orderHistory) {
        this.availablePizzas = availablePizzas;
        this.orderHistory = orderHistory;
    }

    /**
     * Находит все заказы, сделанные определенным клиентом.
     * @param customer Клиент, чьи заказы нужно найти.
     * @return Список заказов клиента.
     */
    public List<Order> findOrdersByCustomer(Customer customer) {
        // TODO: Реализовать логику поиска заказов по клиенту.
        // Используем Stream API для фильтрации
        return orderHistory.stream()
                .filter(order -> order.getCustomer().getId() == customer.getId())
                .collect(Collectors.toList());
    }

    /**
     * Фильтрует доступные пиццы по указанному размеру.
     * @param size Размер для фильтрации.
     * @return Список пицц заданного размера.
     */
    public List<Pizza> filterPizzasBySize(Size size) {
        // TODO: Реализовать логику фильтрации пицц по размеру.
        return availablePizzas.stream()
                .filter(pizza -> pizza.getSize() == size)
                .collect(Collectors.toList());
    }
}