package br.com.rsinet.hub_BDD.steps;

import br.com.rsinet.hub_BDD.cucumber.TestContext;
import br.com.rsinet.hub_BDD.managers.PageObjectManager;
import br.com.rsinet.hub_BDD.pageFactory.CadastraPage_POF;
import cucumber.api.java.en.And;

public class CadastroPage_steps {
	/**
	 * Função: Executar as ações referentes nas páginas de cadastro aplicação
	 **/

	PageObjectManager pageObjectManager;
	CadastraPage_POF cadastraPage;
	TestContext testContext;
	
	// Set do construtor que permite a instancia do controlador de construtores de objetos
	public CadastroPage_steps(TestContext testContext) throws Exception {
		this.testContext = testContext;
		cadastraPage = testContext.getPageObjectManager().getcadastraPage();
	}
//Insere o nome obtido do excel no respectivo campo 
	//Quando alterar nesse campo sera necessario alterar tambem no metodo   logadoNomeUser() na classe HomePage_POF
	@And("^inserir um nome de usuario valido$")
	public void userName() throws Exception {
		cadastraPage.sendUserName(7);
	}
	//Insere o email obtido do excel no respectivo campo 
	@And("^inserir email valido$")
	public void userEmail() throws Exception {
		cadastraPage.sendUserEmail();
	}
	//Insere a senha obtida do excel no respectivo campo 
	@And("^inserir senha valida$")
	public void userSenha() throws Exception {
		cadastraPage.sendUserSenha();
	}
	//Insere a confirmação de senha obtida do excel no respectivo campo 
	@And("^inserir contra senha valida$")
	public void userContraSenha() throws Exception {
		cadastraPage.sendUserSenhaConfirmacao();
	}
	//Insere o primeiro nome obtido do excel no respectivo campo 
	@And("^inserir o primeiro nome$")
	public void userNome() throws Exception {
		cadastraPage.sendUserSPrimeiroNome();
	}
	//Insere o ultimo nome obtido do excel no respectivo campo
	@And("^inserir o ultimo nome$")
	public void userUltimoNome() throws Exception {
		cadastraPage.sendUserUltimoNome();
	}
	//Insere o numero telefone obtido do excel no respectivo campo
	@And("^inserir o numero de telefone$")
	public void userTelefone() throws Exception {
		cadastraPage.sendUserTelefone();
	}
	//Seleciona o pais no respectivo campo
	@And("^selecionar o pais$")
	public void userPais() throws Exception {
		cadastraPage.clickOn_pais();
		cadastraPage.seleciona_pais();
	}
	//Insere a cidade obtida do excel no respectivo campo
	@And("^informar a cidade$")
	public void userCidade() throws Exception {
		cadastraPage.sendUserCidade();
	}
	//Insere o endereco obtido do excel no respectivo campo
	@And("^informar o endereco$")
	public void userEndereco() throws Exception {
		cadastraPage.sendUserEndereco();
	}
	//Insere o estado obtido do excel no respectivo campo
	@And("^informar o estado$")
	public void userEstado() throws Exception {
		cadastraPage.sendUserEstado();
	}
	//Insere o CEP obtido do excel no respectivo campo
	@And("^informar o CEP$")
	public void userCEP() throws Exception {
		cadastraPage.sendUserCep();
	}
//Aceitar os termos de aceitação e clica no botao de registrar usuario
	@And("^aceitar os termos de aceitacao e clicar no registro$")
	public void aceitaTermos() {
		cadastraPage.aceitaTermos();
		cadastraPage.registaUser();
	}
//Insere o nome obtido do excel no respectivo campo
	@And("^inserir um nome de usuario invalido$")
	public void detalhesConta() throws Exception {
		cadastraPage.sendUserName(2);
	
	}

}
