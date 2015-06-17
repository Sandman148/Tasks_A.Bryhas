package com.bryhas.project.mailrutest.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bryhas.project.mailrutest.data.IUser;
import com.bryhas.project.mailrutest.data.UrlRepository.Urls;
import com.bryhas.project.mailrutest.data.UserRepository;
import com.bryhas.project.mailrutest.pages.LoggedInHomePage;
import com.bryhas.project.mailrutest.pages.MailboxPage;
import com.bryhas.project.mailrutest.pages.StartMailRuHome;
import com.bryhas.project.mailrutest.tools.BrowserRepository;
import com.bryhas.project.mailrutest.tools.IBrowser;
import com.bryhas.project.mailrutest.tools.SendMail;
import com.bryhas.project.mailrutest.tools.WebDriverUtils;

/**
 * Author: Andrii Bryhas
 * Date: 10.06.15
 */

public class WeatherTest {

	@DataProvider
	public Object[][] testUserProvider() {
		return new Object[][] { {
				BrowserRepository.getFirefoxByTemporaryProfile(),
				//BrowserRepository.getChromeByTemporaryProfile(),
				Urls.GLOBAL_HOST.toString(),
				UserRepository.getTestUser() },
		};
	}

	@Test(dataProvider = "testUserProvider")
	public void checkWeather(IBrowser browser, String url, IUser testUser) {
		// Steps
		
		//load firefox, go to mail.ru and login
		MailboxPage mailboxPage = StartMailRuHome.load(browser, url)
				.successTestUserLogin(testUser);
		
		//click Mail.Ru
		LoggedInHomePage loggedInHomePage = mailboxPage.clickMailRuLink();
		
		//get weather data and sent them to email
		SendMail.sendMailToInbox("Weather", (loggedInHomePage.getWeatherNowTemp().getText()+
				loggedInHomePage.getWeatherNearTemp().getText()+", "+
				loggedInHomePage.getWeatherTomorrowTemp().getText()));
				
		// Return to previous state
		loggedInHomePage.logout();
	}
		
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		WebDriverUtils.get().stop();
	}

}
