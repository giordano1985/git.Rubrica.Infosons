package test.com.rubrica;

import java.util.Vector;

import com.rubrica.BC.Lista;
import com.rubrica.BC.Persona;

import junit.framework.TestCase;

public class ListaTest extends TestCase {


	Lista lista;
	Persona persona1, persona2, persona3; 
	
	protected void setUp() throws Exception {
		
		lista = new Lista();
		
		persona1 = new Persona();
		persona1.setNome("Mario");
		persona1.setCognome("Rossi");
		persona1.setIndirizzo("Via Camelie, 3");
		persona1.setTelefono("0123456789");
		persona1.setEta(40);
			
		persona2 = new Persona();
		persona2.setNome("Giuseppe");
		persona2.setCognome("Verdi");
		persona2.setIndirizzo("Via Nabucodonosor, 55");
		persona2.setTelefono("0333555888");
		persona2.setEta(65);
		
		persona3 = new Persona();
		persona3.setNome("Steve");
		persona3.setCognome("Harris");
		persona3.setIndirizzo("Via della Vergine di Ferro, 66");
		persona3.setTelefono("0666666666");
		persona3.setEta(57);
	}
	
	public void testCreate() {
		boolean createCheck = false;
		createCheck= lista.create(persona1);
		Vector<Persona> elenco = new Vector<Persona>();
		elenco = lista.getElenco();
		if ((elenco.lastElement().equals(persona1))&(createCheck==true)) 
			lista.resetElenco();
		else {
		fail();
		lista.resetElenco();
		}
	}
	
	public void testUpdate() {
		lista.create(persona1);
		lista.create(persona2);
		persona1.setIndirizzo("Via Crisantemi, 6");
		boolean updateCheck = lista.update(persona1, 0);
		String indirizzo = lista.getElenco().get(0).getIndirizzo();
		if ((indirizzo == "Via Crisantemi, 6")&(updateCheck == true))
			lista.resetElenco();
		else {
			fail();
			lista.resetElenco();
		}
		
	}
	
	public void testDelete() {
		lista.create(persona1);
		lista.create(persona2);
		lista.create(persona3);
		boolean deleteCheck = lista.delete(persona3, 2);
		int lengthCheck = lista.getElenco().size();
		if ((lengthCheck == 2)&(deleteCheck == true))
			lista.resetElenco();
		else {
			fail();
			lista.resetElenco();
		}				
	}
}
