package br.com.rsinet.hub_BDD.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_BDD.cucumber.TestContext;
import br.com.rsinet.hub_BDD.pageFactory.HomePage_POF;
import br.com.rsinet.hub_BDD.utils.Print;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class HomePage_steps {
	/**
	 * Função: Executar as ações referentes na página inicial da aplicação
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
	}

//Clica na categoria de produtos Headphones
	@Quando("^eu clicar sobre uma categoria de produtos$")
	public void clickOn_HeadPhone() {
		homePage.clickOn_HeadPhone();
	}

//Clica sobre a categoria ded produtos populares
	@Quando("^eu clicar sobre o link de produto populares$")
	public void clickOn_produtosPopulares() throws InterruptedException {
		homePage.clickOn_PopularProdutos();
	}

//Obtem um Screenshot da tela a fim de mostrar o produto que ira receber o clique
	@E("^tirar um print$")
	public void takePrint() throws Exception {
		homePage.takePrint();
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

//Obtem um screenshot da tela
	@E("obter um print do produto que receberá o clique$")
	public void take_print() throws Exception {
		homePage.take_Print();
	}
//Envia o texto de busca para o campo de busca. 
//Utilizada no cenario de busca pela lupa invalida

	@E("^enviar o texto de busca com o nome do produto$")
	public void enviar_um_texto_de_busca() throws Throwable {
		homePage.clickOn_busca();
		homePage.sendText_buscaFalha();
	}

//Clica sobre o ícone de minha conta
	@Quando("^clicar sobre minha conta$")
	public void clickOn_minhaConta() throws InterruptedException {
		homePage.minhaConta();
	}

//Seleciona a opção de criar uma nova conta
	@E("^selecionar a opcao criar nova conta$")
	public void clickOn_novaConta() throws InterruptedException {
		homePage.novaConta();
	}

//Testa a condição de cadastro valido
	@Entao("^o novo usuario deve ser logado e direcionado a homepage com nome de usuario sendo exibido$")
	public void testeCadastroValido() throws Exception {
		Assert.assertTrue(homePage.logadoNomeUser());

		Print.takeSnapShot("TesteCadastroValido", driver);
	}

	// Testa a condição de cadastro invalido
	@Entao("^o cadastro nao sera concluido e a mensagem de erro aparecera$")
	public void testeCadastroInvalido() throws Exception {
		Assert.assertFalse(homePage.logadoNomeUser());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,150)", "");

		Print.takeSnapShot("TesteCadastroInvalido", driver);
	}
}