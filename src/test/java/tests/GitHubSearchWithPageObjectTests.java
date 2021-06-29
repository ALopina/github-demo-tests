package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class GitHubSearchWithPageObjectTests extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources="/two-columns.csv")
    @Tag("search")
    public void searchTest(String textToSearch, int repositoriesFoundNumber) throws InterruptedException {
        startPage.openPage(driver);
        startPage.searchText(textToSearch);

        Thread.sleep(3000);

        Assertions.assertEquals(repositoriesFoundNumber, searchPage.countRepoMatchingText(textToSearch));
    }

}
