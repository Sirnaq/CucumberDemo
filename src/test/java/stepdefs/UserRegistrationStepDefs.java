package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistrationStepDefs {

    @Given("User is on the main page of the shop")
    public void user_is_on_the_main_page_of_the_shop() {
        System.out.println("Przejście na stronę główną sklepu");
    }

    @When("Go to the My Account page")
    public void go_to_the_my_account_page() {
        System.out.println("Przejście do strony My Account");
    }

    @When("User puts correct data to the registration form")
    public void user_puts_correct_data_to_the_registration_form() {
        System.out.println("Wprowadzamy poprawne dane");
    }

    @Then("User is redirected to the My Account page")
    public void user_is_redirected_to_the_my_account_page() {
        System.out.println("użytkownik jest przekierowany do my account");
    }

    @Then("User registration form is not displayed")
    public void user_registration_form_is_not_displayed() {
        System.out.println("panel rejestracji nie jest wyświetlony");
    }

    @When("User puts incorrect data to the registration form")
    public void user_puts_incorrect_data_to_the_registration_form() {
        System.out.println("Podajemy  niepoprawne dane");
    }

    @Then("Incorrect e-mail error message is displayed")
    public void incorrect_e_mail_error_message_is_displayed() {
        System.out.println("Pojawia się error");
    }
}
