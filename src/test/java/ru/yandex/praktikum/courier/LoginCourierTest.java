package ru.yandex.praktikum.courier;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.client.CourierClient;
import ru.yandex.praktikum.model.Courier;
import ru.yandex.praktikum.model.CourierCredentials;

import static org.hamcrest.Matchers.equalTo;

public class LoginCourierTest {
    private CourierClient courierClient;
    private Courier courier;
    private int courierId;

    @Before
    @Step("Создаём тестового курьера")
    public void setUp() {
        courierClient = new CourierClient();
        courier = Courier.random();
        courierClient.createCourier(courier);
        courierId = courierClient.loginCourier(CourierCredentials.from(courier))
                .then().extract().path("id");
    }

    @After
    @Step("Удаляем тестового курьера")
    public void tearDown() {
        if (courierId != 0) {
            courierClient.deleteCourier(courierId);
        }
    }

    @Test
    @Step("Проверка успешного логина курьера")
    public void courierCanLogin() {
        courierClient.loginCourier(CourierCredentials.from(courier))
                .then().statusCode(200).body("id", equalTo(courierId));
    }

    @Test
    @Step("Проверка ошибки при неверном пароле")
    public void cannotLoginWithWrongPassword() {
        courierClient.loginCourier(new CourierCredentials(courier.getLogin(), "wrongPass"))
                .then().statusCode(404);
    }

    @Test
    @Step("Проверка ошибки при отсутствии логина")
    public void cannotLoginWithoutLogin() {
        courierClient.loginCourier(new CourierCredentials("", courier.getPassword()))
                .then().statusCode(400);
    }
}
