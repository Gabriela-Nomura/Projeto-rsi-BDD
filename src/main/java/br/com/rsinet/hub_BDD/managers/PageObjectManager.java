package br.com.rsinet.hub_BDD.managers;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_BDD.pageFactory.CadastraPagePOF;
import br.com.rsinet.hub_BDD.pageFactory.HomePagePOF;
import br.com.rsinet.hub_BDD.pageFactory.PaginaBuscaPOF;

public class PageObjectManager {

	private WebDriver driver;

	private CadastraPagePOF cadastraPagePOF;

	private PaginaBuscaPOF buscaPage;

	private HomePagePOF homePagePOF;

	public PageObjectManager(WebDriver driver) {	 
		 this.driver = driver;
		 
		 }

	public HomePagePOF getHomePage() {

		return (homePagePOF == null) ? homePagePOF = new HomePagePOF(driver) : homePagePOF;

	}

	public CadastraPagePOF getcadastraPage() {

		return (cadastraPagePOF == null) ? cadastraPagePOF = new CadastraPagePOF(driver) : cadastraPagePOF;

	}

	public PaginaBuscaPOF getBuscaPage() {

		return (buscaPage == null) ? buscaPage = new PaginaBuscaPOF(driver) : buscaPage;

	}

}
