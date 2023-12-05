package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTest {
    public static final String SITE = "http://localhost:8080";

    private static void SetWebDriverLocationProperty() {
        System.setProperty("webdriver.gecko.driver", "C:/firefoxdriver/geckodriver.exe");
    }

    @Test
    public void TestBrowserStart() {
        final int TIMEOUT_SECONDS = 3;

        SetWebDriverLocationProperty();

        FirefoxDriver driverFirefox = new FirefoxDriver();
        WebDriverWait waitFirefox = new WebDriverWait(driverFirefox, Duration.ofSeconds(TIMEOUT_SECONDS));

        driverFirefox.navigate().to(SITE);
        driverFirefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT_SECONDS));
        waitFirefox.until(ExpectedConditions.titleIs("Authorization"));
        driverFirefox.findElement(By.ById.id("registration_link")).click();
        waitFirefox.until(ExpectedConditions.titleIs("Registration"));

        driverFirefox.findElement(By.ByName.name("username")).sendKeys("t");
        driverFirefox.findElement(By.ByName.name("password")).sendKeys("t");
        driverFirefox.findElement(By.ById.id("registration_submit")).click();
        waitFirefox.until(ExpectedConditions.titleIs("Catalog"));
        waitFirefox.until(ExpectedConditions.titleIs("Catalog1"));

        driverFirefox.quit();
    }
}
