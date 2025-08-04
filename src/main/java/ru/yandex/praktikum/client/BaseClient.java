package ru.yandex.praktikum.client;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseClient {

    private static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/api/v1/";

    protected RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured()) // чтобы шаги логировались в Allure
                .build();
    }

    protected io.restassured.specification.RequestSpecification givenRequest() {
        return given().spec(requestSpec());
    }
}
