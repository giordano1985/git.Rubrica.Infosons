package com.rubrica.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * EliminaListener is an implementation of the interface ActionListener.
 * If a record has been selected within Launcher table, it will show a 
 * confirm dialog. If the user clicks on the button corresponding to YES_OPTION,
 * the selected record will be deleted from the table.
 * If there is no row selected, the listener will show only a message dialog.
 * 
 * * @author Alessandro Giordano
 *
 */
public class EliminaListener implements ActionListener {

	Launcher laun;

	public EliminaListener(Launcher laun) {
		this.laun = laun;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int index = laun.elenco.getSelectedRow();
		if (index == -1)
			JOptionPane.showMessageDialog(null, "no.row.selected");
		else {
			int reply = JOptionPane.showConfirmDialog(
					null,
					"Confermi eliminazione di "
							+ laun.tabella.getValueAt(
									laun.elenco.getSelectedRow(), 0)
							+ " "
							+ laun.tabella.getValueAt(
									laun.elenco.getSelectedRow(), 1) + "?");
			if (reply == JOptionPane.YES_OPTION) {
				laun.tabella.removeRow(laun.elenco.getSelectedRow());
			}

		}
	}

}
