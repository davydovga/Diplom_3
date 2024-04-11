package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;


public class MainPage extends BasePage {
	public MainPage(WebDriver driver) {
		super(driver);
	}

	private final By BunsSpan = By.xpath(mainXPath + "/section[1]//div[1]/span");
	private final String BunsSpanText = "Булки";

	private final By SaucesSpan = By.xpath(mainXPath + "/section[1]//div[2]/span");
	private final String SaucesSpanText = "Соусы";

	private final By FillingsSpan = By.xpath(mainXPath + "/section[1]//div[3]/span");
	private final String FillingsSpanText = "Начинки";

	private final String loginButtonText = "Войти в аккаунт";
	private final By loginButton = findButtonWith(loginButtonText);

	private final String createOrderButtonText = "Оформить заказ";
	private final By createOrderButton = findButtonWith(createOrderButtonText);

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}

	public void clickCreateOrderButton() {
		driver.findElement(createOrderButton).click();
	}

	public void clickBunsSpan() {
		driver.findElement(BunsSpan).click();
	}

	public void clickSaucesSpan() {
		driver.findElement(SaucesSpan).click();
	}

	public void clickFillingsSpan() {
		driver.findElement(FillingsSpan).click();
	}
}
