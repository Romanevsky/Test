package org.example.API;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseAPI {
    public static String username = "Test";
    public static String usernameNew = "TestNEW";
    public static final String URL = "https://petstore.swagger.io/v2/";
    public static final String createUser = "user";
    public static final String updateUser = "user/" + username;
    public static final String getInfoUser = "user/" + usernameNew;
    public static final String deleteUser = "user/" + usernameNew;

    String requestBody = "{\"id\": 0, " +
            "\"username\": \"" + username + "\", " +
            "\"firstName\": \"Roman\", " +
            "\"lastName\": " + "\"Testov\", " +
            "\"email\": \"test@test.com\", " +
            "\"password\": " + "\"testPassword\", " +
            "\"phone\": \"79009009900\", " +
            "\"userStatus\": 0}";

    String requestBodyUpdate = "{\"id\": 1, " +
            "\"username\": \"" + usernameNew + "\", " +
            "\"firstName\": \"RomanNew\", " +
            "\"lastName\": " + "\"TestovNew\", " +
            "\"email\": \"testNEW@test.com\", " +
            "\"password\": " + "\"newPassword\", " +
            "\"phone\": \"79009778899\", " +
            "\"userStatus\": 1}";

    @Step("Создание пользователя")
    public Response createUser() {
        return RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .baseUri(URL)
                .post(createUser);
    }

    @Step("Обновление данных пользователя")
    public Response updateUser() {
        return RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyUpdate)
                .when()
                .baseUri(URL)
                .put(updateUser);
    }

    @Step("Получение данных пользователя")
    public Response getInfoUser() {
        return RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .when()
                .baseUri(URL)
                .get(getInfoUser);
    }

    @Step("Удаление пользователя")
    public Response deleteUser() {
        return RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .when()
                .baseUri(URL)
                .delete(deleteUser);
    }


}

