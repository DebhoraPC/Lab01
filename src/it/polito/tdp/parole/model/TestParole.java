package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.List;

public class TestParole {

	public static void main(String[] args) {
		
		Parole elenco = new Parole("A");
		Parole elencoL = new Parole("L");
		double start, stop;
		int dim = 50;
		
		String[] parole = new String[dim]; // elenco di parole random
		String s; int j = 0;
		while (j<dim) {
			s = "";
			for (int i=0; i<10; i++) {
				int ints = (int)(Math.random()*25) + 97; // intero random da 97 a 97+25=122 codice ASCII
				s += (char) ints;
			}
			parole[j] = s;
			j++;
		}
		
		// ALTRO METODO PER GENERARE UN INSIEME DI PAROLE RANDOM (PIU' FACILE)
		List<String> esempio = new ArrayList<String>();
		for (int i=0; i < 10000; i++)
			esempio.add("parola..." + i);
		
		System.out.println("Prestazioni che riguardano ArrayList:\n");
		
		start = System.nanoTime();
		for (String item : parole) {
			elenco.addParola(item);
		}
		stop = System.nanoTime();
		System.out.println("[INSERT]: " + (stop - start) / 1e9 + " seconds\n");
		
		start = System.nanoTime();
		elenco.resetParola(parole[1]);
		stop = System.nanoTime();
		System.out.println("[REMOVE]: " + (stop - start) / 1e9 + " seconds\n");
		
		start = System.nanoTime();
		elenco.reset();
		stop = System.nanoTime();
		System.out.println("[REMOVE ALL]: " + (stop - start) / 1e9 + " seconds\n");
		
		System.out.println("Prestazioni che riguardano LinkedList:\n");
		
		start = System.nanoTime();
		for (String item : parole) {
			elencoL.addParola(item);
		}
		stop = System.nanoTime();
		System.out.println("[INSERT]: " + (stop - start) / 1e9 + " seconds\n");
		
		start = System.nanoTime();
		elencoL.resetParola(parole[1]);
		stop = System.nanoTime();
		System.out.println("[REMOVE]: " + (stop - start) / 1e9 + " seconds\n");
		
		start = System.nanoTime();
		elencoL.reset();
		stop = System.nanoTime();
		System.out.println("[REMOVE ALL]: " + (stop - start) / 1e9 + " seconds\n");
		
	}

}
