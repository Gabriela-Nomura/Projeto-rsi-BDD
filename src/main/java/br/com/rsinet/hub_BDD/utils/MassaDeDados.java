package br.com.rsinet.hub_BDD.utils;

public class MassaDeDados {
	/**
	 * Classe para fixa��o de atributos MassaDeDados.
	 */
	public static String URL = "https://www.advantageonlineshopping.com/";

	public static final String Path_TestData = "C://Users//gabriela.nomura//Documents//automacao//testData.xlsx";

	public static final String userName(int i ) throws Exception {
		return ConfigExcel.getCellData(i, 0);
	}

	public static final String userEmail() throws Exception {
		return ConfigExcel.getCellData(1, 1);
	}

	public static final String userSenha() throws Exception {
		return ConfigExcel.getCellData(1, 2);
	}

	public static final String userSenhaConfirmacao() throws Exception {
		return ConfigExcel.getCellData(1, 3);
	}

	public static final String userPrimeiroNome() throws Exception {
		return ConfigExcel.getCellData(1, 4);
	}

	public static final String userUltimoNome() throws Exception {
		return ConfigExcel.getCellData(1, 5);
	}

	public static final String userTelefone() throws Exception {
		return ConfigExcel.getCellData(1, 6).toString();
	}
	
	public static final String userCidade() throws Exception {
		return ConfigExcel.getCellData(1, 7);
	}
	
	public static final String userEndereco() throws Exception {
		return ConfigExcel.getCellData(1,8);
	}
	public static final String userEstado() throws Exception {
		return ConfigExcel.getCellData(1,9);
	}
	
	public static final String userCep() throws Exception {
	return ConfigExcel.getCellData(1, 10).toString();
	}
	
	public static final String buscaLupa() throws Exception {
	return ConfigExcel.getCellData(1, 0);
	}
	public static final String buscaLupaFalha() throws Exception {
		return ConfigExcel.getCellData(2, 0);
		}
}