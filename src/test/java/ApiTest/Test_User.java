package API;

import io.restassured.response.Response;
import org.example.API.BaseAPI;
import org.testng.annotations.Test;

import static org.apache.hc.core5.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;

public class Test_User {
    BaseAPI api = new BaseAPI();

    @Test(description = "Create User", priority = 1)
    public void userCreateTest() {
        Response response = api.createUser();
        response.then().assertThat().body("code", equalTo(200))
                .and()
                .statusCode(SC_OK);
        System.out.println(response.jsonPath().prettify());
        System.out.println("Пользователь успешно создан");
    }

    @Test(description = "Update User", priority = 2)
    public void userUpdateTest() {
        Response response = api.updateUser();
        response.then().assertThat().body("code", equalTo(200))
                .and()
                .statusCode(SC_OK);
        System.out.println(response.jsonPath().prettify());
        System.out.println("Данные пользователя успешно обновлены");
    }

    @Test(description = "Get Info User", priority = 3)
    public void userGetInfoTest() {
        Response response = api.getInfoUser();
        response.then().assertThat().body("username", equalTo(BaseAPI.usernameNew))
                .and()
                .statusCode(SC_OK);
        System.out.println(response.jsonPath().prettify());
        System.out.println("Данные пользователя успешно получены");
    }

    @Test(description = "Delete User", priority = 4)
    public void userDeleteTest() {
        Response response = api.deleteUser();
        response.then().assertThat()
                .and()
                .statusCode(SC_OK);
        System.out.println(response.jsonPath().prettify());
        System.out.println("Пользователь удален");
    }

    @Test(description = "Checking that the user has been deleted", priority = 5)
    public void checkDeleteUserTest() {
        Response response = api.getInfoUser();
        response.then().assertThat().body("message", equalTo("User not found"))
                .and()
                .statusCode(SC_NOT_FOUND);
        System.out.println(response.jsonPath().prettify());
        System.out.println("Пользователь не найден");
    }

}
