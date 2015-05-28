package com.rubrica.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * AnnullaListener is an implementation of the interface ActionListener.
 * It takes the current instance of the class Inserisci extends JFrame and 
 * closes it.
 * 
 * @author Alessandro Giordano
 *
 */
public class AnnullaListener implements ActionListener{

	Inserisci inserisci;
	
	public AnnullaListener(Inserisci ins) {
		this.inserisci = ins;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		inserisci.setVisible(false);
	}

}
