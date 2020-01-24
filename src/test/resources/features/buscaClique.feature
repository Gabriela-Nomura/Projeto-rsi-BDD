# language: pt
#coding: UTF-8

Funcionalidade: Busca por cliques
Testa o produto aberto apos a selecao por cliques

@BuscaCliqueSucesso
Cenario: Busca por clique com sucesso
		Dado que esteja na pagina inicial da aplicacao
		Quando eu clicar sobre uma categoria de produtos
		E selecionar um dos produtos
		E adicionar um item ao carrinho
		E clicar no checkout
		Entao o produto adicionado ao carrinho deve ser igual ao produto selecionado	
		
@BuscaCliqueFalha
Cenario: Busca por clique Invalida
		Dado que esteja na pagina inicial da aplicacao
		Quando eu clicar sobre o link de produto populares
		E tirar um print
		E selecionar o produto 
		E adicionar um item ao carrinho
		Entao o produto aberto sera diferente do produto selecionado