package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected final String BASE_URL = "https://github.com/";

    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
//        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }
}
