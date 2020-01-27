package br.com.rsinet.hub_BDD.steps;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import br.com.rsinet.hub_BDD.cucumber.ContextoDeTeste;
import br.com.rsinet.hub_BDD.managers.PageObjectManager;
import br.com.rsinet.hub_BDD.managers.WebDriverManager;
import br.com.rsinet.hub_BDD.utils.MassaDeDados;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	ContextoDeTeste contextoDeTeste;
	WebDriver driver;

	public Hooks(ContextoDeTeste contextoDeTeste) {
		this.contextoDeTeste = contextoDeTeste;
	}

	@Before
	public void initConfig(Scenario scenario) throws Exception {
		driver = contextoDeTeste.getWebDriverManager().getDriver();
		MassaDeDados.configExcelCadastra();
		
	}

	@After(order=0)
	public void quitConfig() throws Exception {
		driver = contextoDeTeste.getWebDriverManager().encerra();
		Reporter.addStepLog ("O teste foi finalizado ");
	}
	@After(order=1)
	 public void afterScenario(Scenario scenario) throws WebDriverException, Exception {
		
		 String screenshotName = scenario.getName().replaceAll(" ", "_");
		
		 //This takes a screenshot from the driver at save it to the specified location
		 File sourcePath = ((TakesScreenshot) contextoDeTeste.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
		 
		 //Building up the destination path for the screenshot to save
		 //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
		 File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
		 
		 //Copy taken screenshot from source location to destination location
		 Files.copy(sourcePath, destinationPath);   
		 
		 //This attach the specified screenshot to the test
		 Reporter.addScreenCaptureFromPath(destinationPath.toString());
		 Reporter.addStepLog ("Print obtido com sucesso ");
		 }
		 }
		 



