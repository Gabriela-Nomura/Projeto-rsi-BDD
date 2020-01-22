package br.com.rsinet.hub_BDD.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_BDD.cucumber.TestContext;
import br.com.rsinet.hub_BDD.managers.PageObjectManager;
import br.com.rsinet.hub_BDD.pageFactory.HomePage_POF;
import br.com.rsinet.hub_BDD.pageFactory.PaginaBusca_POF;
import br.com.rsinet.hub_BDD.utils.Print;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuscaLupaValida_steps {

	private static WebDriver driver;

	HomePage_POF homePage;
	PaginaBusca_POF buscaPage;
	PageObjectManager pageObjectManager;
	TestContext testContext;

	public BuscaLupaValida_steps(TestContext testContext) {
		this.testContext = testContext;

	}

	@Before
	public void initConfig() throws Exception {
		driver = testContext.getWebDriverManager().getDriver();
		homePage = testContext.getPageObjectManager().getHomePage();
		buscaPage = testContext.getPageObjectManager().getBuscaPage();
	}

	@After
	public void quitConfig() throws Exception {
		driver = testContext.getWebDriverManager().encerra();
	}

	@When("^clicar sobre lupa$")
	public void clickOn_busca() throws Throwable {
		homePage.clickOn_busca();
	}

	@And("^enviar um texto de busca$")
	public void enviaTexto() throws Throwable {
		homePage.sendText_busca();

	}

	@And("^selecionar um dos produtos obtidos como resultado$")
	public void seleciona() {
		buscaPage.seleciona();

	}

	@Then("^o produto aberto deve ser correspondente ao que recebeu o clique$")
	public void testeBuscaValido() throws Exception {
		Assert.assertTrue("Busca realizada com sucesso", driver.getPageSource().contains("HP ELITEPAD 1000 G2 TABLET"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Print.takeSnapShot("TesteBuscaLupaSucesso", driver);

	}

	@When("^clicar sobre a lupa$")
	public void clicar_sobre_a_lupa() throws Throwable {

		homePage.clickOn_busca();
	}

	@And("^enviar o texto de busca$")
	public void enviar_um_texto_de_busca() throws Throwable {
		homePage.sendText_buscaFalha();

	}

	@Then("^a busca nao retorna nenhum resultado$")
	public void testeBuscaInvalido() throws Exception {
		
		Assert.assertTrue("Teste com falha", driver.getPageSource().contains("No results for "));

		
		Print.takeSnapShot("TesteBuscaLupaFalha", driver);
	}
}
