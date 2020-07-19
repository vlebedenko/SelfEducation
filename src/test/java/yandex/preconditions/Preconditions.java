package yandex.preconditions;

import yandex.pages.YandexMain;

import static com.codeborne.selenide.Selenide.open;

public class Preconditions {

    public void openUrl(String url) {
        open(url);
        new YandexMain().waitTillPageLoaded();
    }
}
