package ru.yandex.praktikum.client;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.yandex.praktikum.model.Order;

public class OrderClient extends BaseClient {

    @Step("Создаём заказ")
    public Response createOrder(Order order) {
        return givenRequest()
                .body(order)
                .post("orders");
    }

    @Step("Получаем список заказов")
    public Response getOrdersList() {
        return givenRequest()
                .get("orders");
    }
}
