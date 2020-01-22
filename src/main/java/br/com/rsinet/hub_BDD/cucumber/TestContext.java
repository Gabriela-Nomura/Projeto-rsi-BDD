package br.com.rsinet.hub_BDD.cucumber;

import br.com.rsinet.hub_BDD.managers.PageObjectManager;
import br.com.rsinet.hub_BDD.managers.WebDriverManager;

public class TestContext {

	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;

	public TestContext() throws Exception {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}

	public WebDriverManager getWebDriverManager() throws Exception {
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}
