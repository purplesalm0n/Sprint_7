package ru.yandex.praktikum.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Order {

    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("address")
    private String address;
    @JsonProperty("metroStation")
    private String metroStation;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("rentTime")
    private int rentTime;
    @JsonProperty("deliveryDate")
    private String deliveryDate;
    @JsonProperty("color")
    private List<String> color;

    public Order(String firstName, String lastName, String address, String metroStation,
                 String phone, int rentTime, String deliveryDate, List<String> color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.color = color;
    }

    public static Order random(List<String> colors) {
        return new Order(
                "Иван",
                "Иванов",
                "Москва, ул. Тестовая, д.1",
                "Тестовая",
                "+79990001122",
                5,
                "2025-08-10",
                colors
        );
    }
}
