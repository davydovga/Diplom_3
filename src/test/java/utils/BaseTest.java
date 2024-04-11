package utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseTest {
		protected WebDriver driver;

		protected MainPage mainPage;
		protected LoginPage loginPage;
		protected RegisterPage regPage;
        protected AccountProfilePage accountProfilePage;
        protected Header header;

    @Before
    public void beforeEachTest (){
        String browser = System.getenv("BROWSER");
        driver = WebDriverFactory.getDriver(browser == null ? "chrome" : browser);
        driver.get("https://stellarburgers.nomoreparties.site/");

				this.mainPage = new MainPage(driver);
				this.loginPage = new LoginPage(driver);
				this.regPage = new RegisterPage(driver);
                this.accountProfilePage = new AccountProfilePage(driver);
                this.header = new Header(driver);
    }

    @After
    public void closeBrowserAfterTest (){
        driver.quit();
    }
}
