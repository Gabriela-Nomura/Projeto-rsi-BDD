package br.com.rsinet.hub_BDD.pageFactory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaBuscaPOF {
	/**
	 * Classe de manipulacao de webElements das paginas de buscas
	 */
	final WebDriver driver;

	public PaginaBuscaPOF(WebDriver driver) {
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
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"product\"]/td[2]")
	private WebElement produtoAberto;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPage\"]/div[3]/div/label/span")
	private WebElement noResult;
	
	//Metodo para aguardar que o elemento esteja disponivel para que receba a interação
	private void waitUntil(WebElement element) {
	
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(element));}


	public void clickOn_Produto() {
		waitUntil(produto);
		produto.click();
	}

	public void addOn_carrinho() {
		waitUntil(carrinho);
		carrinho.click();
	}

	public void clickOn_checkOut() {
	waitUntil(checkout);
		checkout.click();
	}

	public void seleciona() {
	waitUntil(selecaoProduto);
		selecaoProduto.click();

	}
	//

	public WebElement buscaLupaAssert() throws Exception {
	waitUntil(elemento);
		return elemento;
		
	}

	public void buscaCliqueSucesso() throws Exception {
		boolean condition = driver.getPageSource().contains("HP ELITEPAD 1000 G2 TABLET");
		Assert.assertTrue("Busca realizada com sucesso", condition);
		
	}
	public String produtoAberto() {
		waitUntil(produtoAberto);
	return produtoAberto.getText();
	
	}

	public void loadTime() {
		waitUntil(noResult);
	}
	
	
}
