package br.com.rsinet.hub_BDD.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;


public class WebDriverManager {
	private static WebDriver driver;

	/**
	 * Classe de configuracao do driver a executar os testes. Inicializacao do
	 * navegador, definicao da url, arquivo do excel e arquivo de registros de log.
	 */
	ConfigFileReader configFileReader;
	public WebDriver getDriver() throws Exception {
		if (driver == null) {
			ConfigFileReader configFileReader= new ConfigFileReader();
			System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
			driver = new ChromeDriver();

			driver.manage().window().maximize();

		}

		return driver;
	}

	public WebDriver encerra() {
		if (driver != null) {
			driver.close();
//			driver.quit();
		}
		return driver = null;
	}
}
