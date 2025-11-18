package pl.testeroprogramowania.utils.selenium.demo;

import org.openqa.selenium.By;

public class Locators {

    public static By buttonText(String text) {
        return By.xpath("//button[normalize-space() = '%s']".formatted(text));
    }

    public static By headerText(String text) {
        return By.xpath("//h1[normalize-space() = '%s']".formatted(text));
    }

    public static By findByText(String text) {
        return By.xpath("//*[normalize-space() = '%s']".formatted(text));
    }

    private Locators() {
    }
}
