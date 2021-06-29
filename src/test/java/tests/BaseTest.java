package tests;

import driver.DriverSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.SearchPage;
import pages.StartPage;

public class BaseTest {
    protected WebDriver driver;
    protected String BASE_URL = "https://github.com/";

    StartPage startPage;
    LoginPage loginPage;
    MainPage mainPage;
    SearchPage searchPage;

    @BeforeEach
    public void setUp() {
        DriverSingleton ds = new DriverSingleton();
        driver = ds.getDriver();

        startPage = new StartPage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
    }

    @AfterEach
    public void stopBrowser() {
        DriverSingleton ds = new DriverSingleton();
        ds.closeDriver(driver);
    }
}
