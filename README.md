# Pizza Order System

## 1. Описание проекта

Это простое консольное приложение, которое имитирует базовые операции в системе заказов пиццы. Проект служит демонстрацией основ Java, системы сборки Gradle и настройки CI/CD с помощью GitHub Actions.

**Основные технологии:**
*   Java 17
*   Gradle
*   JUnit 5
*   GitHub Actions

## 2. Пример работы

При запуске приложение выводит в консоль результат двух операций: поиск заказов для клиента "John Doe" и фильтрацию всех пицц среднего размера из меню.

```
--- 1. Finding orders for customer (John Doe) ---
Order{id=101, customer=John Doe, pizzas=[Pizza{name='Margarita', size=MEDIUM, price=350.0}, Pizza{name='Pepperoni', size=LARGE, price=450.0}]}
Order{id=103, customer=John Doe, pizzas=[Pizza{name='Hawaiian', size=SMALL, price=300.0}]}

--- 2. Filtering pizzas by size (MEDIUM) ---
Pizza{name='Margarita', size=MEDIUM, price=350.0}
Pizza{name='Four Cheese', size=MEDIUM, price=400.0}
Pizza{name='Pepperoni', size=MEDIUM, price=400.0}
```

## 3. Конфигурация

Этот проект не требует дополнительной настройки. Все демонстрационные данные (клиенты, меню, заказы) жестко закодированы в файле `src/main/java/com/pizzasystem/Main.java`.

## 4. Сборка

### Необходимые условия

Перед началом убедитесь, что на вашем компьютере установлены:

1.  **Git** — система контроля версий. ([Скачать](https://git-scm.com/downloads))
2.  **Java Development Kit (JDK) версии 17 или выше.** ([Скачать Adoptium Temurin 17](https://adoptium.net/temurin/releases/?version=17))

### Пошаговая инструкция

1.  **Откройте терминал** (командную строку).

2.  **Склонируйте репозиторий** на свой компьютер:
    ```bash
    git clone https://github.com/Jewilor/pizza-order-system.git
    ```

3.  **Перейдите в директорию проекта:**
    ```bash
    cd pizza-order-system
    ```

4.  **Запустите команду сборки.** Проект использует Gradle Wrapper, который автоматически скачает всё необходимое.

    *   Для **Linux / macOS**:
        ```bash
        ./gradlew build
        ```
    *   Для **Windows** (CMD / PowerShell):
        ```bash
        gradlew.bat build
        ```

    После успешной сборки в директории `build/libs/` появится готовый JAR-файл.

## 5. Тестирование

Для запуска всех автоматических тестов выполните команду:

*   Для **Linux / macOS**:
    ```bash
    ./gradlew test
    ```
*   Для **Windows**:
    ```bash
    gradlew.bat test
    ```
Успешное выполнение тестов завершится сообщением `BUILD SUCCESSFUL`.

## 6. Запуск

Есть два способа запустить приложение.

### Способ 1: Через Gradle (для разработки)

Этот способ удобен во время разработки, так как не требует предварительной сборки.

*   Для **Linux / macOS**:
    ```bash
    ./gradlew run
    ```
*   Для **Windows**:
    ```bash
    gradlew.bat run
    ```

### Способ 2: Напрямую через JAR-файл (после сборки)

Этот способ имитирует запуск готового приложения в реальной среде.

1.  Сначала убедитесь, что вы **собрали проект**, как описано в разделе 4.

2.  Выполните команду для запуска JAR-файла:
    ```bash
    java -jar build/libs/pizza-order-system-1.0-SNAPSHOT.jar
    ```

> **Примечание:** Имя JAR-файла (`pizza-order-system-1.0-SNAPSHOT.jar`) зависит от версии, указанной в `build.gradle`, и может отличаться.
