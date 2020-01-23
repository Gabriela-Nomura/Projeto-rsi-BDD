package br.com.rsinet.hub_BDD.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_BDD.utils.ConfigExcel;
import br.com.rsinet.hub_BDD.utils.MassaDeDados;

public class WebDriverManager {
	private static WebDriver driver;

	/**
	 * Classe de configura��o do driver a executar os testes. Inicializa��o
	 * do navegador, defini��o da url, arquivo do excel e arquivo de registros
	 * de log.
	 */

	public WebDriver getDriver() throws Exception {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.manage().window().maximize();

		}

		return driver;
	}

	public static void configExcelCadastra() throws Exception {
		ConfigExcel.setExcelFile(MassaDeDados.Path_TestData, "TesteCadastro");

	}

	public static void configExcelBusca() throws Exception {
		ConfigExcel.setExcelFile(MassaDeDados.Path_TestData, "TesteBusca");
	}

	public WebDriver encerra() {
		if (driver != null) {
			driver.close();
//			driver.quit();
		}
		return driver = null;
	}
}
