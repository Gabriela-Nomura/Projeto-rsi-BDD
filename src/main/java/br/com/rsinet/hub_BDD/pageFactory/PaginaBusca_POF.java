package br.com.rsinet.hub_BDD.pageFactory;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_BDD.managers.WebDriverManager;
import br.com.rsinet.hub_BDD.utils.Print;

public class PaginaBusca_POF {

	static Logger Log = Logger.getLogger("Fabrica de objetos - P�gina de busca");
	final WebDriver driver;

	public PaginaBusca_POF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/section/article/div[3]/div/div/div[2]/ul/li[1]/p[1]/a")
	private WebElement produto;

	@FindBy(how = How.XPATH, using = "//*[@id=\"productProperties\"]/div[3]/button")
	private WebElement carrinho;

	@FindBy(how = How.ID, using = "checkOutPopUp")
	private WebElement checkout;

	@FindBy(how = How.XPATH, using = "//*[@id=\"16\"]")
	private WebElement selecaoProduto;

	@FindBy(how = How.XPATH, using = "//*[@id=\"userCart\"]")
	private WebElement elemento;

	public void clickOn_Produto() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		Log.info("Instancia um comando de espera ");

		wait.until(ExpectedConditions.elementToBeClickable(produto));
		Log.info("Driver recebeu um comando de espera para aguardar que o elemento se torne vis�vel");

		produto.click();
		Log.info("Clica no elemento: Beats Studio 2 Over-Ear Matte Black Headphones");
	}

	public void addOn_carrinho() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		Log.info("Instancia um comando de espera ");

		wait.until(ExpectedConditions.elementToBeClickable(carrinho));
		Log.info("Driver recebeu um comando de espera para aguardar que o elemento se torne vis�vel");

		carrinho.click();
		Log.info("Adiciona o produto procurado ao carrinho");
	}

	public void clickOn_checkOut() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(checkout));
		checkout.click();
		Log.info("A op��o de checkout recebeu um clique");
	}

	public void seleciona() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(selecaoProduto));
		selecaoProduto.click();
		
	}

	public void buscaLupaAssert() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(elemento));

		Assert.assertTrue(elemento != null);
		Print.takeSnapShot("TesteBuscaCliqueValido", driver);
//		Assert.assertTrue(driver.getPageSource().contains("ORDER SUMMARY"));
	}

	public void buscaLupaAssertFail() throws Exception {
		Assert.assertTrue(driver.getPageSource().contains("HP CHROMEBOOK 14 G1(ES)"));

		Print.takeSnapShot("TesteBuscaCliquecomfalha", driver);
	}
}
