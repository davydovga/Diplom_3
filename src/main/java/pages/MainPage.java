package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;


public class MainPage extends BasePage {
	public MainPage(WebDriver driver) {
		super(driver);
	}

	private final By BunsSpan = By.xpath(mainXPath + "/section[1]//div[1]/span");
	private final By selectedBunSpan = By.xpath(".//div[1][contains(@class, 'tab_type_current')]");

	private final By SaucesSpan = By.xpath(mainXPath + "/section[1]//div[2]/span");
	private final By selectedSaucesSpan = By.xpath(".//div[2][contains(@class, 'tab_type_current')]");

	private final By FillingsSpan = By.xpath(mainXPath + "/section[1]//div[3]/span");
	private final By selectedFillingsSpan = By.xpath(".//div[3][contains(@class, 'tab_type_current')]");

	private final String loginButtonText = "Войти в аккаунт";
	private final By loginButton = findButtonWith(loginButtonText);

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}

	@Step("Нажатие на 'Булки' и проверка что выбран нужный элемент")
	public void clickBunsSpanAndCheckSelected() {
		driver.findElement(BunsSpan).click();
		driver.findElement(selectedBunSpan);
	}

	@Step("Нажатие на 'Соусы' и проверка что выбран нужный элемент")
	public void clickSaucesSpanAndCheckSelected() {
		driver.findElement(SaucesSpan).click();
		driver.findElement(selectedSaucesSpan);
	}

	@Step("Нажатие на 'Начинки' и проверка что выбран нужный элемент")
	public void clickFillingsSpanAndCheckSelected() {
		driver.findElement(FillingsSpan).click();
		driver.findElement(selectedFillingsSpan);
	}
}
