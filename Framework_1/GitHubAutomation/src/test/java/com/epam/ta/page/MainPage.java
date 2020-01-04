package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {
	private final String BASE_URL = "https://www.sixt.com/";
	private final WebDriverWait wait;
	private final By linkLoggedInUserLocator = By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div[5]/div/div[1]/div/span");

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(driver,30);
	}

	@Override
	public MainPage openPage() {
		driver.navigate().to(BASE_URL);
		return this;
	}

	public String getLoggedInUserName() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div[1]/div[1]/div/div[5]/div/div[1]/div/span")));
		WebElement linkLoggedInUser = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.presenceOfElementLocated(linkLoggedInUserLocator));
		return linkLoggedInUser.getText();
	}
}
