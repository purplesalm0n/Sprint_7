package ru.yandex.praktikum.client;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.yandex.praktikum.model.Courier;
import ru.yandex.praktikum.model.CourierCredentials;

public class CourierClient extends BaseClient {

    @Step("Создаём курьера")
    public Response createCourier(Courier courier) {
        return givenRequest()
                .body(courier)
                .post("courier");
    }

    @Step("Логиним курьера")
    public Response loginCourier(CourierCredentials credentials) {
        return givenRequest()
                .body(credentials)
                .post("courier/login");
    }

    @Step("Удаляем курьера с ID: {courierId}")
    public Response deleteCourier(int courierId) {
        return givenRequest()
                .delete("courier/" + courierId);
    }
}
