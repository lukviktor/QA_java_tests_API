package specification;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import stellarburgers.IngredientData;
import stellarburgers.Order;

import static io.restassured.RestAssured.given;

public class OrderStep {

    @Step("Получение данных об ингредиентах")
    public IngredientData getIngredients() {
        return given()
                .header("Content-Type", "application/json")
                .log().all()
                .get("/api/ingredients")
                .body()
                .as(IngredientData.class);
    }

    @Step("Создание заказа с авторизацией. POST запрос на ручку /api/orders.")
    public Response createOrder(Order order, String accessToken) {
        return given().log().all()
                .header("Content-Type", "application/json")
                .header("authorization", accessToken)
                .body(order)
                .when()
                .post("/api/orders");
    }


}