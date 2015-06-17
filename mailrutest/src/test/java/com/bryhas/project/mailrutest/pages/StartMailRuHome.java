package com.bryhas.project.mailrutest.pages;

import com.bryhas.project.mailrutest.tools.IBrowser;
import com.bryhas.project.mailrutest.tools.WebDriverUtils;

/**
 * Author: Andrii Bryhas
 * Date: 10.06.15
 */

public class StartMailRuHome extends MailRuHome {

	private StartMailRuHome() {
		super();
	}

	public static StartMailRuHome load(IBrowser browser, String url) {
		
		WebDriverUtils.get(browser).load(url);
		return new StartMailRuHome();
	}
}
