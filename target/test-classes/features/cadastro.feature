# language: pt
#coding: UTF-8
Funcionalidade: Cadastro de novos usuarios

Deve realizar o cadastro de um novo usuario com informacoes validas, 
e rejeitar tentativas com informacoes incorretas.

Contexto:
	Dado que esteja na pagina inicial da aplicacao
	Quando clicar sobre minha conta
	
@CadastroValido
Cenario: Cadastro de um novo usuario com sucesso
		
		E selecionar a opcao criar nova conta
		E inserir um nome de usuario valido
		E inserir email valido
		E inserir senha valida
		E inserir contra senha valida 
		E inserir o primeiro nome
		E inserir o ultimo nome
		E inserir o numero de telefone
		E selecionar o pais
		E informar a cidade
		E informar o endereco 
		E informar o estado 
		E informar o CEP
		E aceitar os termos de aceitacao
		E clicar no registro
		Entao o novo usuario deve ser logado e direcionado a homepage com nome de usuario sendo exibido
		
@CadastroInvalido
Cenario: Cadastro de um novo usuario com falha
		
		E selecionar a opcao criar nova conta
		E inserir um nome de usuario invalido
		E inserir email valido
		E inserir senha valida
		E inserir contra senha valida 
		E inserir o primeiro nome
		E inserir o ultimo nome
		E inserir o numero de telefone
		E selecionar o pais
		E informar a cidade
		E informar o endereco 
		E informar o estado 
		E informar o CEP
		E aceitar os termos de aceitacao
		E clicar no registro 
		Entao o cadastro nao sera concluido e a mensagem de erro aparecera