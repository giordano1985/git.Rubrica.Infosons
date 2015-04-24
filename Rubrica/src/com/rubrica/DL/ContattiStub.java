package com.rubrica.DL;
 
import java.util.Vector;

import com.rubrica.BC.Persona;

/**
 * This class acts as a stub, creating some contacts
 * in an object Vector<Persona>
 * @author Alessandro Giordano
 *
 */
public class ContattiStub {
	
	private Persona tizio, caio, sempronio, lucio;
	private Vector<Persona> elenco;

	public Vector<Persona> getStub() {
		tizio = new Persona();
		tizio.setNome("Tizio");
		tizio.setCognome("Tizi");
		tizio.setIndirizzo("Via dei Tizi, 1");
		tizio.setTelefono("0123456");
		tizio.setEta(33);
		
		caio = new Persona();
		caio.setNome("Caio");
		caio.setCognome("Caiuzzi");
		caio.setIndirizzo("Via dei Cannoni, 2");
		caio.setTelefono("0333444");
		caio.setEta(44);
		
		sempronio = new Persona();
		sempronio.setNome("Sempronio");
		sempronio.setCognome("Semproni");
		sempronio.setIndirizzo("Via dei Sassi Sgonfi, 3");
		sempronio.setTelefono("0011445");
		sempronio.setEta(55);
		
		lucio = new Persona();
		lucio.setNome("Lucio");
		lucio.setCognome("Luci");
		lucio.setIndirizzo("Via delle Lucertole, 4");
		lucio.setTelefono("0987654");
		lucio.setEta(66);
		
		elenco = new Vector<Persona>();
		elenco.add(tizio);
		elenco.add(caio);
		elenco.add(sempronio);
		elenco.add(lucio);
		return elenco;
	}


}