package br.com.rsinet.hub_BDD.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_BDD.cucumber.TestContext;

public class Print {

	TestContext testContext;
	
	public Print(TestContext testContext) {
		this.testContext = testContext;

	}
    public static void takeSnapShot(String nomeDoArquivoImagem, WebDriver driver) throws Exception {

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        String imageFileDir = "/Projeto_BDD/test-output";
        FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDoArquivoImagem + ".png"));

        
    }
    }





