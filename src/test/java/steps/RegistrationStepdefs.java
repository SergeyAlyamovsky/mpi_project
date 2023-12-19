package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationStepdefs {
    private static final int TIMEOUT_SECONDS = 3;
    public static final String SITE = "http://localhost:8080";

    private FirefoxDriver driverFirefox;
    private WebDriverWait waitFirefox;

    private static void setWebDriverLocationProperty() {
        System.setProperty("webdriver.gecko.driver", "C:/firefoxdriver/geckodriver.exe");
    }

    private void resetDriverAndDriverWait() {
        driverFirefox = new FirefoxDriver();
        waitFirefox = new WebDriverWait(driverFirefox, Duration.ofSeconds(TIMEOUT_SECONDS));
    }

    @Given("Пользователь находится на странице регистрации")
    public void userOnRegistrationPage() {
        resetDriverAndDriverWait();
        setWebDriverLocationProperty();

        driverFirefox.navigate().to(SITE);
        driverFirefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT_SECONDS));
        waitFirefox.until(ExpectedConditions.titleIs("Authorization"));
        driverFirefox.findElement(By.ById.id("registration_link")).click();
        waitFirefox.until(ExpectedConditions.titleIs("Registration"));
    }

    @When("Пользователь регистрируется под логином {string} и паролем {string} и почтой {string}")
    public void userRegisteredWithLoginAndPassword(String login, String password, String email) {
        driverFirefox.findElement(By.ByName.name("username")).sendKeys(login);
        driverFirefox.findElement(By.ByName.name("password")).sendKeys(password);
        driverFirefox.findElement(By.ByName.name("email")).sendKeys(email);
        driverFirefox.findElement(By.ById.id("registration_submit")).click();
    }

    @Then("Система сохраняет запись о регистрации и открывает главную страницу для созданного аккаунта")
    public void openMainPageAfterRegistration() {
        waitFirefox.until(ExpectedConditions.titleIs("Catalog"));
        driverFirefox.quit();
    }

    @Given("Пользователь регистрируется под логином {string} и другой пользователь с таким же логином уже существует")
    public void userRegisteredWithLoginAndOtherUserWithSameLoginExists(String login) {
        resetDriverAndDriverWait();
        setWebDriverLocationProperty();

        driverFirefox.navigate().to(SITE);
        driverFirefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT_SECONDS));
        waitFirefox.until(ExpectedConditions.titleIs("Authorization"));
        driverFirefox.findElement(By.ById.id("registration_link")).click();
        waitFirefox.until(ExpectedConditions.titleIs("Registration"));
    }

    @Then("Система выдаёт пользователю сообщение об ошибке {string}")
    public void showRegistrationErrorMessageToUser(String errorMessage) {
        boolean result = driverFirefox.findElement(By.ByClassName.className("validationError")).getText().equals(errorMessage);
        driverFirefox.quit();
    }

    @Given("Пользователь регистрируется под логином {string} и оставляет пустым поле {string}")
    public void userRegisteredWithLoginAndEmptyPassword(String login, String password) {
        resetDriverAndDriverWait();
        setWebDriverLocationProperty();

        driverFirefox.navigate().to(SITE);
        driverFirefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT_SECONDS));
        waitFirefox.until(ExpectedConditions.titleIs("Authorization"));
        driverFirefox.findElement(By.ById.id("registration_link")).click();
        waitFirefox.until(ExpectedConditions.titleIs("Registration"));

        driverFirefox.findElement(By.ByName.name("username")).sendKeys(login);
        driverFirefox.findElement(By.ByName.name("password")).sendKeys(password);
        driverFirefox.findElement(By.ById.id("registration_submit")).click();
    }

    @When("Пользователь нажимает кнопку регистрации")
    public void userRegistered() {
        driverFirefox.findElement(By.ById.id("registration_submit")).click();
    }

    @Given("Пользователь регистрируется под логином {string} и паролем {string} и неправильной почтой {string}")
    public void userRegisteredWithLoginPasswordAndWrongEmail(String login, String password, String email) {
        resetDriverAndDriverWait();
        setWebDriverLocationProperty();

        driverFirefox.navigate().to(SITE);
        driverFirefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT_SECONDS));
        waitFirefox.until(ExpectedConditions.titleIs("Authorization"));
        driverFirefox.findElement(By.ById.id("registration_link")).click();
        waitFirefox.until(ExpectedConditions.titleIs("Registration"));

        driverFirefox.findElement(By.ByName.name("username")).sendKeys(login);
        driverFirefox.findElement(By.ByName.name("password")).sendKeys(password);
        driverFirefox.findElement(By.ByName.name("email")).sendKeys(email);
    }
}
