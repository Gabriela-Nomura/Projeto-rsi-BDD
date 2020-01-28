package br.com.rsinet.hub_BDD.steps;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub_BDD.cucumber.ContextoDeTeste;
import br.com.rsinet.hub_BDD.managers.PageObjectManager;
import br.com.rsinet.hub_BDD.pageFactory.CadastraPagePOF;
import cucumber.api.java.pt.E;

public class CadastroPage_steps {
	/**
	 * Fun��o: Executar as a��es referentes nas p�ginas de cadastro aplica��o
	 **/

	PageObjectManager pageObjectManager;
	CadastraPagePOF cadastraPagePOF;
	ContextoDeTeste contextoDeTeste;

	// Set do construtor que permite a instancia do controlador de construtores de
	// objetos
	public CadastroPage_steps(ContextoDeTeste contextoDeTeste) throws Exception {
		this.contextoDeTeste = contextoDeTeste;
		cadastraPagePOF = contextoDeTeste.getPageObjectManager().getcadastraPage();
	}

//Insere o nome obtido do excel no respectivo campo 
	// Quando alterar nesse campo sera necessario alterar tambem no metodo
	// logadoNomeUser() na classe HomePagePOF
	@E("^inserir um nome de usuario valido$")
	public void userName() throws Exception {
		cadastraPagePOF.sendUserName(3);
		Reporter.addStepLog ("Foi enviado um nome de usuario valido ");
	}

	// Insere o email obtido do excel no respectivo campo
	@E("^inserir email valido$")
	public void userEmail() throws Exception {
		cadastraPagePOF.sendUserEmail();
	}

	// Insere a senha obtida do excel no respectivo campo
	@E("^inserir senha valida$")
	public void userSenha() throws Exception {
		cadastraPagePOF.sendUserSenha();
	}

	// Insere a confirma��o de senha obtida do excel no respectivo campo
	@E("^inserir contra senha valida$")
	public void userContraSenha() throws Exception {
		cadastraPagePOF.sendUserSenhaConfirmacao();
	}

	// Insere o primeiro nome obtido do excel no respectivo campo
	@E("^inserir o primeiro nome$")
	public void userNome() throws Exception {
		cadastraPagePOF.sendUserSPrimeiroNome();
	}

	// Insere o ultimo nome obtido do excel no respectivo campo
	@E("^inserir o ultimo nome$")
	public void userUltimoNome() throws Exception {
		cadastraPagePOF.sendUserUltimoNome();
	}

	// Insere o numero telefone obtido do excel no respectivo campo
	@E("^inserir o numero de telefone$")
	public void userTelefone() throws Exception {
		cadastraPagePOF.sendUserTelefone();
	}

	// Seleciona o pais no respectivo campo
	@E("^selecionar o pais$")
	public void userPais() throws Exception {
		cadastraPagePOF.clickOn_pais();
		cadastraPagePOF.seleciona_pais();
	}

	// Insere a cidade obtida do excel no respectivo campo
	@E("^informar a cidade$")
	public void userCidade() throws Exception {
		cadastraPagePOF.sendUserCidade();
	}

	// Insere o endereco obtido do excel no respectivo campo
	@E("^informar o endereco$")
	public void userEndereco() throws Exception {
		cadastraPagePOF.sendUserEndereco();
	}

	// Insere o estado obtido do excel no respectivo campo
	@E("^informar o estado$")
	public void userEstado() throws Exception {
		cadastraPagePOF.sendUserEstado();
	}

	// Insere o CEP obtido do excel no respectivo campo
	@E("^informar o CEP$")
	public void userCEP() throws Exception {
		cadastraPagePOF.sendUserCep();
	}

//Aceitar os termos de aceita��o e clica no botao de registrar usuario
	@E("^aceitar os termos de aceitacao$")
	public void aceitaTermos() {
		cadastraPagePOF.aceitaTermos();
	}
		@E("clicar no registro$")
	public void registra() {
		cadastraPagePOF.registaUser();
	}

//Insere o nome obtido do excel no respectivo campo
	@E("^inserir um nome de usuario invalido$")
	public void detalhesConta() throws Exception {
		cadastraPagePOF.sendUserName(2);
		Reporter.addStepLog ("Foi enviado um nome de usuario ja existente ");

	}

}
