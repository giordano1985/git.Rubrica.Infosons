package com.rubrica.DL;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;

import com.rubrica.BC.Persona;

/**
 * This class provides all the required methods to identify the file used to
 * memorize data, as well as for reading them.
 * 
 * @author Alessandro Giordano
 *
 */
public class Reader implements DataConstants {

	public File file;
	private FileReader reader;
	private Scanner sc;
	private Persona record;

	public Reader() {
		file = new File(PATH);
		try {
			if (file.exists()) {
				reader = new FileReader(PATH);
				sc = new Scanner(reader);
				sc.useDelimiter(";|"+ LINE_SEPARATOR_PATTERN);
				JOptionPane.showMessageDialog(null, INFO_MESSAGE);
			} else
				return;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			JOptionPane.showMessageDialog(null, READER_FAILURE);
		}
	}

	/**
	 * This method takes all the records from informazioni.txt, puts the fields
	 * of each of them inside an instance of Persona and returns a
	 * Vector<Persona> which contains all the data.
	 * Note that the exception handling is designed to ignore the exception thrown
	 * by the FileReader buffer, because it does not affect the retrieval of data.
	 * 
	 * @return Vector<Persona>
	 */
	public Vector<Persona> getData() {
		Vector<Persona> data = new Vector<Persona>();
		try {
			while (sc.hasNext()) {
				record = new Persona();
				record.setNome(sc.next());
				record.setCognome(sc.next());
				record.setIndirizzo(sc.next());
				record.setTelefono(sc.next());
				record.setEta(sc.nextInt());
				data.add(record);
			}
		} 
		catch (Exception e) {
			try {
				if (reader.ready()|!(e instanceof NoSuchElementException)) {
					e.getCause();
					e.getMessage();
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, READ_FAILURE);
				}
			} 
			catch (HeadlessException | IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, READ_FAILURE);
			}
		} 
		finally {
			sc.close();
			try {
				reader.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, READ_FAILURE_CLOSE);
			}
		}
		return data;
	}

}
