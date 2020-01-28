# language: pt
#coding: UTF-8

Funcionalidade: Busca pelo campo de busca
Testa o resultado obtido atraves da busca pelo campo na tela inicial
@BuscaLupaSucesso
	Cenario: Busca pela lupa valida
		Dado que esteja na pagina inicial da aplicacao
		Quando clicar sobre a lupa
		E enviar um texto de busca
		E selecionar um dos produtos obtidos como resultado
		Entao o produto aberto deve ser correspondente ao que recebeu o clique
	
	@BuscaLupaFalha
		Cenario: Busca pela lupa invalida
		Dado que esteja na pagina inicial da aplicacao
		Quando clicar sobre a lupa
		E enviar o texto de busca com o nome do produto
		Entao a busca nao retorna nenhum resultado 

	
