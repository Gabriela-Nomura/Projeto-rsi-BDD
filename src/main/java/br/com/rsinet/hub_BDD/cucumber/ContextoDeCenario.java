package br.com.rsinet.hub_BDD.cucumber;

import java.util.HashMap;
import java.util.Map;

import enums.Contexto;

public class ContextoDeCenario {
	/**
	 * Classe que manipula os cenarios, a fim de passar informações entre as classes
	 */
	private  Map<String, Object> scenarioContext;
	 
    public ContextoDeCenario(){
        scenarioContext = new HashMap<String, Object>();
    }

    public void setContext(Contexto key, Object value) {
        scenarioContext.put(key.toString(), value);
    }
//Acessa o contexto atraves de um get
    public Object getContexto(Contexto key){
        return scenarioContext.get(key.toString());
    }
//Verifica se o cenario possui valor carregado
    public Boolean isContains(Contexto key){
        return scenarioContext.containsKey(key.toString());
    }

}

