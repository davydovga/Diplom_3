package utils;

import api.requests.CreateUserReq;
import configuration.Generators;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import static api.api.CreateUserAPI.createUserAPI;
import static api.api.CreateUserAPI.deleteUserAPI;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class BaseTest {
		protected WebDriver driver;

		protected MainPage mainPage;
		protected LoginPage loginPage;
		protected RegisterPage regPage;
        protected AccountProfilePage accountProfilePage;
        protected Header header;
        protected ForgotPasswordPage forgotPasswordPage;

    @Before
    public void beforeEachTest (){
        String browser = System.getenv("BROWSER");
        driver = WebDriverFactory.getDriver(browser == null ? "chrome" : browser);


				this.mainPage = new MainPage(driver);
				this.loginPage = new LoginPage(driver);
				this.regPage = new RegisterPage(driver);
                this.accountProfilePage = new AccountProfilePage(driver);
                this.header = new Header(driver);
                this.forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    protected Generators userDataGenerator = new Generators();
    protected CreateUserReq createUser = userDataGenerator.createUser();
    protected Response response = createUserAPI(createUser);


    @Step("Ожидание загрузки страницы")
    public void awaitOfURLChange(String URL){
        try {
            new WebDriverWait(driver, 5).until(urlContains(URL));
        } catch (TimeoutException timeOut){
            System.out.println("Время ожидания загрузки страницы " + URL + " превысило допустимое");
            timeOut.printStackTrace();
        }

    }

    @After
    @Step("Закрытие барузера и удаление тестового пользователя")
    public void closeBrowserAfterTest (){
        deleteUserAPI(userDataGenerator.parseToken(response));
        driver.quit();
    }
}
