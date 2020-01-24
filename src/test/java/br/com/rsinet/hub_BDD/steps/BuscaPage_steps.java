package br.com.rsinet.hub_BDD.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_BDD.cucumber.TestContext;
import br.com.rsinet.hub_BDD.managers.PageObjectManager;
import br.com.rsinet.hub_BDD.pageFactory.PaginaBusca_POF;
import br.com.rsinet.hub_BDD.utils.Print;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;

public class BuscaPage_steps {
	/**
	 * Função: Executar as ações referentes nas páginas de busca aplicação
	 **/

	WebDriver driver;
	PaginaBusca_POF buscaPage;
	PageObjectManager pageObjectManager;
	TestContext testContext;

	// Set do construtor que permite a instancia do controlador de construtores de objetos
	public BuscaPage_steps(TestContext testContext) {
		this.testContext = testContext;
		buscaPage = testContext.getPageObjectManager().getBuscaPage();
	}

//Seleciona um dos produtos obtidos a partir da busca por lupa
	@E("^selecionar um dos produtos obtidos como resultado$")
	public void seleciona() {
		buscaPage.seleciona();
	}

//Testa se o produto que foi aberto após o clique, corresponde ao que foi clicado, obtem screenshot 
	@Entao("^o produto aberto deve ser correspondente ao que recebeu o clique$")
	public void testeBuscaValido() throws Exception {
		Assert.assertTrue("Busca realizada com sucesso", driver.getPageSource().contains("HP ELITEPAD 1000 G2 TABLET"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Print.takeSnapShot("TesteBuscaLupaSucesso", driver);
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

//Seleciona a opção de checkout 
	@E("^clicar no checkout$")
	public void clickOnCheckOut() {
		buscaPage.clickOn_checkOut();
	}

//Testa se o produto selecionado corresponde ao que recebeu o clique 
	@Entao("^o produto adicionado ao carrinho deve ser igual ao produto selecionado$")
	public void testaBuscaValida() throws Exception {
		buscaPage.buscaLupaAssert();
	}

//Testa se o produto buscado foi encontrado
	@Entao("^a busca nao retorna nenhum resultado$")
	public void testeBuscaInvalido() throws Exception {
		Assert.assertTrue("Teste com falha", driver.getPageSource().contains("No results for "));
		Print.takeSnapShot("TesteBuscaLupaFalha", driver);
	}
//Testa se o produto retornado pela busca atraves lupa corresponde ao texto 
	@Entao("^o produto aberto sera diferente do produto selecionado$")
	public void testaBuscaInvalida() throws Exception {
		buscaPage.buscaLupaAssertFail();
	}
}
