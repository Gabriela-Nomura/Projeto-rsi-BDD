package br.com.rsinet.hub_BDD.cucumber;

import br.com.rsinet.hub_BDD.managers.PageObjectManager;
import br.com.rsinet.hub_BDD.managers.WebDriverManager;

public class ContextoDeTeste {

	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	 ContextoDeCenario  contextoCenario;
	 
	public ContextoDeTeste() throws Exception {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		contextoCenario = new ContextoDeCenario();
	}

	public WebDriverManager getWebDriverManager() throws Exception {
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	 public ContextoDeCenario getContextoCenario() {
		 return contextoCenario;
		 }
}
