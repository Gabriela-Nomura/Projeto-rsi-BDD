package br.com.rsinet.hub_BDD.cucumber;

import java.util.HashMap;
import java.util.Map;

import enums.Contexto;

public class ContextoDeCenario {
	
	private  Map<String, Object> scenarioContext;
	 
    public ContextoDeCenario(){
        scenarioContext = new HashMap<>();
    }

    public void setContext(Contexto key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContexto(Contexto key){
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(Contexto key){
        return scenarioContext.containsKey(key.toString());
    }

}

