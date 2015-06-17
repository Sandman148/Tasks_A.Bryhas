package com.bryhas.project.mailrutest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bryhas.project.mailrutest.tools.ContextVisible;

/**
 * Author: Andrii Bryhas
 * Date: 10.06.15
 */

public class MailboxPage {
	
	private WebElement mailRuLink;
	
	public MailboxPage() {
		
		this.mailRuLink = ContextVisible.get().getVisibleWebElement(
				By.xpath("//tbody/tr/td[1]/a[1]"));
	}
	
	public LoggedInHomePage clickMailRuLink() {
		mailRuLink.click();
		return new LoggedInHomePage();
	}

}
