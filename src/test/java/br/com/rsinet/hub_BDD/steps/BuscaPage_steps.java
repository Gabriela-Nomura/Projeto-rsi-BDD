package br.com.rsinet.hub_BDD.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub_BDD.cucumber.ContextoDeTeste;
import br.com.rsinet.hub_BDD.managers.PageObjectManager;
import br.com.rsinet.hub_BDD.pageFactory.PaginaBuscaPOF;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import enums.Contexto;

public class BuscaPage_steps {
	/**
	 * Funcao: Executar as acoes referentes nas paginas de busca aplicacao
	 **/

	WebDriver driver;
	PaginaBuscaPOF buscaPage;
	PageObjectManager pageObjectManager;
	ContextoDeTeste contextoDeTeste;

	// Set do construtor que permite a instancia do controlador de construtores de
	// objetos
	public BuscaPage_steps(ContextoDeTeste contextoDeTeste) {
		this.contextoDeTeste = contextoDeTeste;
		buscaPage = contextoDeTeste.getPageObjectManager().getBuscaPage();
	}

//Seleciona um dos produtos obtidos a partir da busca por lupa
	@E("^selecionar um dos produtos obtidos como resultado$")
	public void seleciona() {
		buscaPage.seleciona();
		Reporter.addStepLog("O produto obtido como resultado da busca foi selecionado ");
	}

//Testa se o produto que foi aberto ap�s o clique, corresponde ao que foi clicado, obtem screenshot 
	@Entao("^o produto aberto deve ser correspondente ao que recebeu o clique$")
	public void testeBuscaValido() throws Exception {
		buscaPage.buscaCliqueSucesso();
		Reporter.addStepLog("O produto selecionado corresponde ao produto selecionado");
	}

//Seleciona um produto obtido como resultado da busca por clique
	@E("^selecionar um dos produtos$")
	public void clickOn_produtoSelecionado() {
		buscaPage.clickOn_Produto();
	}

//Adiciona o produto selecionado ao carrinho
	@E("^adicionar um item ao carrinho$")
	public void addOn_carrinho() {
		buscaPage.addOn_carrinho();
	}

//Seleciona a op��o de checkout 
	@E("^clicar no checkout$")
	public void clickOnCheckOut() {
		buscaPage.clickOn_checkOut();
	}

//Testa se o produto selecionado corresponde ao que recebeu o clique 
	@Entao("^o produto adicionado ao carrinho deve ser igual ao produto selecionado$")
	public void testaBuscaValida() throws Exception {
		
		Assert.assertTrue(buscaPage.buscaLupaAssert() != null);
		Reporter.addStepLog("O produto adicionado ao carrinho é igual ao selecionado ");
	}

//Testa se o produto buscado foi encontrado --LUPA
	@Entao("^a busca nao retorna nenhum resultado$")
	public void testeBuscaInvalido() throws Exception {
		buscaPage.loadTime();
	Assert.assertTrue(contextoDeTeste.getWebDriverManager().getDriver().getPageSource().contains("No results "));

		Reporter.addStepLog("A busca não retornou nenhum resultado");
	}

//Testa se o produto retornado pela busca atraves lupa corresponde ao texto 
	@Entao("^o produto aberto sera diferente do produto selecionado$")
	public void testaBuscaInvalida() throws Exception {
		String productName = (String) contextoDeTeste.getContextoCenario().getContexto(Contexto.PRODUCT_NAME);
		String produtoAberto = buscaPage.produtoAberto();

		Assert.assertFalse(productName == produtoAberto);

		Reporter.addStepLog("O produto selecionado é diferente do produto selecionado");
	}
}
