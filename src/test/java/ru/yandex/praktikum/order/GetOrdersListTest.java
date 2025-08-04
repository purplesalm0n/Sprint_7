package ru.yandex.praktikum.order;

import io.qameta.allure.Step;
import org.junit.Test;
import ru.yandex.praktikum.client.OrderClient;

import static org.hamcrest.Matchers.notNullValue;

public class GetOrdersListTest {
    private final OrderClient orderClient = new OrderClient();

    @Test
    @Step("Проверяем получение списка заказов")
    public void getOrdersList() {
        orderClient.getOrdersList()
                .then().statusCode(200).body("orders", notNullValue());
    }
}
