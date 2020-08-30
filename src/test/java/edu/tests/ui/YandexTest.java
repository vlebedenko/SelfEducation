package edu.tests.ui;

import edu.pages.YandexMain;
import edu.preconditions.Preconditions;
import io.qameta.allure.Description;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class YandexTest {

    YandexMain yandexMain = new YandexMain();
    public String yandex = "https://yandex.ru/";
    public String google = "https://www.google.com/";
    public String randomCity;


    @Before
    public void openUrl() {
        new Preconditions().openUrl(yandex);

        List<String> cities = new ArrayList<>();
        cities.add("Ярославль");
        cities.add("Рыбинск");
        cities.add("Новосибирск");
        cities.add("Казань");
        cities.add("Томск");

        Random random = new Random();
        randomCity = cities.get(random.nextInt(cities.size()));
    }

    @Test
    @Description("Описание теста 1")
    @DisplayName("Тест 1. Поиск погоды в городах")
    public void searchCityWeatherTest() {
        yandexMain.searchField.val("Погода " + randomCity);
        yandexMain.searchButton.should(visible).click();
        assertThat(yandexMain.searchField.should(visible).getValue())
                .isEqualTo("Погода " + randomCity)
                .as("Проверяем, что введённое значение в поле поиска не сбросилось");
        yandexMain.cityRightSideBlock.city.should(visible, text(randomCity));
        yandexMain.cityRightSideBlock.weather.should(visible);
    }

    @Test
    @Description("Описание теста 2")
    @DisplayName("Тест 2. Проверка результатов поиска")
    public void resultTest() {
        yandexMain.searchField.val("Погода " + randomCity);
        yandexMain.searchButton.should(visible).click();
        yandexMain.checkUrlText(1, "Яндекс.Погода");
    }

    @Test
    @Description("Описание теста 3")
    @DisplayName("Тест 3. Проверка поиска после пустого запроса")
    public void emptyResultTest() {
        yandexMain.searchField.val(" ");
        yandexMain.searchButton.should(visible).click();
        yandexMain.emptyResultMessage.should(visible, text("Задан пустой поисковый запрос"));
    }
}
