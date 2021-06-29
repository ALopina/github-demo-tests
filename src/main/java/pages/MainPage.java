package pages;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(css = "[aria-label='View profile and more']")
    private WebElement profileButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean userIsSignedIn(User user) throws InterruptedException {
        profileButton.click();
        Thread.sleep(3000);

        return driver.findElement(By.cssSelector(".dropdown-menu.dropdown-menu-sw a[href='/"+
                user.getUsername()+"']")).isDisplayed();
    }

}
