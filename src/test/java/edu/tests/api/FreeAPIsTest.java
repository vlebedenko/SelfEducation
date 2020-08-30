package edu.tests.api;

import edu.help.Routine;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
public class FreeAPIsTest {

    @Steps
    Routine routine;

    @Test
    public void usaTest() {

        RestAssured
                .when()
                .get("https://ipvigilante.com/8.8.8.8")
                .then()
                .assertThat().statusCode(200)
                .body("data.continent_name", is("North America"))
                .body("data.country_name", is("United States"));
    }

    @Test
    public void russiaTest() {
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri("https://ipvigilante.com")
                .basePath("/178.215.144.157")
                .when()
                .get()
                .then()
                .assertThat().statusCode(200)
                .body("data.continent_name", is("Europe"))
                .body("data.country_name", is("Russia"))
                .log()
                .body()
                .body(matchesJsonSchemaInClasspath("ipVigilanteSchema.json"));
    }

    @Test
    public void serenityStepsTest() {
        routine.checkYourIp("178.215.144.157");
        routine.searchIsExecutedSuccessfully();
        routine.iShouldGetCountry("Russia");
    }

   /* @Test
    @Ignore
    public void negativeSerenityStepsTest() {
        routine.checkYourIp("192.264.134.131");
        routine.searchIsExecutedSuccessfully();
        routine.iShouldGetCountry("Russia");
    }*/

}
