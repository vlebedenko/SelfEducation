package yandex.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import yandex.blocks.CityRightSideBlock;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class YandexMain {
    public YandexMain() {
    }
    public SelenideElement main = $(xpath("//div[contains(@class, 'col main widgets')]"));
    public SelenideElement searchField = $("[id='text']");
    public SelenideElement searchButton = $("[type='submit']");

    public CityRightSideBlock cityRightSideBlock = new CityRightSideBlock();

    public void waitTillPageLoaded() {
        main.waitUntil(Condition.visible, 10000);
    }
}

