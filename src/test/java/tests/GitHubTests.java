package tests;


import driver.DriverSingleton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitHubTests {

    public WebDriver driver;

    @Test
    public void openGithubTest() {
        DriverSingleton ds = new DriverSingleton();
        driver = ds.getDriver();

        driver.navigate().to("https://github.com/");

        String mainTitle = driver.findElement(By.cssSelector(".home-hero h1")).getText();
        Assertions.assertEquals("Where the world builds software", mainTitle);

        ds.closeDriver(driver);
    }

}
