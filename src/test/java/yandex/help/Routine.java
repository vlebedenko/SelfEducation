package yandex.help;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.is;

public class Routine {
    private Response response;
    private String serviceUrl = "https://ipvigilante.com/";

    @Step
    public void checkYourIp(String ip) {
        response = SerenityRest.when().get(serviceUrl + ip);
    }

    @Step
    public void searchIsExecutedSuccesfully() {
        response.then().statusCode(200);
    }

    @Step
    public void iShouldGetCountry(String country) {
        response.then().body("data.country_name", is(country));
    }
}

