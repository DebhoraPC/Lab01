package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	private Parole elenco = new Parole("A");
	private List<Double> tmp = new ArrayList<>();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML // fx:id="tmpResult"
    private TextArea tmpResult; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnReset"
    private Button btnReset;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnCancella"
    private Button btnCancella; // Value injected by FXMLLoader

    @FXML
    void doInsert(ActionEvent event) {
    	
    	String p = txtParola.getText();
    	
    	if (!p.isEmpty()) {
    		
    		// Performance:
    		double start = System.nanoTime();
    		elenco.addParola(p);
    		double stop = System.nanoTime();

    		txtParola.clear();
    		txtResult.setText(""); // otherwise I will visualize names twice
    		for (String item : elenco.getElenco()) {
    			txtResult.appendText(item+"\n");
    		}
    		tmpResult.setText("");
    		tmp.add(stop-start);
    		for (double item : tmp) {
    			tmpResult.appendText(item/1e9 + " seconds\n");
    		}
    	}
    
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	
    	txtResult.setText("");
    	
    	// Performance:
    	double start = System.nanoTime();
    	elenco.reset();
    	double stop = System.nanoTime();
    	
    	tmpResult.setText("");
    	tmp.add(stop-start);
    	for (double item : tmp) {
    		tmpResult.appendText(item/1e9 + " seconds\n");
    	}
    	
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	
    	if(txtResult.getSelectedText().equals("")) {
			tmpResult.clear();
			tmpResult.setText("Seleziona una Parola!");
		}
    	else {
			String p = txtResult.getSelectedText(); // returns the selected word 
			
			// Performance:
			double start = System.nanoTime(); 
			elenco.resetParola(p);
			double stop = System.nanoTime(); 
			
			txtResult.setText(""); // now clear all and put the new list
			for (String item : elenco.getElenco()) {
				txtResult.appendText(item+"\n");
			}
			
			tmpResult.setText("");
			tmp.add(stop-start);
        	for (double item : tmp) {
        		tmpResult.appendText(item/1e9 + " seconds\n");
        	}
		}
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert tmpResult != null : "fx:id=\"tmpResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Parole.fxml'.";

    }
}
