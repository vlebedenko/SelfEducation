package yandex.tests;

import org.junit.Before;
import org.junit.Test;
import yandex.pages.YandexMain;
import yandex.preconditions.Preconditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class Test1 {

    public String yandex = "https://yandex.ru/";
    public String google = "https://www.google.com/";
    public String randomCity;

    @Before
    public void openUrl() {
        new Preconditions().openUrl(yandex);
        new YandexMain().waitTillPageLoaded();

        List<String> cities = new ArrayList<String>();
        cities.add("Ярославль");
        cities.add("Москва");
        cities.add("Новосибирск");
        cities.add("Казань");
        cities.add("Екатеринбург");

        Random random = new Random();
        randomCity = cities.get(random.nextInt(cities.size()));
    }

    @Test
    public void searchCityWeatherTest() {
        YandexMain yandexMain = new YandexMain();
        yandexMain.searchField.val("Погода " + randomCity);
        yandexMain.searchButton.should(visible).click();
        yandexMain.cityRightSideBlock.city.should(visible, text(randomCity));
        yandexMain.cityRightSideBlock.weather.should(visible);
    }
}
