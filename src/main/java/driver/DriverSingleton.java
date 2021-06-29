package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverSingleton {

    private WebDriver driver;

    public DriverSingleton() {
    }

    public WebDriver getDriver() {
        if (null == driver) {
            switch (System.getProperty("browser")) {
                case "opera": {
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                }
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
            }
        }

        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(600, 800));
        return driver;
    }

    public void closeDriver(WebDriver driver) {
        driver.quit();
    }
}
