package br.com.rsinet.hub_BDD.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub_BDD.cucumber.ContextoDeTeste;
import br.com.rsinet.hub_BDD.pageFactory.HomePagePOF;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class HomePage_steps {
	/**
	 * Fun��o: Executar as a��es referentes na p�gina inicial da aplica��o
	 **/

	WebDriver driver;
	ContextoDeTeste contextoDeTeste;
	HomePagePOF homePagePOF;

//Set do construtor que permite a instancia do controlador de construtores de objetos

	public HomePage_steps(ContextoDeTeste contextoDeTeste) {
		this.contextoDeTeste = contextoDeTeste;
		homePagePOF = contextoDeTeste.getPageObjectManager().getHomePage();
	}

//Abre a url do site
	@Dado("^que esteja na pagina inicial da aplicacao$")
	public void configInicial() throws Throwable {
		homePagePOF.navegaInicio();
		Reporter.addStepLog("Aplicacao iniciada com sucesso");
	}

//Clica na categoria de produtos Headphones
	@Quando("^eu clicar sobre uma categoria de produtos$")
	public void clickOn_HeadPhone() {
		homePagePOF.clickOn_HeadPhone();
	}

//Clica no produto escolhido
	@E("^selecionar o produto$")
	public void select_produto() {
		
		homePagePOF.clickOn_produtos();
	}

//Clica na lupa de busca
	@Quando("^clicar sobre a lupa$")
	public void clickOn_busca() throws Throwable {
		homePagePOF.clickOn_busca();
	}

//Envia um texto para busca atraves da lupa
	@E("^enviar um texto de busca$")
	public void enviaTexto() throws Throwable {
		homePagePOF.sendText_busca();
		Reporter.addStepLog("O texto de busca foi enviado ao respectivo campo ");
	}

//Envia o texto de busca para o campo de busca. 
//Utilizada no cenario de busca pela lupa invalida

	@E("^enviar o texto de busca com o nome do produto$")
	public void enviar_um_texto_de_busca() throws Throwable {
		homePagePOF.clickOn_busca();
		homePagePOF.sendText_buscaFalha();
		Reporter.addStepLog("O texto de busca foi enviado ao respectivo campo ");

	}

//Clica sobre o �cone de minha conta
	@Quando("^clicar sobre minha conta$")
	public void clickOn_minhaConta() throws InterruptedException {
		homePagePOF.minhaConta();
	}

//Seleciona a op��o de criar uma nova conta
	@E("^selecionar a opcao criar nova conta$")
	public void clickOn_novaConta() throws InterruptedException {
		homePagePOF.novaConta();
		Reporter.addStepLog("A página de criacao de novo usuario foi acessada com sucesso ");
	}

//Testa a condicao de cadastro valido
	@Entao("^o novo usuario deve ser logado e direcionado a homepage com nome de usuario sendo exibido$")
	public void testeCadastroValido() throws Exception {
		Assert.assertTrue(homePagePOF.logadoNomeUser());
		Reporter.addStepLog("O novo usuario foi cadastrado com sucesso ");

	}

	// Testa a condi��o de cadastro invalido
	@Entao("^o cadastro nao sera concluido e a mensagem de erro aparecera$")
	public void testeCadastroInvalido() throws Exception {
		Assert.assertFalse(homePagePOF.logadoNomeUser());

		Reporter.addStepLog("O novo usuario foi não cadastrado ");

	}
}