package com.rubrica.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * ModificaListener is an implementation of the interface ActionListener.
 * If a record has been selected within Launcher table, it will launch a new
 * instance of Inserisci JFrame class. In this case, Inserisci will put 
 * the proper values within its JTextFields.
 * If there is no row selected, the listener will show only a message dialog.
 * 
 * @author Alessandro Giordano
 *
 */
public class ModificaListener implements ActionListener{

	Launcher laun;
	
	public ModificaListener(Launcher laun) {
		this.laun = laun;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int index = laun.elenco.getSelectedRow();
		if (index == -1)
			JOptionPane.showMessageDialog(null,"no.row.selected");
		else
		new Inserisci(laun, this);
		
	}
}
