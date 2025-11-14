package stepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pl.testeroprogramowania.utils.selenium.demo.MyAccountPage;
import pl.testeroprogramowania.utils.selenium.demo.PageManager;

public class UserRegistrationStepDefs {

    private final WebDriver driver = DriverHooks.getDriver();
    private final MyAccountPage myAccountPage = PageManager.myAccountPage(driver);

    @Given("User is on the main page of the shop")
    public void user_is_on_the_main_page_of_the() {
        driver.get("http://seleniumdemo.com/");
    }

    @When("Go to the My Account page")
    public void go_to_the_my_account_page() {
        myAccountPage.myAccountButtonClick();
    }

    @When("User puts correct data to the registration form")
    public void user_puts_correct_data_to_the_registration_form() {
        Faker faker = new Faker();
        myAccountPage.fillRegistrationForm(faker.internet().emailAddress(), "pAssword!@#$1\"");
        myAccountPage.registerButtonClick();
    }

    @Then("User is redirected to the My Account page")
    public void user_is_redirected_to_the_my_account_page() {
        Assert.assertTrue(myAccountPage.getHeaderWithText("My account").isDisplayed());
    }

    @Then("User registration form is not displayed")
    public void user_registration_form_is_not_displayed() {
        Assert.assertFalse(myAccountPage.isRegistrationFormDisplayed());
    }

    @When("User puts incorrect data to the registration form")
    public void user_puts_incorrect_data_to_the_registration_form() {
        myAccountPage.fillRegistrationForm("incorrect@data.com", "pAssword!@#$1\"");
        myAccountPage.registerButtonClick();
    }

    @Then("Incorrect e-mail error message is displayed")
    public void incorrect_e_mail_error_message_is_displayed() {
        Assert.assertTrue(myAccountPage.isAccountAlreadyRegisteredErrorPresent());
    }
}