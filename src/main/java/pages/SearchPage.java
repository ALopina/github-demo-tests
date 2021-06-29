package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(name = "q")
    private WebElement searchInput;

    @FindBy(css = "li.repo-list-item .f4 a")
    private List<WebElement> repoList;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage openPage() {
        driver.navigate().to("https://github.com/search");
        return this;
    }

    public void searchText(String text) {
        searchInput.sendKeys(text);
        searchInput.sendKeys(Keys.ENTER);
    }

    public List<WebElement> getRepoList() {
        return repoList;
    }
    public int countRepoMatchingText(String text) {
        ArrayList<String> repositoriesWithSearchingText = new ArrayList<String>();
        for (WebElement repository : repoList) {
            String href = repository.getText().toLowerCase();
            System.out.println("repository href text " + repoList.indexOf(repository) + " = " + href);

            if (repository.getText().toLowerCase().contains(text)) {
                repositoriesWithSearchingText.add(repository.getText());
            }
        }

        return repositoriesWithSearchingText.size();
}

}
