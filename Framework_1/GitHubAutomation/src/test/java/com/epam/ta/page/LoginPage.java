package com.epam.ta.page;

import com.epam.ta.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {
	private final Logger logger = LogManager.getRootLogger();
	private final String PAGE_URL = "https://www.sixt.com/#/?page=loginregister";

	private final WebDriverWait wait;
	@FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")
	private WebElement inputLogin;

	@FindBy(xpath = "//*[@id='pageSlideWrapper']/div/div[2]/form/div[1]/div[2]/div[1]/div/input")
	private WebElement inputPassword;

	@FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/div/div/div[2]/form/div[2]/div[2]/button")
	private WebElement buttonSubmit;

	@FindBy(xpath = "//*[@id=\"contentpage\"]/body/div[1]/div/a")
	private WebElement cookieButton;

    private final By errorMessage = By.xpath("/html/body/div[3]/div[1]/div[2]/div/div/div[2]/form/div[1]/p");

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(driver, 250);
	}

	@Override
	public LoginPage openPage() {
		driver.navigate().to(PAGE_URL);
		logger.info("Login page opened");
		return this;
	}

	public MainPage login(User user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")));
        inputLogin.sendKeys(user.getUsername());
        wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
        cookieButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div/div[2]/form/div[2]/div[2]/button")));
        buttonSubmit.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pageSlideWrapper']/div/div[2]/form/div[1]/div[2]/div[1]/div/input")));
        inputPassword.sendKeys(user.getPassword());
        wait.until(ExpectedConditions.elementToBeClickable(buttonSubmit));
        buttonSubmit.click();
		return new MainPage(driver);
	}

    public String getErrorMessage(User user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div/div[2]/form/div[1]/div/div/div/input")));
        inputLogin.sendKeys(user.getUsername());
        wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
        cookieButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div/div[2]/form/div[2]/div[2]/button")));
        buttonSubmit.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div/div[2]/form/div[1]/p")));
        WebElement blockWithErrorMessage = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        return blockWithErrorMessage.getText();
    }
}