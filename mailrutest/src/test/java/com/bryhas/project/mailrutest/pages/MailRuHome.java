package com.bryhas.project.mailrutest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bryhas.project.mailrutest.data.IUser;
import com.bryhas.project.mailrutest.tools.ContextVisible;

/**
 * Author: Andrii Bryhas
 * Date: 10.06.15
 */

public class MailRuHome {
	
//	private WebElement authLink;
	private WebElement login;
	private WebElement password;
	private WebElement mailboxAuthButton;
	
	public MailRuHome() {
		
		this.login = ContextVisible.get().getVisibleWebElement(
				By.id("mailbox__login"));
		this.password = ContextVisible.get().getVisibleWebElement(
				By.id("mailbox__password"));
		this.mailboxAuthButton = ContextVisible.get().getVisibleWebElement(
				By.id("mailbox__auth__button"));
	}
	
	private void setLoginData(IUser user) {
		this.login.click();
		this.login.clear();
		this.login.sendKeys(user.getLoginName());
		this.password.click();
		this.password.clear();
		this.password.sendKeys(user.getPassword());
		this.mailboxAuthButton.click();
	}
	
	// getters
	
	public WebElement getLogin() {
		return login;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getMailboxAuthButton() {
		return mailboxAuthButton;
	}
	
	// login method
	
	public MailboxPage successTestUserLogin(IUser testUser) {
			setLoginData(testUser);
			// Return a new page object representing the destination.
			return new MailboxPage();
		}

}
