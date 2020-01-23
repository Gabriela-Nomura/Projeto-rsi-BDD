package br.com.rsinet.hub_BDD.pageFactory;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_BDD.managers.WebDriverManager;
import br.com.rsinet.hub_BDD.utils.Print;
import br.com.rsinet.hub_BDD.utils.MassaDeDados;

public class HomePage_POF {

	static Logger Log = Logger.getLogger("Fabrica de objetos - P�gina inicial");
	final WebDriver driver;

	public HomePage_POF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "details_10")
	private WebElement produto;

	@FindBy(how = How.XPATH, using = "/html/body/header/nav/ul/li[6]/a")
	private WebElement popularProdutos;

	@FindBy(how = How.ID, using = "menuUserLink")
	private WebElement minhaConta;
										
	@FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]")
	private WebElement novaConta;

	@FindBy(how = How.ID, using = "menuSearch")
	private WebElement busca;

	@FindBy(how = How.ID, using = "headphonesImg")
	private WebElement HeadPhones;

	@FindBy(how = How.XPATH, using = "//*[@id=\"menuUserLink\"]/span")
	private WebElement userText;

	CadastraPage_POF CadastraPage;

	@FindBy(how = How.ID, using = "autoComplete")
	private WebElement buscaBox;

	public void navegaInicio() {

		driver.get(MassaDeDados.URL);
	}

	public void minhaConta() throws InterruptedException {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(minhaConta));

		minhaConta.sendKeys(Keys.ENTER);
	}

	public void novaConta() throws InterruptedException {

//		driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(novaConta));

		novaConta.sendKeys(Keys.ENTER);
		Thread.sleep(30000);
	}

	public boolean logadoNomeUser() throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.textToBePresentInElement(userText, MassaDeDados.userName(1)));
		} catch (Exception e) {

			return userText.isDisplayed();
		}
		return userText.isDisplayed();
	}

	public void clickOn_HeadPhone() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(HeadPhones));
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		HeadPhones.click();
	}

	public void clickOn_PopularProdutos() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(popularProdutos));
		popularProdutos.sendKeys(Keys.ENTER);
//
//		 Actions acao = new Actions(driver);
//		 acao.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
//		 Thread.sleep(10000);
	}

	public void takePrint() throws Exception {
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		Print.takeSnapShot("TesteBuscaCliqueInvalido-MostraProduto", driver);
	}

	public void clickOn_produtos() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(produto));
		produto.click();
	}

	public void clickOn_busca() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(busca));

		busca.click();

	}

	public void sendText_busca() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(buscaBox));
		WebDriverManager.configExcelBusca();
		buscaBox.sendKeys(MassaDeDados.buscaLupa());
		buscaBox.sendKeys(Keys.ENTER);
	}

	public void sendText_buscaFalha() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(buscaBox));

		WebDriverManager.configExcelBusca();

		buscaBox.sendKeys(MassaDeDados.buscaLupaFalha());
		buscaBox.sendKeys(Keys.ENTER);

		Thread.sleep(20000);
	}

	public void ajusta_tela() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("scrollBy(0,750)", "");

		WebElement element = driver.findElement(By.id("details_10"));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void take_Print() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(produto));
		Print.takeSnapShot("TesteBuscaLupaInvalido-MostraProduto", driver);

	}
}