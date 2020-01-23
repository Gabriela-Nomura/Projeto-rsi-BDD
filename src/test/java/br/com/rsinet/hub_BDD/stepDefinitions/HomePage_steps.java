package br.com.rsinet.hub_BDD.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_BDD.cucumber.TestContext;
import br.com.rsinet.hub_BDD.pageFactory.HomePage_POF;
import br.com.rsinet.hub_BDD.utils.Print;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePage_steps {

	WebDriver driver;
	TestContext testContext;
	HomePage_POF homePage;
	

	public HomePage_steps(TestContext testContext) {
		this.testContext = testContext;
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	@Given("^que esteja na pagina inicial da aplicacao$")
	public void configInicial() throws Throwable {
		homePage.navegaInicio();
	}

	@When("^eu clicar sobre uma categoria de produtos$")
	public void clickOn_HeadPhone() {
		homePage.clickOn_HeadPhone();
	}

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

	@When("^clicar sobre a lupa$")
	public void clickOn_busca() throws Throwable {
		homePage.clickOn_busca();
	}

	@And("^enviar um texto de busca$")
	public void enviaTexto() throws Throwable {
		homePage.sendText_busca();
	}

	@When("^clicar sobre produtos populares$")
	public void clickOn_ProdutosPopulares() throws Throwable {
		homePage.clickOn_PopularProdutos();
	}

	@And("obter um print do produto que receberá o clique$")
	public void take_print() throws Exception {
		homePage.take_Print();
	}

	@And("^enviar o texto de busca com o nome do produto$")
	public void enviar_um_texto_de_busca() throws Throwable {
		homePage.clickOn_busca();
		homePage.sendText_buscaFalha();
	}

	@When("^clicar sobre minha conta$")
	public void clickOn_minhaConta() throws InterruptedException {
		homePage.minhaConta();
	}

	@And("^selecionar a opcao criar nova conta$")
	public void clickOn_novaConta() throws InterruptedException {
		homePage.novaConta();
	}
	@Then("^o novo usuario deve ser logado e direcionado a homepage com nome de usuario sendo exibido$")
	public void testeCadastroValido() throws Exception {
		Assert.assertTrue(homePage.logadoNomeUser());

		Print.takeSnapShot("TesteCadastroValido", driver);
	}
	@Then("^o cadastro nao sera concluido e a mensagem de erro aparecera$")
	public void testeCadastroInvalido() throws Exception {
		Assert.assertFalse(homePage.logadoNomeUser());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,150)", "");

		Print.takeSnapShot("TesteCadastroInvalido", driver);
	}
}