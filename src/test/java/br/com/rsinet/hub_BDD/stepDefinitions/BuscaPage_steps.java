package br.com.rsinet.hub_BDD.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_BDD.cucumber.TestContext;
import br.com.rsinet.hub_BDD.managers.PageObjectManager;
import br.com.rsinet.hub_BDD.pageFactory.PaginaBusca_POF;
import br.com.rsinet.hub_BDD.utils.Print;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class BuscaPage_steps {

	WebDriver driver;
	PaginaBusca_POF buscaPage;
	PageObjectManager pageObjectManager;
	TestContext testContext;

	public BuscaPage_steps(TestContext testContext) {
		this.testContext = testContext;
		buscaPage = testContext.getPageObjectManager().getBuscaPage();
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
		buscaPage.buscaLupaAssert();
	}

	@Then("^a busca nao retorna nenhum resultado$")
	public void testeBuscaInvalido() throws Exception {
		Assert.assertTrue("Teste com falha", driver.getPageSource().contains("No results for "));
		Print.takeSnapShot("TesteBuscaLupaFalha", driver);
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
