package pl.testeroprogramowania.utils.selenium.demo;

import org.openqa.selenium.WebDriver;

public class PageManager {

    public static MyAccountPage myAccountPage(WebDriver driver) {
        return new MyAccountPage(driver);
    }

    private PageManager() {
    }
}
