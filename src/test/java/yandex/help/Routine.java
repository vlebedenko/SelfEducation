package yandex.help;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.is;

public class Routine {
    private Response response;
    private String serviceUrl = "https://ipvigilante.com";

    @Step("Проверяем получаем ответ в формате .json для переданного IP-адреса")
    public void checkYourIp(String ip) {
        response = SerenityRest.given().when().get(serviceUrl + "/" + ip);
    }

    @Step("Проверяем успешность выполнения запроса к api")
    public void searchIsExecutedSuccesfully() {
        response.then().statusCode(200);
    }

    @Step("Проверяем поле 'Страна' в полученном ответе")
    public void iShouldGetCountry(String country) {
        response.then().body("data.country_name", is(country));
    }
}

