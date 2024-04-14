package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BasePage;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


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
		hideElementForFirefox();

		driver.findElement(loginButton).click();
	}

	@Step("Нажатие на 'Булки' и проверка что выбран нужный элемент")
	public void clickBunsSpanAndCheckSelected() {
		try{
			hideElementForFirefox();

			driver.findElement(BunsSpan).click();
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOfElementLocated(selectedBunSpan));
			driver.findElement(selectedBunSpan);
		} catch (NoSuchElementException noSuchElementException) {
			System.out.println("Проблемы с отображением элементов полсе нажатия на 'Булки' в конструкторе заказа.");
			noSuchElementException.notify();
		}
	}

	@Step("Нажатие на 'Соусы' и проверка что выбран нужный элемент")
	public void clickSaucesSpanAndCheckSelected() {
		try{
			hideElementForFirefox();

			driver.findElement(SaucesSpan).click();
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOfElementLocated(selectedSaucesSpan));
			driver.findElement(selectedSaucesSpan);
		} catch (NoSuchElementException noSuchElementException) {
			System.out.println("Проблемы с отображением элементов полсе нажатия на 'Соусы' в конструкторе заказа.");
			noSuchElementException.notify();
		}
	}

	@Step("Нажатие на 'Начинки' и проверка что выбран нужный элемент")
	public void clickFillingsSpanAndCheckSelected() {
		try{
			hideElementForFirefox();

			driver.findElement(FillingsSpan).click();
			driver.findElement(selectedFillingsSpan);
		} catch (NoSuchElementException noSuchElementException) {
			System.out.println("Проблемы с отображением элементов полсе нажатия на 'Начинки' в конструкторе заказа.");
			noSuchElementException.notify();
		}
	}
}
