package br.com.rsinet.hub_BDD.stepDefinitions;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_BDD.cucumber.TestContext;
import br.com.rsinet.hub_BDD.managers.PageObjectManager;
import br.com.rsinet.hub_BDD.managers.WebDriverManager;
import br.com.rsinet.hub_BDD.pageFactory.CadastraPage_POF;
import br.com.rsinet.hub_BDD.pageFactory.HomePage_POF;
import br.com.rsinet.hub_BDD.pageFactory.PaginaBusca_POF;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	HomePage_POF homePage;
	CadastraPage_POF cadastraPage;
	PaginaBusca_POF buscaPage;
	TestContext testContext;
	 WebDriver driver;
		public Hooks(TestContext testContext) {
			this.testContext = testContext;
		}

	@Before
	public void initConfig() throws Exception {
		driver = testContext.getWebDriverManager().getDriver();
		WebDriverManager.configExcelCadastra();
	}

	@After
	public void quitConfig() throws Exception {
		driver = testContext.getWebDriverManager().encerra();
	}
	
}
