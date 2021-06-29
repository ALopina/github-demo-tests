package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends AbstractPage {

    @FindBy(css = "a[href='/login']")
    private WebElement loginButton;

    @FindBy(name = "q")
    private WebElement searchInput;


    public StartPage(WebDriver driver) {
        super(driver);
    }

    public StartPage openPage(WebDriver driver) {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public LoginPage clickSignIn(WebDriver driver) {
        loginButton.click();
        return new LoginPage(driver);
    }

    public void searchText(String text) {
        searchInput.sendKeys(text);
        searchInput.sendKeys(Keys.ENTER);
    }

}
