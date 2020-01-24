package br.com.rsinet.hub_BDD.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub_BDD.cucumber.TestContext;
import br.com.rsinet.hub_BDD.managers.FileReaderManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
glue = { "br.com.rsinet.hub_BDD.steps" }, 

		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:report.html" }, monochrome = true)

public class TestRunner {
	TestContext testContext;
	 
	 public TestRunner(TestContext context) {
	 testContext = context;
	 }
	@AfterClass
	public static void writeExtentReport() {

		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	}

		 
		 
}