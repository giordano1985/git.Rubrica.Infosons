package com.rubrica.GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
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
	
	private String text1 = "Premere salva per confermare;";
	private String text2 = "premere annulla per annullare.";

	protected JTextField nome, cognome, indirizzo, telefono, eta;
	private JLabel nomeL, cognomeL, indL, telL, etaL, t1, t2;
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
		nome = new JTextField("inserisci nome", 20);
		cognome = new JTextField("inserisci cognome", 20);
		indirizzo = new JTextField("inserisci indirizzo", 20);
		telefono = new JTextField("inserisci telefono", 20);
		eta = new JTextField("inserisci età", 20);
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
		nomeL.setText("nome: ");
		cognomeL = new JLabel();
		cognomeL.setText("cognome: ");
		indL = new JLabel();
		indL.setText("indirizzo: ");
		telL = new JLabel();
		telL.setText("telefono: ");
		etaL = new JLabel();
		etaL.setText("eta: ");
		t1 = new JLabel();
		t1.setText(text1);
		t2 = new JLabel();
		t2.setText(text2);
		
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
		JPanel pulsanti = new JPanel();
		pulsanti.add(salva);
		pulsanti.add(annulla);
		JPanel text = new JPanel(new GridLayout(2, 1));
		text.add(t1);
		text.add(t2);
		JPanel labels = new JPanel(new GridLayout(6, 1));
		labels.add(nomeL);
		labels.add(cognomeL);
		labels.add(indL);
		labels.add(telL);
		labels.add(etaL);
		labels.add(text);
		JPanel fields  = new JPanel(new GridLayout(6, 1));
		fields.add(nome);
		fields.add(cognome);
		fields.add(indirizzo);
		fields.add(telefono);
		fields.add(eta);
		fields.add(pulsanti);
		Box group = Box.createHorizontalBox();
		group.add(labels);
		group.add(fields);
		setLayout(new FlowLayout());
		add(group);
		pack();
		setVisible(true);

		setTitle("Inserisci o modifica un contatto");
		setLocationRelativeTo(null);
	}

}
