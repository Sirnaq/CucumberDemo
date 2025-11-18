package stepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pl.testeroprogramowania.utils.selenium.demo.MyAccountPage;
import pl.testeroprogramowania.utils.selenium.demo.PageManager;
import pl.testeroprogramowania.utils.selenium.demo.Task;

import java.util.List;
import java.util.Map;

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
        Assert.assertTrue(myAccountPage.getLinkWithText("Logout").isDisplayed());
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

    @And("User submits email{string} and password {string}")
    public void userSubmitsEmailAndPassword(String email, String password) {
        myAccountPage.fillRegistrationForm(email, password);
        myAccountPage.registerButtonClick();
    }

    @And("User submits tasks to execute")
    public void userSubmitsTasksToExecute(List<Task> tasks) {
        /** userSubmitTasks przyjmuje domyślnie DataTable ale można od razu podmienić na Listę albo na Mapę
         W ostatecznej implementacji podmieniliśmy na Listę obiektów z klasy Tasks
         tutaj przykład jakby to wyglądało dla DataTable z zamianą na listę, trzeba tylko zmienić tabelę w feature file
         na taką z jedną kolumną:
         DataTable dataTable
         List<String> tasksList = dataTable.asList();
         tasksList.forEach(System.out::println); **/

        tasks.forEach(task -> System.out.println("%s: %s Status: %s".formatted(
                task.getName(),
                task.getDescription(),
                task.getStatus()
        )));
    }

    /**
     * Data table type pozwala tłumaczyć tabele cucumbera na obiekt klasy
     **/

    @DataTableType
    public Task handleTask(Map<String, String> table) {
        return new Task(table.get("name"), table.get("description"), table.get("status"));
    }
}