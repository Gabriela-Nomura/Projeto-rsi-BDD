package br.com.rsinet.hub_BDD.steps;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import br.com.rsinet.hub_BDD.cucumber.TestContext;
import br.com.rsinet.hub_BDD.managers.PageObjectManager;
import br.com.rsinet.hub_BDD.managers.WebDriverManager;
import br.com.rsinet.hub_BDD.utils.MassaDeDados;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	TestContext testContext;
	WebDriver driver;

	public Hooks(TestContext testContext) {
		this.testContext = testContext;
	}

	@Before
	public void initConfig(Scenario scenario) throws Exception {
		driver = testContext.getWebDriverManager().getDriver();
		MassaDeDados.configExcelCadastra();

	}

	@After(order=0)
	public void quitConfig() throws Exception {
		driver = testContext.getWebDriverManager().encerra();
	}
	@After(order=1)
	 public void afterScenario(Scenario scenario) throws WebDriverException, Exception {
		
		 String screenshotName = scenario.getName().replaceAll(" ", "_");
		
		 //This takes a screenshot from the driver at save it to the specified location
		 File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
		 
		 //Building up the destination path for the screenshot to save
		 //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
		 File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
		 
		 //Copy taken screenshot from source location to destination location
		 Files.copy(sourcePath, destinationPath);   
		 
		 //This attach the specified screenshot to the test
		 Reporter.addScreenCaptureFromPath(destinationPath.toString());
		 }
		 }
		 

//			 Reporter.setSystemInfo("Nome de usuario: ", System.getProperty("user.name"));


