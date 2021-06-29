package pages;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "login_field")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "commit")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage() {
        driver.navigate().to("https://github.com/login");
        return this;
    }

    public LoginPage fillSignInForm(User user){
        loginInput.sendKeys(user.getUsername());
        passwordInput.sendKeys(user.getPassword());
        return this;
    }

    public MainPage submitSignInForm(WebDriver driver){
        submitButton.click();
        return new MainPage(driver);
    }






}
