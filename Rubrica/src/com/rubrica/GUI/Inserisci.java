package com.rubrica.GUI;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.rubrica.BC.Persona;

/**
 * Inserisci class builds and shows the frame that is used to create a new
 * record or update an existing one. If the calling listener is an instance of
 * ModificaListener, the frame will take the values of the record that the user wants
 * to modify, putting them within the JTextFields. 
 * Elsewhere, the fields within the frame will be empty.
 * 
 * @author Alessandro Giordano
 *
 */
public class Inserisci extends JFrame {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean modifica;

	protected JTextField nome, cognome, indirizzo, telefono, eta;
	private JLabel nomeL, cognomeL, indL, telL, etaL;
	JButton salva, annulla;
	Launcher launcher;
	ActionListener list;

	public Inserisci(Launcher laun, ActionListener list) {
		this.launcher = laun;
		this.list = list;
		setModifica();
		initComp();
		createLayout();
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	/**
	 * This private method sets the boolean value modifica, according to the
	 * instance of the calling listener.
	 */
	private void setModifica() {
		if (list instanceof ModificaListener)
			modifica = true;
		else
			modifica = false;
	}

	public boolean getModifica() {
		return modifica;
	}

	/**
	 * private method that initializes all the components of the current frame.
	 */
	private void initComp() {
		nome = new JTextField("inserisci nome", 25);
		cognome = new JTextField("inserisci cognome", 25);
		indirizzo = new JTextField("inserisci indirizzo", 25);
		telefono = new JTextField("inserisci telefono", 25);
		eta = new JTextField("inserisci età", 25);
		if (modifica == true) {
			Persona temp = new Persona();
			temp.setNome(launcher.values.elementAt(
					launcher.elenco.getSelectedRow()).getNome());
			temp.setCognome(launcher.values.elementAt(
					launcher.elenco.getSelectedRow()).getCognome());
			temp.setIndirizzo(launcher.values.elementAt(
					launcher.elenco.getSelectedRow()).getIndirizzo());
			temp.setTelefono(launcher.values.elementAt(
					launcher.elenco.getSelectedRow()).getTelefono());
			temp.setEta(launcher.values.elementAt(
					launcher.elenco.getSelectedRow()).getEta());
			nome.setText(temp.getNome());
			cognome.setText(temp.getCognome());
			indirizzo.setText(temp.getIndirizzo());
			telefono.setText(temp.getTelefono());
			eta.setText(String.valueOf(temp.getEta()));
		}
		
		nomeL = new JLabel();
		nomeL.setText("nome");
		cognomeL = new JLabel();
		cognomeL.setText("cognome");
		indL = new JLabel();
		indL.setText("indirizzo");
		telL = new JLabel();
		telL.setText("telefono");
		etaL = new JLabel();
		etaL.setText("eta");
		
		salva = new JButton();
		salva.setText("salva");
		annulla = new JButton();
		annulla.setText("annulla");

		salva.addActionListener(new SalvaListener(this));
		annulla.addActionListener(new AnnullaListener(this));
	}

	/**
	 * private method that builds the layout of the current frame.
	 */
	private void createLayout() {
		JPanel n = new JPanel();
		n.add(nome);
		n.add(nomeL);
		JPanel c = new JPanel();
		c.add(cognome);
		c.add(cognomeL);
		JPanel i = new JPanel();
		i.add(indirizzo);
		i.add(indL);
		JPanel t = new JPanel();
		t.add(telefono);
		t.add(telL);
		JPanel e = new JPanel();
		e.add(eta);
		e.add(etaL);
		JPanel pulsanti = new JPanel();
		pulsanti.add(salva);
		pulsanti.add(annulla);
		setLayout(new GridLayout(6, 1));
		add(n);
		add(c);
		add(i);
		add(t);
		add(e);
		add(pulsanti);
		pack();
		setVisible(true);

		setTitle("Inserisci o modifica un contatto");
		setLocationRelativeTo(null);
	}

}
