package br.com.rsinet.hub_BDD.managers;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_BDD.pageFactory.CadastraPage_POF;
import br.com.rsinet.hub_BDD.pageFactory.HomePage_POF;
import br.com.rsinet.hub_BDD.pageFactory.PaginaBusca_POF;

public class PageObjectManager {

	private WebDriver driver;

	private CadastraPage_POF cadastraPage;

	private PaginaBusca_POF buscaPage;

	private HomePage_POF homePage;

	public PageObjectManager(WebDriver driver) {	 
		 this.driver = driver;
		 
		 }

	public HomePage_POF getHomePage() {

		return (homePage == null) ? homePage = new HomePage_POF(driver) : homePage;

	}

	public CadastraPage_POF getcadastraPage() {

		return (cadastraPage == null) ? cadastraPage = new CadastraPage_POF(driver) : cadastraPage;

	}

	public PaginaBusca_POF getBuscaPage() {

		return (buscaPage == null) ? buscaPage = new PaginaBusca_POF(driver) : buscaPage;

	}

}
