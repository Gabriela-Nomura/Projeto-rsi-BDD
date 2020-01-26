package br.com.rsinet.hub_BDD.pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_BDD.utils.MassaDeDados;

public class CadastraPage_POF {
	/**
	 * Classe de manipulacao de webElements da pagina de cadastro
	 */
	final WebDriver driver;

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

	@FindBy(how = How.ID, using = "register_btnundefined")
	private WebElement registraUsuario;

	@FindBy(how = How.XPATH, using = "//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]/font/font")
	private WebElement alerta;
	
	//metodo que obtem o valor lido do excel e insere o valor no respectivo campo
	//o parametro i se refere a linha do excel que sera lida
	public String sendUserName(int i ) throws Exception {
		nomeUsuario.sendKeys(MassaDeDados.userName(i));
		return MassaDeDados.userName(i);
	}

	public void sendUserEmail() throws Exception {
		emailUsuario.sendKeys(MassaDeDados.userEmail());
	}

	public void sendUserSenha() throws Exception {
		senhaUsuario.sendKeys(MassaDeDados.userSenha());
	}

	public void sendUserSenhaConfirmacao() throws Exception {
		confirmacaoSenhaUsuario.sendKeys(MassaDeDados.userSenhaConfirmacao());
	}

	public void sendUserSPrimeiroNome() throws Exception {
		primeiroNome.sendKeys(MassaDeDados.userPrimeiroNome());
	}

	public void sendUserUltimoNome() throws Exception {
		ultimoNome.sendKeys(MassaDeDados.userUltimoNome());
	}

	public void sendUserTelefone() throws Exception {
		telefoneUsuario.sendKeys(MassaDeDados.userTelefone());
	}

	public void clickOn_pais() {
		paisUsuario.click();
	}

	public void seleciona_pais() {
		Select paisBox = new Select(CadastraPage_POF.paisUsuario);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		paisBox.selectByVisibleText("Brazil");
	}

	public void sendUserCidade() throws Exception {
		cidadeUsuario.sendKeys(MassaDeDados.userCidade());
	}

	public void sendUserEndereco() throws Exception {
		enderecoUsuario.sendKeys(MassaDeDados.userEndereco());
	}
	
	public void sendUserEstado() throws Exception {
		estadoUsuario.sendKeys(MassaDeDados.userEstado());
	}
	public void sendUserCep() throws Exception {
	cepUsuario.sendKeys(MassaDeDados.userCep());
	}
	public void aceitaTermos() {
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.elementToBeClickable(aceitaTermos));
		aceitaTermos.click();
	}
	public void registaUser() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(registraUsuario));
		registraUsuario.click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	
}