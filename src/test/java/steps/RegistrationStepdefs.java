package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationStepdefs {
    @Given("Пользователь находится на странице регистрации")
    public void userOnRegistrationPage() {
        // TODO
    }

    @When("Пользователь регистрируется под логином {string} и паролем {string}")
    public void userRegisteredWithLoginAndPassword(String login, String password) {
        // TODO
    }

    @Then("Система сохраняет запись о регистрации и открывает главную страницу для созданного аккаунта")
    public void openMainPageAfterRegistration() {
        // TODO
    }

    @Given("Пользователь регистрируется под логином {string} и другой пользователь с таким же логином уже существует")
    public void userRegisteredWithLoginAndOtherUserWithSameLoginExists(String login) {
        // TODO
    }

    @Then("Система выдаёт пользователю сообщение об ошибке {string}")
    public void showRegistrationErrorMessageToUser(String errorMessage) {
        // TODO
    }
}
