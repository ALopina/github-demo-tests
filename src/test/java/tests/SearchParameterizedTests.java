package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchParameterizedTests extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"junit", "testng"})
    @Tag("search")
    public void searchParameterizedStringTest(String textToSearch) throws InterruptedException {
        driver.navigate().to(BASE_URL);
        driver.findElement(By.cssSelector("[name='q']")).sendKeys(textToSearch);
        driver.findElement(By.cssSelector("[name='q']")).sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        List<WebElement> repositoriesFound =
                driver.findElements(By.cssSelector("li.repo-list-item .f4 a"));

        for (WebElement repository : repositoriesFound) {
            String href = repository.getText().toLowerCase();
            System.out.println("repository href text " + repositoriesFound.indexOf(repository) + " = " + href);
            Assertions.assertTrue(href.contains(textToSearch));
        }
    }


    @ParameterizedTest
    @CsvSource({"junit, 10", "testng, 8"})
    @Tag("search")
    public void searchParameterizedCSVTest(String textToSearch, int repositoriesFoundNumber) throws InterruptedException {
        driver.navigate().to(BASE_URL);
        driver.findElement(By.cssSelector("[name='q']")).sendKeys(textToSearch);
        driver.findElement(By.cssSelector("[name='q']")).sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        List<WebElement> repositoriesFound =
                driver.findElements(By.cssSelector("li.repo-list-item .f4 a"));
        ArrayList<String> repositoriesWithSearchingText = new ArrayList<String>();

        for (WebElement repository : repositoriesFound) {
            String href = repository.getText().toLowerCase();
            System.out.println("repository href text " + repositoriesFound.indexOf(repository) + " = " + href);

            if (repository.getText().toLowerCase().contains(textToSearch)) {
                repositoriesWithSearchingText.add(repository.getText());
            }
        }

        System.out.println("repos = " + repositoriesWithSearchingText.toString());
        Assertions.assertEquals(repositoriesFoundNumber, repositoriesWithSearchingText.size());
    }

    @ParameterizedTest
    @CsvFileSource(resources="/two-columns.csv")
    @Tag("search")
    public void searchParameterizedCSVFileTest(String textToSearch, int repositoriesFoundNumber) throws InterruptedException {
        driver.navigate().to(BASE_URL);
        driver.findElement(By.cssSelector("[name='q']")).sendKeys(textToSearch);
        driver.findElement(By.cssSelector("[name='q']")).sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        List<WebElement> repositoriesFound =
                driver.findElements(By.cssSelector("li.repo-list-item .f4 a"));
        ArrayList<String> repositoriesWithSearchingText = new ArrayList<String>();

        for (WebElement repository : repositoriesFound) {
            String href = repository.getText().toLowerCase();
            System.out.println("repository href text " + repositoriesFound.indexOf(repository) + " = " + href);

            if (repository.getText().toLowerCase().contains(textToSearch)) {
                repositoriesWithSearchingText.add(repository.getText());
            }
        }

        System.out.println("repos = " + repositoriesWithSearchingText.toString());
        Assertions.assertEquals(repositoriesFoundNumber, repositoriesWithSearchingText.size());
    }
}
