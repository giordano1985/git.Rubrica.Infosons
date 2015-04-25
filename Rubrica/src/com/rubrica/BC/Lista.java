package com.rubrica.BC;

import java.util.Vector;

import com.rubrica.DL.Reader;
import com.rubrica.DL.Writer;

/**
 * This class provides the methods to visualize and update 
 * the Vector<Persona> object which contains all the memorized records.
 * @author Alessandro Giordano
 *
 */
public class Lista {
	
	private Vector<Persona> elenco;
	private Reader r;
	private Writer w;
	//private ContattiStub stub = new ContattiStub();
	
	public Lista(){
		elenco = new Vector<Persona>();
		//elenco = stub.getStub();
		r = new Reader();
		w = new Writer();
		if (r.file.exists()) 
			elenco = r.getData();
	}
	

	public Vector<Persona> getElenco() {
		return elenco;
	}
	
	public void setElenco(Vector<Persona> elenco) {
		this.elenco=elenco;
	}
	
	public void resetElenco() {
		elenco.clear();
	}
	
	/**
	 * this method creates a new record and inserts it
	 * into the collection. If the operation is successful
	 * it returns true, it returns false elsewhere.
	 * @param newRecord
	 * @return boolean
	 */
	public boolean create(Persona newRecord) {
		if (newRecord == null) {
			return false;
		}
		if(elenco.add(newRecord) == true) {
			if (w.file.exists())
				w.setNext(newRecord);
			return true;
		}
		return false;
	}
	
	/**
	 * this method updates the values of a record,
	 * which is specified by the passed index.
	 * If the operation is successful
	 * it returns true, it returns false elsewhere.
	 * @param updated
	 * @param index
	 * @return boolean
	 */
	public boolean update(Persona updated, int index) {
		elenco.set(index, updated);
		if (!elenco.get(index).equals(updated)) 
			return false;
		overWrite();
		return true;
	}
	
	/**
	 * this method deletes a record from the collection,
	 * which is specified by the passed index.
	 * If the operation is successful
	 * it returns true, it returns false elsewhere.
	 * @param removable
	 * @param index
	 * @return boolean
	 */
	public boolean delete(Persona removable, int index) {
		elenco.removeElementAt(index);
		if(!elenco.contains(removable)) {
			overWrite();
			return true; 
		}
		return false;
	}
	
	/**
	 * private method overWrite() takes the current instance of
	 * Lista and passes it to the overwriteFile method of Writer class,
	 * enabling this method to update the txt file. If the the file does not
	 * exist, the method does nothing.
	 */
	private void overWrite() {
		if (w.file.exists())
			w.overwriteFile(this);
		else
			return;
	}
}
