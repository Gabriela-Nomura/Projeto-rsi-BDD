package br.com.rsinet.hub_BDD.stepDefinitions;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_BDD.cucumber.TestContext;
import br.com.rsinet.hub_BDD.pageFactory.HomePage_POF;
import br.com.rsinet.hub_BDD.pageFactory.PaginaBusca_POF;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuscaClique_steps {

	WebDriver driver;
	TestContext testContext;
	HomePage_POF homePage;
	PaginaBusca_POF buscaPage;

	public BuscaClique_steps(TestContext testContext) {
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
	
	@Given("^que esteja na pagina inicial da aplicacao$")
	public void configInicial() throws Throwable {
	
		homePage.navegaInicio();
	}

	@When("^eu clicar sobre uma categoria de produtos$")
	public void clickOn_HeadPhone() {
//		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		homePage.clickOn_HeadPhone();

	}

	@And("^selecionar um dos produtos$")
	public void clickOn_produtoSelecionado() {
		buscaPage.clickOn_Produto();

	}

	@And("^adicionar um item ao carrinho$")
	public void addOn_carrinho() {
		buscaPage.addOn_carrinho();
	}

	@And("^clicar no checkout$")
	public void clickOnCheckOut() {
		buscaPage.clickOn_checkOut();

	}

	@Then("^o produto adicionado ao carrinho deve ser igual ao produto selecionado$")
	public void testaBuscaValida() throws Exception {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		buscaPage.buscaLupaAssert();

	}

//	@Given("^que esteja na pagina inicial da aplicacao$")
//	public void configInicial() throws Throwable {
//
//		homePage = testContext.getPageObjectManager().getHomePage();
//
//		buscaPage = testContext.getPageObjectManager().getBuscaPage();

//	}
	@When("^eu clicar sobre o link de produto populares$")
	public void clickOn_produtosPopulares() throws InterruptedException {
		homePage.clickOn_PopularProdutos();
	}

	@And("^tirar um print$")
	public void clickOn_produto() throws Exception {
		homePage.takePrint();
	}

	@And("^selecionar o produto$")
	public void select_produto() {
		homePage.clickOn_produtos();
	}

	@And("^adicionar no carrinho$")
	public void clickOn_checkOut() {
		buscaPage.addOn_carrinho();

	}

	@Then("^o produto aberto sera diferente do produto selecionado$")
	public void testaBuscaInvalida() throws Exception {
		buscaPage.buscaLupaAssertFail();
	}
}