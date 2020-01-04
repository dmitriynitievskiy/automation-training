package com.epam.ta.test;

import com.epam.ta.model.User;
import com.epam.ta.page.LoginPage;
import com.epam.ta.service.UserCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class UserAccessTests extends CommonConditions {

	public static final String TESTDATA_SIXT_CARD = "Sixt Card 35675784";

	@Test(testName = "Test-case-1 : Correct login")
	public void oneCanLoginSixt()
	{
		User testUser = UserCreator.withCredentialsFromProperty();
		String loggedInUserName = new LoginPage(driver)
				.openPage()
				.login(testUser)
				.getLoggedInUserName();
		assertThat(loggedInUserName, is(equalTo(TESTDATA_SIXT_CARD)));
	}

	@Test(testName = "Test-case-2 : Attempt to login with not-registered username")
	public void loginWithNotRegisteredUsernameSixt()
	{
		User testUser = UserCreator.withIncorrectUsername();
		String errorMessage = new LoginPage(driver)
				.openPage()
				.getErrorMessage(testUser);
		assertThat(errorMessage, is(equalTo("rocks.pro@mail.ru looks new to us.\nWe would be happy to get to know you. Register now!")));
	}
}
