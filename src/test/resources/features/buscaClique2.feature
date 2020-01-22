#Feature: Busca por cliques
#Testa o produto aberto após a seleção por cliques
#
#	Scenario: Busca por clique com sucesso
#		Given que esteja na pagina inicial da aplicacao
#		When eu clicar sobre uma categoria de produtos
#		And selecionar um dos produtos
#		And adicionar um item ao carrinho
#		And clicar no checkout
#		Then o produto adicionado ao carrinho deve ser igual ao produto selecionado	
#
#	Scenario: Busca por clique Invalida
#		Given que esteja na pagina inicial da aplicacao
#		When eu clicar sobre o link de produto populares
#		And tirar um print
#		And selecionar o produto 
#		And adicionar no carrinho
#		Then o produto aberto sera diferente do produto selecionado