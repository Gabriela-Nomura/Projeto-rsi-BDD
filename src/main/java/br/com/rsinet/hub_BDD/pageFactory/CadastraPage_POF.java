package br.com.rsinet.hub_BDD.pageFactory;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import br.com.rsinet.hub_BDD.utils.constantes;

public class CadastraPage_POF {

	final WebDriver driver;
	Logger Log = Logger.getLogger("Fabrica de objetos - Cadastro");

	public CadastraPage_POF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Account Details
	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	private WebElement nomeUsuario;

	@FindBy(how = How.NAME, using = "emailRegisterPage")
	private WebElement emailUsuario;

	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	private WebElement senhaUsuario;

	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	private WebElement confirmacaoSenhaUsuario;

	// Personal Details

	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	private WebElement primeiroNome;

	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	private WebElement ultimoNome;

	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	private WebElement telefoneUsuario;

	// Addresss

	@FindBy(how = How.XPATH, using = "//*[@id=\'formCover\']/div[3]/div[1]/sec-view[1]/div/select")
	private static WebElement paisUsuario;

	@FindBy(how = How.XPATH, using = "//*[@id=\'formCover\']/div[3]/div[1]/sec-view[2]/div/input")
	private WebElement cidadeUsuario;

	@FindBy(how = How.XPATH, using = "//*[@id=\"formCover\"]/div[3]/div[2]/sec-view[1]/div/input")
	private WebElement enderecoUsuario;

	@FindBy(how = How.XPATH, using = "//*[@id=\"formCover\"]/div[3]/div[2]/sec-view[2]/div/input")
	private WebElement estadoUsuario;

	@FindBy(how = How.XPATH, using = "//*[@id=\"formCover\"]/div[3]/div[3]/sec-view/div/input")
	private WebElement cepUsuario;

	@FindBy(how = How.XPATH, using = "//*[@id=\"formCover\"]/sec-view/div/input")
	private WebElement aceitaTermos;

	@FindBy(how = How.XPATH, using = "//*[@id=\"register_btnundefined\"]")
	private WebElement registraUsuario;

	@FindBy(how = How.XPATH, using = "//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]/font/font")
	private WebElement alerta;
	
	public String sendUserName(int i ) throws Exception {
		nomeUsuario.sendKeys(constantes.userName(i));
		Log.info("Insere o nome de usuario");
		return constantes.userName(i);
	}

	public void sendUserEmail() throws Exception {
		emailUsuario.sendKeys(constantes.userEmail());
		Log.info("Insere o email do usuario");
	}

	public void sendUserSenha() throws Exception {
		senhaUsuario.sendKeys(constantes.userSenha());
		Log.info("Insere a senha do usuario");
	}

	public void sendUserSenhaConfirmacao() throws Exception {
		confirmacaoSenhaUsuario.sendKeys(constantes.userSenhaConfirmacao());
		Log.info("Insere a confirmacao de senha do usuario");
	}

	public void sendUserSPrimeiroNome() throws Exception {
		primeiroNome.sendKeys(constantes.userPrimeiroNome());
		Log.info("Insere o primeiro nome do usuario");
	}

	public void sendUserUltimoNome() throws Exception {
		ultimoNome.sendKeys(constantes.userUltimoNome());
		Log.info("Insere o telefone do usuario");
	}

	public void sendUserTelefone() throws Exception {
		telefoneUsuario.sendKeys(constantes.userTelefone());
		Log.info("Insere o telefone do usuario");
	}

	public void clickOn_pais() {
		paisUsuario.click();
		Log.info("Seleciona a lista de paises");
	}

	public void seleciona_pais() {
		Select paisBox = new Select(CadastraPage_POF.paisUsuario);
		Log.info("Instancia um objeto select para manipulacao da lista");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");
		paisBox.selectByVisibleText("Brazil");
		Log.info("O pa�s Brazil foi selecionado");
	}

	public void sendUserCidade() throws Exception {
		cidadeUsuario.sendKeys(constantes.userCidade());
		Log.info("Insere a cidade do usu�rio");
	}

	public void sendUserEndereco() throws Exception {
		enderecoUsuario.sendKeys(constantes.userEndereco());
		Log.info("Insere o endere�o do usu�rio");
		
	}
	
	public void sendUserEstado() throws Exception {
		estadoUsuario.sendKeys(constantes.userEstado());
		Log.info("Insere o estado do usu�rio");
	}
	public void sendUserCep() throws Exception {
	cepUsuario.sendKeys(constantes.userCep());
	Log.info("Insere o CEP do usu�rio");
	}
	public void aceitaTermos() {
	aceitaTermos.click();
	Log.info("A opcao de aceitacao dos termos de privacidade foi selecionada");
	}
	public void registaUser() {
		
		registraUsuario.click();
		Log.info("O link para registrar um novo usu�rio recebeu um clique");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	
}