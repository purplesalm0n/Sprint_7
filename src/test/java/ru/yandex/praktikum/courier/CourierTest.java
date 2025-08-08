package ru.yandex.praktikum.courier;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.client.CourierClient;
import ru.yandex.praktikum.model.Courier;
import ru.yandex.praktikum.model.CourierCredentials;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CourierTest {
    private CourierClient courierClient;
    private Courier courier;
    private int courierId;

    @Before
    @Step("Инициализация клиента и данных курьера")
    public void setUp() {
        courierClient = new CourierClient();
        courier = Courier.random();
    }

    @After
    @Step("Удаление тестового курьера")
    public void tearDown() {
        courierClient.deleteCourierByCredentials(courier);
    }

    @Test
    @Step("Проверка создания курьера")
    public void courierCanBeCreated() {
        courierClient.createCourier(courier)
                .then().statusCode(201).body("ok", equalTo(true));

        courierId = courierClient.loginCourier(CourierCredentials.from(courier))
                .then().statusCode(200).extract().path("id");
    }

    @Test
    @Step("Проверка невозможности создания дубликата курьера")
    public void cannotCreateDuplicateCourier() {
        courierClient.createCourier(courier).then().statusCode(201);

        courierClient.createCourier(courier)
                .then().statusCode(409).body("message", notNullValue());
    }

    @Test
    @Step("Проверка невозможности создания курьера без логина")
    public void cannotCreateCourierWithoutLogin() {
        Courier courierNoLogin = new Courier("", "1234", "Name");
        courierClient.createCourier(courierNoLogin).then().statusCode(400);
    }
}
