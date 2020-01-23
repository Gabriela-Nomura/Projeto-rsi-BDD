package br.com.rsinet.hub_BDD.stepDefinitions;

import br.com.rsinet.hub_BDD.cucumber.TestContext;
import br.com.rsinet.hub_BDD.managers.PageObjectManager;
import br.com.rsinet.hub_BDD.pageFactory.CadastraPage_POF;
import cucumber.api.java.en.And;

public class CadastroPage_steps {

	PageObjectManager pageObjectManager;
	CadastraPage_POF cadastraPage;
	TestContext testContext;

	public CadastroPage_steps(TestContext testContext) throws Exception {
		this.testContext = testContext;
		cadastraPage = testContext.getPageObjectManager().getcadastraPage();
	}

	@And("^inserir um nome de usuario valido$")
	public void userName() throws Exception {
		cadastraPage.sendUserName(4);
	}

	@And("^inserir email valido$")
	public void userEmail() throws Exception {
		cadastraPage.sendUserEmail();
	}

	@And("^inserir senha valida$")
	public void userSenha() throws Exception {
		cadastraPage.sendUserSenha();
	}

	@And("^inserir contra senha valida$")
	public void userContraSenha() throws Exception {
		cadastraPage.sendUserSenhaConfirmacao();
	}

	@And("^inserir o primeiro nome$")
	public void userNome() throws Exception {
		cadastraPage.sendUserSPrimeiroNome();
	}
	@And("^inserir o ultimo nome$")
	public void userUltimoNome() throws Exception {
		cadastraPage.sendUserUltimoNome();
	}
	@And("^inserir o numero de telefone$")
	public void userTelefone() throws Exception {
		cadastraPage.sendUserTelefone();
	}

	@And("^selecionar o pais$")
	public void userPais() throws Exception {
		cadastraPage.clickOn_pais();
		cadastraPage.seleciona_pais();
	}
	@And("^informar a cidade$")
	public void userCidade() throws Exception {
		cadastraPage.sendUserCidade();
	}
	@And("^informar o endereco$")
	public void userEndereco() throws Exception {
		cadastraPage.sendUserEndereco();
	}
	@And("^informar o estado$")
	public void userEstado() throws Exception {
		cadastraPage.sendUserEstado();
	}
	@And("^informar o CEP$")
	public void userCEP() throws Exception {
		cadastraPage.sendUserCep();
	}

	@And("^aceitar os termos de aceitacao e clicar no registro$")
	public void aceitaTermos() {
		cadastraPage.aceitaTermos();
		cadastraPage.registaUser();
	}

	@And("^inserir um nome de usuario invalido$")
	public void detalhesConta() throws Exception {
		cadastraPage.sendUserName(2);
	
	}

}
