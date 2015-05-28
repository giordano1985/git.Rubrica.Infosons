package com.rubrica.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * NuovoListener is an implementation of the interface ActionListener.
 * When the button 'Nuovo' is clicked, the listener will launch a new instance of 
 * Inserisci JFrame class, in which all the fields will be empty.
 * 
 * @author Alessandro Giordano
 *
 */
public class NuovoListener implements ActionListener{

	Launcher laun;
	
	public NuovoListener(Launcher laun) {
		this.laun = laun;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new Inserisci(laun, this);
	}
	
}
