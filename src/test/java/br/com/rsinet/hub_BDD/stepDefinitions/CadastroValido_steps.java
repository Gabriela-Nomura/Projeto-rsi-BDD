package br.com.rsinet.hub_BDD.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_BDD.cucumber.TestContext;
import br.com.rsinet.hub_BDD.managers.PageObjectManager;
import br.com.rsinet.hub_BDD.managers.WebDriverManager;
import br.com.rsinet.hub_BDD.pageFactory.CadastraPage_POF;
import br.com.rsinet.hub_BDD.pageFactory.HomePage_POF;
import br.com.rsinet.hub_BDD.utils.Print;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CadastroValido_steps {

	private static WebDriver driver;

	PageObjectManager pageObjectManager;
	HomePage_POF homePage;
	CadastraPage_POF cadastraPage;
	TestContext testContext;

	public CadastroValido_steps(TestContext testContext) {
		this.testContext = testContext;
	}

	@Before
	public void initConfig() throws Exception {
		driver = testContext.getWebDriverManager().getDriver();
		cadastraPage = testContext.getPageObjectManager().getcadastraPage();
		homePage = testContext.getPageObjectManager().getHomePage();
		WebDriverManager.configExcelCadastra();
	}

	@After
	public void quitConfig() throws Exception {
		driver = testContext.getWebDriverManager().encerra();
	}

	@When("^clicar sobre minha conta$")
	public void clickOn_minhaConta() throws InterruptedException {
		homePage.minhaConta();
	}

	@And("^selecionar a opcao criar nova conta$")
	public void clickOn_novaConta() throws InterruptedException {
		homePage.novaConta();

	}

	@And("^inserir um nome de usuario, email, senha e contra senha valido$")
	public void detalhes_Conta() throws Exception {

		cadastraPage.sendUserName(1);
		cadastraPage.sendUserEmail();
		cadastraPage.sendUserSenha();
		cadastraPage.sendUserSenhaConfirmacao();
	}

	@And("^inserir o primeiro e ultimo nome, e o numero de telefone$")
	public void detalhes_Pessoais() throws Exception {
		cadastraPage.sendUserSPrimeiroNome();
		cadastraPage.sendUserUltimoNome();
		cadastraPage.sendUserTelefone();
	}

	@And("^selecionar o pais, informar a cidade, o endere�o o estado e o CEP$")
	public void enderecoUser() throws Exception {
		cadastraPage.clickOn_pais();
		cadastraPage.seleciona_pais();
		cadastraPage.sendUserCidade();
		cadastraPage.sendUserEndereco();
		cadastraPage.sendUserEstado();
		cadastraPage.sendUserCep();
	}

	@And("^aceitar os termos de aceitacao e clicar no registro$")
	public void aceitaTermos() {
		cadastraPage.aceitaTermos();
		cadastraPage.registaUser();

	}

	@Then("^o novo usuario deve ser logado e direcionado a homepage com nome de usuario sendo exibido$")
	public void testeCadastroValido() throws Exception {
		Assert.assertTrue(homePage.logadoNomeUser());

		Print.takeSnapShot("TesteCadastroValido", driver);

		}

	@When("^clicar no link minha conta$")
	public void minhaConta() throws InterruptedException {
		homePage.minhaConta();
	}

	@And("^selecionar a opcao criar uma nova conta$")
	public void novaConta() throws InterruptedException {
		homePage.novaConta();

	}

	@And("^inserir um nome de usuario ja cadastrado, email, senha e contra senha valido$")
	public void detalhesConta() throws Exception {

		cadastraPage.sendUserName(1);
		cadastraPage.sendUserEmail();
		cadastraPage.sendUserSenha();
		cadastraPage.sendUserSenhaConfirmacao();
	}

	@And("^inserir o primeiro e ultimo nome, e o numero de telefone validos$")
	public void detalhesPessoais() throws Exception {
		cadastraPage.sendUserSPrimeiroNome();
		cadastraPage.sendUserUltimoNome();
		cadastraPage.sendUserTelefone();
	}

	@And("^selecionar o pais, informar a cidade, o endere�o o estado e o CEP do user$")
	public void endereco() throws Exception {
		cadastraPage.clickOn_pais();
		cadastraPage.seleciona_pais();
		cadastraPage.sendUserCidade();
		cadastraPage.sendUserEndereco();
		cadastraPage.sendUserEstado();
		cadastraPage.sendUserCep();
	}

	@And("^aceitar os termos de aceitacao e clicar sobre o registro$")
	public void aceita() {
		cadastraPage.aceitaTermos();
		cadastraPage.registaUser();

	}

	@Then("^o cadastro nao sera concluido e a mensagem de erro aparecera$")
	public void testeCadastroInvalido() throws Exception {

		Assert.assertFalse(homePage.logadoNomeUser());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,150)", "");

		Print.takeSnapShot("TesteCadastroInvalido", driver);

	}
}
