package tests;

import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.UserCreator;

public class GitHubLoginWithPageObjectTest extends BaseTest {

    protected User testUser;

    @Test
    public void positiveLoginTest() throws InterruptedException {
        testUser = UserCreator.withCredentialsFromProperty();

        startPage.openPage(driver);
        loginPage = startPage.clickSignIn(driver).fillSignInForm(testUser);
        mainPage = loginPage.submitSignInForm(driver);

        Assertions.assertTrue(mainPage.userIsSignedIn(testUser));
    }
}
