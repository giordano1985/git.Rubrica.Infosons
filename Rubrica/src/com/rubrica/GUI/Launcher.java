package com.rubrica.GUI;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import com.rubrica.BC.*;
import com.rubrica.DL.DataConstants;

/**
 * Launcher class builds and shows the initial frame of the application,
 * which contains a dynamic JTable of all the records, plus three buttons.
 * Button 'nuovo' enables the user to create a new record, buttons 'modifica'
 * and elimina respectively enable to modify an existing record and delete it.
 * The frame also shows the path of the file in which all the data 
 * are going to be be saved.
 * 
 * @author Alessandro Giordano
 *
 */
public class Launcher extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// widgets
	private JLabel showPath;
	private JButton nuovo, modifica, elimina;
	protected JTable elenco;
	protected TabellaModel tabella;

	protected Vector<Persona> values;

	private String path = "I dati verranno salvati su: " + DataConstants.PATH
			+ ", se esiste.";

	public Launcher() {
		initComp();
		createLayout();	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	/**
	 * private method that initializes all the components of 
	 * the current frame. 
	 */
	private void initComp() {
		
		showPath = new JLabel();
		showPath.setText(path);
		showPath.setHorizontalAlignment(SwingConstants.CENTER);

		nuovo = new JButton("nuovo contatto");
		modifica = new JButton("modifica contatto");
		elimina = new JButton("elimina contatto");
		
		nuovo.addActionListener(new NuovoListener(this));
		modifica.addActionListener(new ModificaListener(this));
		elimina.addActionListener(new EliminaListener(this));
		
		tabella = new TabellaModel(); //table data set
		values = new Vector<Persona>();
		values = tabella.getElenco(); //complete data set
		elenco = new JTable(tabella);
		elenco.setModel(tabella);
		elenco.setVisible(true);
	}
	

	/**
	 * private method that builds the layout of the current
	 * frame.
	 */
	private void createLayout() {
		JPanel panel1 = new JPanel();
		panel1.add(nuovo);
		panel1.add(modifica);
		panel1.add(elimina);
		JScrollPane scrollpane = new JScrollPane(elenco);
		setLayout(new BorderLayout());
		add(showPath, BorderLayout.NORTH);
		add(scrollpane, BorderLayout.CENTER); 
		add(panel1, BorderLayout.SOUTH);  
		setVisible(true);
		
		setTitle("Rubrica Telefonica");
		setSize(500, 400);
		setLocationRelativeTo(null);
	}
	
	
	public static void main(String[] args) {
		new Launcher();
	}
}
