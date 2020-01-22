package br.com.rsinet.hub_BDD.testRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = { "br.com.rsinet.hub_BDD.stepDefinitions" }, plugin = {
		"pretty", "html:target/report.html", "json:target/report.json" }, monochrome = true)

public class TestRunner {

}
