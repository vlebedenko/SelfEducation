package edu.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import edu.blocks.CityRightSideBlock;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class YandexMain {
    public YandexMain() {
    }
    public SelenideElement main = $(xpath("//div[contains(@class, 'col main widgets')]"));
    public SelenideElement searchField = $("[name='text']");
    public SelenideElement searchButton = $("[type='submit']");
    public SelenideElement weatherTitle = $("[id='main_title']");
    public SelenideElement weatherSubTitle = $("[id='forecast_briefly_title']");
    public SelenideElement emptyResultMessage = $("[class='misspell__message']");

    public CityRightSideBlock cityRightSideBlock = new CityRightSideBlock();

    public void waitTillPageLoaded() {
        main.waitUntil(visible, 10000);
    }

    @Step("Проверяем отображаемую URL у {index} элемента в результате поиска")
    public void checkUrlText(int index, String text) {
        $(xpath("(//a[contains(@class, 'link_theme_outer')]/b)[" + index + "]")).should(text(text));
    }
}

