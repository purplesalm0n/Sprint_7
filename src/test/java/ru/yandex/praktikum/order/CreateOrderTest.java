package ru.yandex.praktikum.order;

import io.qameta.allure.Step;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.client.OrderClient;
import ru.yandex.praktikum.model.Order;

import java.util.List;

import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class CreateOrderTest {

    private final List<String> colors;
    private final OrderClient orderClient = new OrderClient();

    public CreateOrderTest(List<String> colors) {
        this.colors = colors;
    }

    @Parameterized.Parameters(name = "Цвет заказа: {0}")
    public static Object[][] getColors() {
        return new Object[][]{
                {List.of("BLACK")},
                {List.of("GREY")},
                {List.of("BLACK", "GREY")},
                {List.of()}
        };
    }

    @Test
    @Step("Создание заказа с цветами: {0}")
    public void createOrderWithColors() {
        Order order = Order.random(colors);

        orderClient.createOrder(order)
                .then()
                .statusCode(201)
                .body("track", notNullValue());
    }
}
