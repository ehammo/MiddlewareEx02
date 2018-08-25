package udp;

import java.lang.StringBuilder;
import java.util.HashMap;

public class Estoque {
    HashMap<String, Integer> estoque = new HashMap<String, Integer>();

    
    public void add(String item) {
    	modify(item, true);
    }
    
    public void remove(String item) {
    	modify(item, false);
    }
    
    public String getAll() {
    	StringBuilder sb = new StringBuilder();
    	for(String item : estoque.keySet()){
    		sb.append(item)
    			.append(" ")
    			.append(estoque.get(item));
    	}
    	return sb.toString();
    }
    
    private void modify(String item, boolean positive) {
    	int qtd = estoque.getOrDefault(item, 0);
    	if(positive)
    		qtd++;
    	else
    		qtd--;
    	if(qtd<=0){
    		estoque.remove(item);
    	} else {
        	estoque.put(item, qtd);    		
    	}
    }
    
}
