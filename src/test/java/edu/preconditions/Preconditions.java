package edu.preconditions;

import edu.pages.YandexMain;

import static com.codeborne.selenide.Selenide.open;

public class Preconditions {

    public void openUrl(String url) {
        open(url);
        new YandexMain().waitTillPageLoaded();
    }
}
