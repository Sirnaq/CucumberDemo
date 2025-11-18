package pl.testeroprogramowania.utils.selenium.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends BasePage {

    @FindBy(xpath = "//*[contains(text(),'My account')" +
            " and not (ancestor-or-self::*[contains(@class,'mobile-navbar__wrapper')])]")
    private WebElement myAccountButton;

    public void myAccountButtonClick() {
        myAccountButton.click();
    }

    public NavigationBar(WebDriver driver) {
        super(driver);
    }
}
