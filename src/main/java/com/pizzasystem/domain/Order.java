package com.pizzasystem.domain;

import java.util.List;

/**
 * Представляет сущность "Заказ".
 */
public class Order {
    private final long id;
    private final Customer customer;
    private final List<Pizza> pizzas;

    /**
     * Конструктор для создания объекта заказа.
     * @param id Уникальный идентификатор заказа.
     * @param customer Клиент, сделавший заказ.
     * @param pizzas Список пицц в заказе.
     */
    public Order(long id, Customer customer, List<Pizza> pizzas) {
        this.id = id;
        this.customer = customer;
        this.pizzas = pizzas;
    }

    public long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer.getName() +
                ", pizzas=" + pizzas +
                '}';
    }
}