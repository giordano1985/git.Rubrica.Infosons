package com.rubrica.DL;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.rubrica.BC.Lista;
import com.rubrica.BC.Persona;

/**
 * This class provides all the required methods to identify the file used
 * to memorize data, as well as for writing them.
 * @author Alessandro Giordano
 *
 */
public class Writer implements DataConstants {

	public File file;
	private PrintStream write;
	private FileOutputStream fos;
	
	
	private boolean mode;
	
	public Writer() {
		try {
			file = new File(PATH);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, WRITER_FAILURE);
		}
	}

	/**
	 * This method takes the informations within the instance of Persona
	 * representing the new record and writes them inside informazioni.txt
	 * 
	 * @param persona
	 */
	public void setNext(Persona persona) {
		mode = SET_TO_APPEND;
		try {
			fos = new FileOutputStream(PATH, mode);
			write = new PrintStream(fos);
			write.print(persona.getNome());
			write.print(";");
			write.print(persona.getCognome());
			write.print(";");
			write.print(persona.getIndirizzo());
			write.print(";");
			write.print(persona.getTelefono());
			write.print(";");
			write.println(String.valueOf(persona.getEta()));

		} catch (Exception e) {
			e.getCause();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, WRITE_FAILURE);
		} 
		finally {
			write.close();
			try {
				fos.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, WRITE_FAILURE_CLOSE);
			}
		}
	}

	/**
	 * This method takes the current instance of Lista and uses it
	 * to overwrite the informations within informazioni.txt.
	 * This is done everytime a record is deleted or updated.
	 * 
	 * @param lista
	 */
	public void overwriteFile(Lista lista) {
		mode = SET_TO_OVERWRITE;
		try {
			fos = new FileOutputStream(PATH, mode);
			write = new PrintStream(fos);
			Vector<Persona> elenco = new Vector<Persona>();
			elenco = lista.getElenco();
			Iterator<Persona> iterator = elenco.iterator();
			while (iterator.hasNext()) {
				Persona record = new Persona();
				record = (Persona) iterator.next();
				write.print(record.getNome());
				write.print(";");
				write.print(record.getCognome());
				write.print(";");
				write.print(record.getIndirizzo());
				write.print(";");
				write.print(record.getTelefono());
				write.print(";");
				write.println(String.valueOf(record.getEta()));

			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, WRITE_FAILURE);
		} 
		finally {
			write.close();
			try {
				fos.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, WRITE_FAILURE_CLOSE);
			}
		}
	}
}
