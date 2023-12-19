package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class BookmarkStepdefs {
    private FirefoxDriver driverFirefox;
    
 	public void signup(String username, String password, String email) {
 		driverFirefox.get("http://localhost:8080/registration");
 		
 		driverFirefox.findElement(By.name("username")).sendKeys(username);
 		driverFirefox.findElement(By.name("password")).sendKeys(password);
 		driverFirefox.findElement(By.name("email")).sendKeys(email);
 		driverFirefox.findElement(By.id("registration_submit")).click();
 	}
 	
 	public void login(String username, String password) {
 		driverFirefox.get("http://localhost:8080/authorization");
 		
 		driverFirefox.findElement(By.name("username")).sendKeys(username);
 		driverFirefox.findElement(By.name("password")).sendKeys(password);
 		driverFirefox.findElement(By.id("enter_submit")).click();	
 	}
 	
 	public void logout() {
 		driverFirefox.get("http://localhost:8080/catalog");
 		
 		driverFirefox.findElement(By.id("logout")).click();
 	}
 	
 	@Before
	public void prepare() {
 		System.setProperty("webdriver.gecko.driver", "C:/geckodriver/geckodriver.exe");
 		
 		driverFirefox = new FirefoxDriver();
        driverFirefox.manage().window().maximize();
        driverFirefox.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        signup("user1", "123", "user1@mail.ru");
        login("user1", "123");
	}
    
    @Дано("Пользователь находится на странице с фильмом")
    public void userOnFilmPage() {		
		driverFirefox.get("http://localhost:8080/catalog");
    }
    
    @Когда("Пользователь добавляет фильм {string} в закладки")
    public void userAddFilmToBookmarks(String title) {
    	driverFirefox.findElement(By.id(title)).click();
		driverFirefox.findElement(By.id("add_bookmark_submit")).click();
    }
    
    @Тогда("Фильм {string} добавляется в закладках в профиле пользователя")
    public void filmAddedToUserBookmarks(String title) {
    	driverFirefox.findElement(By.id("profile")).click();
		
		Boolean isPresent = driverFirefox.findElements(By.id(title)).size() > 0;
		assertEquals(isPresent, true);
    }
    
    @Когда("Пользователь удаляет фильм {string} из закладок")
    public void userRemoveFilmFromBookmarks(String title) {
    	driverFirefox.findElement(By.id(title)).click();
    	driverFirefox.findElement(By.id("remove_bookmark_submit")).click();
    }
    
    @Тогда("Фильм {string} отсутствует в закладках в профиле пользователя")
    public void filmRemovedFromUserBookmarks(String title) {
    	driverFirefox.findElement(By.id("profile")).click();
		
		Boolean isPresent = driverFirefox.findElements(By.id(title)).size() > 0;
		assertEquals(isPresent, false);
    }
    
    @After
	public void quit() {
		logout();
		driverFirefox.quit();
	}
}
