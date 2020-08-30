package edu.blocks;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CityRightSideBlock {
    public CityRightSideBlock() {
    }
    public SelenideElement city = $("[class='entity-search__header'] .serp-title_type_supertitle");
    public SelenideElement weather = $(By.xpath("//ul[contains(@class, 'key-value key-value_layout_default')]" +
            "//b[contains(text(), 'Погода: ')]"));
}
