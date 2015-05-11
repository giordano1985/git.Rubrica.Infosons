package com.rubrica.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.rubrica.BC.BCMessages;
import com.rubrica.BC.Persona;
import com.rubrica.BC.TabellaModel;

/**
 * SalvaListener is an implementation of the interface ActionListener.
 * It takes the current instance of the class Inserisci extends JFrame, using
 * the fields within it to create a new record or update an existing one.
 * 
 * @author Alessandro Giordano
 *
 */
public class SalvaListener implements ActionListener, BCMessages {

	Inserisci inserisci;
	TabellaModel tabellaModel;

	public SalvaListener(Inserisci ins) {
		this.inserisci = ins;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JTextField nome = inserisci.nome;
		JTextField cognome = inserisci.cognome;
		JTextField indirizzo = inserisci.indirizzo;
		JTextField telefono = inserisci.telefono;
		JTextField eta = inserisci.eta;
		tabellaModel = inserisci.launcher.tabella;
		if(inserisci.getModifica()==true) {
			Persona updated = new Persona();
			try {
				updated.setNome(nome.getText());
				updated.setCognome(cognome.getText());
				updated.setIndirizzo(indirizzo.getText());
				updated.setTelefono(telefono.getText());
				updated.setEta(Integer.parseInt(eta.getText()));
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, NFE_MESSAGE);
			}
			tabellaModel.updateLista(updated, inserisci.launcher.elenco.getSelectedRow());
			tabellaModel.setValueAt(nome.getText(), inserisci.launcher.elenco.getSelectedRow(), 0);
			tabellaModel.setValueAt(cognome.getText(), inserisci.launcher.elenco.getSelectedRow(), 1);
			tabellaModel.setValueAt(telefono.getText(), inserisci.launcher.elenco.getSelectedRow(), 2);
		}
		else {
		Object[] rowData = { nome.getText(), cognome.getText(),
				telefono.getText(), indirizzo.getText(), eta.getText() };
		tabellaModel.addRow(rowData);
		}
		inserisci.setVisible(false);
	}
}
