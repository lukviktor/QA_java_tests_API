package User;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import specification.UserStep;
import stellarburgers.User;

import static constant.ConstantUrlApi.BASE_URL;
import static constant.ConstantUserData.*;

public class ChangingUserDataTest {
    private final UserStep userStep = new UserStep();
    private String accessToken;
    private final User user = new User(USER_EMAIL, USER_PASSWORD, USER_NAME);

    private final String updateEmail = "vik" + USER_EMAIL;
    private final String updateName = USER_NAME + "vik";

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.filters(new AllureRestAssured());
        userStep.createUser(user);
        accessToken = userStep.accessTokenUser(user);
    }

    @DisplayName("Изменение данных пользователя")
    @Description("с авторизацией")
    @Test
    public void changingDataUserAuthorizationTest() {
        user.setEmail(updateEmail);
        user.setName(updateName);

        userStep.changingDataUser(user, accessToken)
                .then().log().all()
                .statusCode(HttpStatus.SC_OK)
                .and().assertThat().body("success", Matchers.is(true))
                .and().body("user.email", Matchers.is(updateEmail))
                .and().body("user.name", Matchers.is(updateName));
    }

    @DisplayName("Изменение данных пользователя")
    @Description("без авторизации")
    @Test
    public void changingDataUserNotAuthorizationTest() {
        user.setEmail(updateEmail);
        user.setName(updateName);

        userStep.changingDataUser(user, "")
                .then().log().all()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .and().assertThat().body("success", Matchers.is(false))
                .and().body("message", Matchers.is("You should be authorised"));
    }
    @After
    public void deleteUserTest() {
        if (accessToken != null) {
            userStep.deleteDataUser(accessToken);
        }
    }
}
