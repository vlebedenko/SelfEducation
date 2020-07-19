package yandex.blocks;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CityRightSideBlock {
    public CityRightSideBlock() {
    }
    public SelenideElement base = $(".serp-item card__narrow");
    public SelenideElement city = $(By.xpath("//div[contains(@class, 'serp-title serp-title_type_supertitle')]"));
    public SelenideElement weather = $(By.xpath("//ul[contains(@class, 'key-value key-value_layout_default')]" +
            "//b[contains(text(), 'Погода: ')]"));
}
