package com.rubrica.BC;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * The class TabellaModel inherits methods and functionalities
 * from DefaultTableModel and represents the data set used to build
 * the JTable.
 * @author Alessandro Giordano
 *
 */
public class TabellaModel extends DefaultTableModel implements BCMessages {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Lista lista;
	private Persona persona;
	private Vector<Persona> elenco;
	private String[] columnNames = {"nome","cognome","telefono"};
	private String[][] values;
	
	
	/**
	 * The constructor takes all the values form Lista class
	 * and makes them available to build a Table. 
	 * Informations are retrieved as a Vector<Persona> and
	 * put into an array of arrays, which will be used to
	 * set the member variable dataVector.
	 */
	public TabellaModel() {
        lista = new Lista();
        elenco = new Vector<Persona>();
        elenco =lista.getElenco();
        values = new String[elenco.size()][3];
        Iterator<Persona> iterator = elenco.iterator();
        while (iterator.hasNext()) {
			for (int i = 0; i < elenco.size(); i++) {
				persona = new Persona();
				persona = (Persona) iterator.next();
				values[i][0] = persona.getNome();
				values[i][1] = persona.getCognome();
				values[i][2] = persona.getTelefono();	
			}
		}
        setDataVector(values, columnNames);	
      }
	
	public Vector<Persona> getElenco() {
		return elenco;
	}
	
	/**
	 * public void addRow(rowData) overrides the method of the superclass
	 * DefaultTableModel, adding all the required code to implement the 
	 * creation of the new record within Lista.elenco.
	 * @param rowData
	 * 
	 */
	@Override
	public void addRow(Object[] rowData) {
		try{
			Persona newRecord = new Persona();
			newRecord.setNome((String)rowData[0]);
			newRecord.setCognome((String)rowData[1]);
			newRecord.setTelefono((String)rowData[2]);
			newRecord.setIndirizzo((String)rowData[3]);
			newRecord.setEta(Integer.parseInt((String)rowData[4]));
			lista.create(newRecord);
			super.addRow(rowData);
		}
		catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, NFE_MESSAGE);
		}
	}
	
	/**
	 * public void removeRow(row) overrides the method of the superclass
	 * DefaultTableModel, adding all the required code to remove
	 * the record at the given index within Lista.elenco too.
	 * @param int row
	 * 
	 */
	@Override
	public void removeRow(int row) {
		super.removeRow(row);
		elenco = lista.getElenco();
		Persona removable = new Persona();
		removable.setNome(elenco.elementAt(row).getNome());
		removable.setCognome(elenco.elementAt(row).getCognome());
		removable.setTelefono(elenco.elementAt(row).getTelefono());
		removable.setIndirizzo(elenco.elementAt(row).getIndirizzo());
		removable.setEta(elenco.elementAt(row).getEta());
		try {
			lista.delete(removable, row);
			}
			catch (ArrayIndexOutOfBoundsException aioe) {
				String message = AIOE_MESSAGE
						+row + " on table "
						+lista.getElenco().indexOf(removable)
						+ " on Lista ";
				JOptionPane.showMessageDialog(null, message);
			}
	}
	
	/**
	 * This method calls the update method of Lista class, enabling
	 * the user to update a record within Lista.elenco too.
	 * @param updated
	 * @param index
	 */
	public void updateLista(Persona updated, int index) {
			lista.update(updated, index);
	}
	
}
