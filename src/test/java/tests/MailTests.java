package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MailTests extends BaseTest {

    @Test
    public void checkSerachResultsNumberTest() {

        driver.get("https://mail.ru/");

        WebElement input = driver.findElement(By.cssSelector("[data-testid='search-input']"));
        input.sendKeys("mail");
        input.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#js-result")));

        // Size results
        List<WebElement> results = driver.findElements(By.xpath("//*[@id='js-result']//li//h3//a"));
        Assertions.assertEquals(10, results.size());

        //     //*[@id='js-result']//li//h3//a//b[.='Mail']

        for (WebElement element : results) {
            Assertions.assertTrue(element.getText().toLowerCase().contains("mail"), "Text is: " + element.getText());
        }
    }
}
