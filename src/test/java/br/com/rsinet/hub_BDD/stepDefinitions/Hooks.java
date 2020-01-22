//package br.com.rsinet.hub_BDD.stepDefinitions;
//
//import org.openqa.selenium.WebDriver;
//
//import br.com.rsinet.hub_BDD.managers.PageObjectManager;
//import br.com.rsinet.hub_BDD.managers.WebDriverManager;
//import br.com.rsinet.hub_BDD.pageFactory.CadastraPage_POF;
//import br.com.rsinet.hub_BDD.pageFactory.HomePage_POF;
//import br.com.rsinet.hub_BDD.pageFactory.PaginaBusca_POF;
//import br.com.rsinet.hub_BDD.cucumber.api.java.After;
//import br.com.rsinet.hub_BDD.cucumber.api.java.Before;
//import br.com.rsinet.hub_BDD.cucumber.api.java.en.Given;
//
//public class Hooks {
//
//	PageObjectManager pageObjectManager;
//	WebDriverManager webDriverManager;
//	HomePage_POF homePage;
//	CadastraPage_POF cadastraPage;
//	PaginaBusca_POF buscaPage;
//	private static WebDriver driver;
//
//	@Before
//
//	@Given("^que esteja na pagina inicial da aplicacao$")
//	public void configInicial() throws Throwable {
//		webDriverManager = new WebDriverManager();
//		driver = WebDriverManager.getDriver();
//		pageObjectManager = new PageObjectManager(driver);
//		homePage = pageObjectManager.getHomePage();
//		cadastraPage = pageObjectManager.getcadastraPage();
//		buscaPage = pageObjectManager.getBuscaPage();
//
//	}
//
//	@After
//	public void quitDriver() {
//		WebDriverManager.encerra(driver);
//	}
//}
