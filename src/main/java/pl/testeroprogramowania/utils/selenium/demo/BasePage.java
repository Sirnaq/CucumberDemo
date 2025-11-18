package pl.testeroprogramowania.utils.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getHeaderWithText(String text) {
        return driver.findElement(Locators.headerText(text));
    }

    public WebElement getLinkWithText(String text) {
        return driver.findElement(By.linkText(text));
    }
}
