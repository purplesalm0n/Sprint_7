package ru.yandex.praktikum.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CourierCredentials {

    @JsonProperty("login")
    private String login;
    @JsonProperty("password")
    private String password;

    public CourierCredentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public CourierCredentials() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public static CourierCredentials from(Courier courier) {
        return new CourierCredentials(courier.getLogin(), courier.getPassword());
    }
}
