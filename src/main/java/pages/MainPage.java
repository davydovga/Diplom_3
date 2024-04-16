package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
		hideElementForFirefox();

		driver.findElement(loginButton).click();
	}

	@Step("Нажатие на 'Булки' и проверка что выбран нужный элемент")
	public void clickBunsSpan() {
		try{
			hideElementForFirefox();

			driver.findElement(BunsSpan).click();
		} catch (NoSuchElementException noSuchElementException) {
			System.out.println("Проблемы с отображением элементов после нажатия на 'Булки' в конструкторе заказа.");
			noSuchElementException.notify();
		}
	}

	@Step("Метод проверяет что текущий элемент 'Булки'")
	public boolean isCurrentElementBuns(){
		try {
			return driver.findElement(selectedBunSpan).isDisplayed();
		} catch (NoSuchElementException noSuchElementException){
			System.out.println("Элемент 'Булки' не отобразился");
		}
        return false;
    }

	@Step("Нажатие на 'Соусы' и проверка что выбран нужный элемент")
	public void clickSaucesSpan() {
		try{
			hideElementForFirefox();

			driver.findElement(SaucesSpan).click();
		} catch (NoSuchElementException noSuchElementException) {
			System.out.println("Проблемы с отображением элементов после нажатия на 'Соусы' в конструкторе заказа.");
			noSuchElementException.notify();
		}
	}

	@Step("Метод проверяет что текущий элемент 'Соусы'")
	public boolean isCurrentElementSauces(){
		try {
			return driver.findElement(selectedSaucesSpan).isDisplayed();
		} catch (NoSuchElementException noSuchElementException){
			System.out.println("Элемент 'Соусы' не отобразился");
		}
		return false;
	}

	@Step("Нажатие на 'Начинки' и проверка что выбран нужный элемент")
	public void clickFillingsSpan() {
		try{
			hideElementForFirefox();

			driver.findElement(FillingsSpan).click();
		} catch (NoSuchElementException noSuchElementException) {
			System.out.println("Проблемы с отображением элементов после нажатия на 'Начинки' в конструкторе заказа.");
			noSuchElementException.notify();
		}
	}

	@Step("Метод проверяет что текущий элемент 'Начинки'")
	public boolean isCurrentElementFillings(){
		try {
			return driver.findElement(selectedFillingsSpan).isDisplayed();
		} catch (NoSuchElementException noSuchElementException){
			System.out.println("Элемент 'Соусы' не отобразился");
		}
		return false;
	}
}
