package br.com.rsinet.hub_BDD.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_BDD.cucumber.TestContext;
import br.com.rsinet.hub_BDD.pageFactory.HomePage_POF;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class HomePage_steps {
	/**
	 * Fun��o: Executar as a��es referentes na p�gina inicial da aplica��o
	 **/

	WebDriver driver;
	TestContext testContext;
	HomePage_POF homePage;

//Set do construtor que permite a instancia do controlador de construtores de objetos

	public HomePage_steps(TestContext testContext) {
		this.testContext = testContext;
		homePage = testContext.getPageObjectManager().getHomePage();
	}

//Abre a url do site
	@Dado("^que esteja na pagina inicial da aplicacao$")
	public void configInicial() throws Throwable {
		homePage.navegaInicio();
//		 driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
	}

//Clica na categoria de produtos Headphones
	@Quando("^eu clicar sobre uma categoria de produtos$")
	public void clickOn_HeadPhone() {
		homePage.clickOn_HeadPhone();
	}

//Clica no produto escolhido
	@E("^selecionar o produto$")
	public void select_produto() {
		homePage.clickOn_produtos();
	}

//Clica na lupa de busca
	@Quando("^clicar sobre a lupa$")
	public void clickOn_busca() throws Throwable {
		homePage.clickOn_busca();
	}

//Envia um texto para busca atraves da lupa
	@E("^enviar um texto de busca$")
	public void enviaTexto() throws Throwable {
		homePage.sendText_busca();
	}

//Envia o texto de busca para o campo de busca. 
//Utilizada no cenario de busca pela lupa invalida

	@E("^enviar o texto de busca com o nome do produto$")
	public void enviar_um_texto_de_busca() throws Throwable {
		homePage.clickOn_busca();
		homePage.sendText_buscaFalha();
	}

//Clica sobre o �cone de minha conta
	@Quando("^clicar sobre minha conta$")
	public void clickOn_minhaConta() throws InterruptedException {
		homePage.minhaConta();
	}

//Seleciona a op��o de criar uma nova conta
	@E("^selecionar a opcao criar nova conta$")
	public void clickOn_novaConta() throws InterruptedException {
		homePage.novaConta();
	}

//Testa a condi��o de cadastro valido
	@Entao("^o novo usuario deve ser logado e direcionado a homepage com nome de usuario sendo exibido$")
	public void testeCadastroValido() throws Exception {
		Assert.assertTrue(homePage.logadoNomeUser());

	}

	// Testa a condi��o de cadastro invalido
	@Entao("^o cadastro nao sera concluido e a mensagem de erro aparecera$")
	public void testeCadastroInvalido() throws Exception {
		Assert.assertFalse(homePage.logadoNomeUser());

//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("scrollBy(0,150)", "");

//		Print.takeSnapShot("TesteCadastroInvalido", driver);
	}
}