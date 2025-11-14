package pl.testeroprogramowania.utils.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountPage extends NavigationBar {

    //Error message
    private final By byAccountAlreadyRegisteredError =
            Locators.findByText("Error: An account is already registered with your email address. Please log in.");

    //Registration form
    private final By byRegistrationEmailField = By.id("reg_email");
    private final By byRegistrationPasswordField = By.id("reg_password");
    private final By byRegisterButton = Locators.buttonText("Register");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void fillRegistrationForm(String email, String password) {
        WebElement registrationEmailField = driver.findElement(byRegistrationEmailField);
        WebElement registrationPasswordField = driver.findElement(byRegistrationPasswordField);

        registrationEmailField.clear();
        registrationEmailField.sendKeys(email);
        registrationPasswordField.clear();
        registrationPasswordField.sendKeys(password);
    }

    public boolean isRegistrationFormDisplayed() {
        List<WebElement> registrationEmailField = driver.findElements(byRegistrationEmailField);
        List<WebElement> registrationPasswordField = driver.findElements(byRegistrationPasswordField);
        List<WebElement> registerButtonElements = driver.findElements(byRegisterButton);
        return !(registrationEmailField.isEmpty() &&
                registrationPasswordField.isEmpty() &&
                registerButtonElements.isEmpty());
    }

    public boolean isAccountAlreadyRegisteredErrorPresent() {
        return driver.findElements(byAccountAlreadyRegisteredError).getFirst().isDisplayed();
    }

    public void registerButtonClick() {
        driver.findElement(byRegisterButton).click();
    }

    public WebElement getHeaderWithText(String text) {
        return driver.findElement(Locators.headerText(text));
    }
}
