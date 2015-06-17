package com.bryhas.project.mailrutest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bryhas.project.mailrutest.tools.ContextVisible;

/**
 * Author: Andrii Bryhas
 * Date: 10.06.15
 */

public class LoggedInHomePage {
	
	private WebElement weatherNowTemp;
	private WebElement weatherNearTemp;
	private WebElement weatherTomorrowTemp;
	private WebElement logout;
	
	public LoggedInHomePage() {
		
		this.weatherNowTemp = ContextVisible.get().getVisibleWebElement(
				By.id("weather:item:now_temp"));
		this.weatherNearTemp = ContextVisible.get().getVisibleWebElement(
				By.id("weather:item:near"));
		this.weatherTomorrowTemp = ContextVisible.get().getVisibleWebElement(
				By.id("weather:item:tomorrow_temp"));
		this.logout = ContextVisible.get().getVisibleWebElement(
				By.id("PH_logoutLink"));
	}
	
	// getters
	
	public WebElement getWeatherNowTemp() {
		return weatherNowTemp;
	}
	
	public WebElement getWeatherNearTemp() {
		return weatherNearTemp;
	}
	
	public WebElement getWeatherTomorrowTemp() {
		return weatherTomorrowTemp;
	}
	
	public MailRuHome logout() {
		this.logout.click();
		return new MailRuHome();
	}
}
