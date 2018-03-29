package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	private List<String> lista;
		
	public Parole(String t) {
		if (t == "A") {
			lista = new ArrayList<String>();
		}
		if (t == "L") {
			lista = new LinkedList<String>();
		}
	}
	
	public void addParola(String p) {
		lista.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(lista); // alphabetical order 
		return lista;
	}
	
	public void reset() {
		lista.clear();
	}
	
	public void resetParola(String p) {
		lista.remove(p);
	}

}
