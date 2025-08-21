package ru.yandex.praktikum.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Courier {

    @JsonProperty("login")
    private String login;
    @JsonProperty("password")
    private String password;
    @JsonProperty("firstName")
    private String firstName;

    public Courier(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    public Courier() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public static Courier random() {
        return new Courier(
                "login" + System.currentTimeMillis(),
                "password123",
                "TestName"
        );
    }
}
