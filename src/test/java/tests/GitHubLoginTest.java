package tests;

import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import service.UserCreator;

public class GitHubLoginTest extends BaseTest {

    protected User testUser;

    @Test
    public void positiveLoginTest() throws InterruptedException {
        testUser = UserCreator.withCredentialsFromProperty();

        driver.navigate().to(BASE_URL);
        driver.findElement(By.cssSelector("a[href='/login']")).click();
        driver.findElement(By.cssSelector("#login_field")).sendKeys(testUser.getUsername());
        driver.findElement(By.cssSelector("#password")).sendKeys(testUser.getPassword());
        driver.findElement(By.cssSelector("[name='commit']")).click();

        Thread.sleep(3000);

        driver.findElement(By.cssSelector("[aria-label='View profile and more']")).click();

        Thread.sleep(3000);

        String currentUser = driver.findElement(By.cssSelector(".dropdown-menu.dropdown-menu-sw a[href='/"+
                testUser.getUsername()+"']")).getText();

        Assertions.assertTrue(currentUser.contains("Signed in as " + testUser.getUsername()));
    }

    /*
    @Test
    public void negativeLoginTest(User user) {

        testUser = UserCreator.withCredentialsFromProperty();


        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage()
                .loginWithWrongCredentials(user);

        Assert.assertFalse(loginPage.submitButtonIsAvailable());
    }
     */


}
