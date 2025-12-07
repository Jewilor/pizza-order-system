package com.pizzasystem.domain;

public class Pizza {
    private final String name;
    private final Size size;
    private final double price;

    /**
     * Конструктор для создания объекта пиццы.
     * @param name Название пиццы.
     * @param size Размер пиццы.
     * @param price Цена пиццы.
     */
    public Pizza(String name, Size size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Size getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}