package br.com.rsinet.hub_BDD.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
glue = { "br.com.rsinet.hub_BDD.steps" },
tags = 
//{"@CadastroValido, @CadastroInvalido"},
{"@BuscaLupaSucesso, @BuscaLupaFalha "},
//"@BuscaCliqueSucesso, @BuscaCliqueFalha "},
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
monochrome = true)

public class TestRunner {

}
