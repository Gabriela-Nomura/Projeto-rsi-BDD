package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	/**
	 * Classe de configuração de leitor de arquivos
	 */
	private Properties properties;
	private final String propertyFilePath = "configs/configuracoes.properties";

	// metodo de leitor de arquivo
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Arquivo de configuracoes nao encontrado no caminho " + propertyFilePath);
		}
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("DriverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("O caminho para o driver nao foi configurado no arquivo de propriedades");
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("A url n�o foi especificada no arquivo de configuracoes");
	}

	public String getReportConfigPath() {
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}
}
