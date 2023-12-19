package selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BookmarkTest {
	public WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	// Регистрация
	public void signup(String username, String password, String email) {
		driver.get("http://localhost:8080/registration");
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.id("registration_submit")).click();
	}
	
	// Вход
	public void login(String username, String password) {
		driver.get("http://localhost:8080/authorization");
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("enter_submit")).click();	
	}
	
	// Выход
	public void logout() {
		driver.get("http://localhost:8080/catalog");
		
		driver.findElement(By.id("logout")).click();
	}
	
	// Добавление и удаление фильма из закладок
	@Test
	public void addAndRemoveFilmBookmarkTest() {
		signup("user1", "123", "my@mail.ru");
		login("user1", "123");

		driver.get("http://localhost:8080/catalog");
		
		driver.findElement(By.id("Coraline")).click();
		driver.findElement(By.id("add_bookmark_submit")).click();
		driver.findElement(By.id("profile")).click();
		
		Boolean isPresent = driver.findElements(By.id("Coraline")).size() > 0;
		assertEquals(isPresent, true);
		
		driver.get("http://localhost:8080/catalog");
		
		driver.findElement(By.id("Coraline")).click();
		driver.findElement(By.id("remove_bookmark_submit")).click();
		driver.findElement(By.id("profile")).click();
		
		isPresent = driver.findElements(By.id("Coraline")).size() > 0;
		assertEquals(isPresent, false);	
	}
	
	@After
	public void quit() {
		logout();
		driver.quit();
	}
}
