/**
 * 
 * AUTOR: VÍCTOR HERNÁNDEZ PÉREZ
 * ASIGNATURA: PROGRAMACIÓN DE APLICACIONES INTERACTIVAS
 * E-MAIL: alu0100697032@ull.edu.es
 * 20/11/2014
 * DibujaPanelBotones.java
 * BusquedaIAA
 */
package Dibujables;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Victor
 *
 */
@SuppressWarnings("serial")
public class DibujaPanelBotones extends JPanel{

	/*
	 * ATRIBUTOS
	 */
	private int altoPanelBotones = 100;
	private JButton crearEntorno;
	private JButton reset;
	private JLabel anchoEntorno;
	private JLabel altoEntorno;
	private JTextField insertarAnchoEntorno;
	private JTextField insertarAltoEntorno;
	
	public DibujaPanelBotones(int ancho, int alto){
		setBounds(0, alto - altoPanelBotones, ancho, altoPanelBotones);
		setLayout(new GridLayout(1,0));
		add(setCrearEntorno(new JButton("Crear Entorno")));
		add(setAnchoEntorno(new JLabel("Ancho")));
		add(setInsertarAnchoEntorno(new JTextField("10")));
		add(setAltoEntorno(new JLabel("Alto")));
		add(setInsertarAltoEntorno(new JTextField("10")));
		add(setReset(new JButton("Reset")));
		setVisible(true);
	}

	/**
	 * @return the crearEntorno
	 */
	public JButton getCrearEntorno () {
		return crearEntorno;
	}

	/**
	 * @param crearEntorno the crearEntorno to set
	 */
	public JButton setCrearEntorno (JButton crearEntorno) {
		this.crearEntorno = crearEntorno;
		return crearEntorno;
	}
	
	public void addCrearEntornoListener(ActionListener a){
		crearEntorno.addActionListener(a);
	}

	/**
	 * @return the insertarAnchoEntorno
	 */
	public JTextField getInsertarAnchoEntorno () {
		return insertarAnchoEntorno;
	}

	/**
	 * @param insertarAnchoEntorno the insertarAnchoEntorno to set
	 */
	public JTextField setInsertarAnchoEntorno (JTextField insertarAnchoEntorno) {
		this.insertarAnchoEntorno = insertarAnchoEntorno;
		return insertarAnchoEntorno;
	}

	/**
	 * @return the insertarAltoEntorno
	 */
	public JTextField getInsertarAltoEntorno () {
		return insertarAltoEntorno;
	}

	/**
	 * @param insertarAltoEntorno the insertarAltoEntorno to set
	 */
	public JTextField setInsertarAltoEntorno (JTextField insertarAltoEntorno) {
		this.insertarAltoEntorno = insertarAltoEntorno;
		return insertarAltoEntorno;
	}

	/**
	 * @return the altoPanelBotones
	 */
	public int getAltoPanelBotones () {
		return altoPanelBotones;
	}

	/**
	 * @return the altoEntorno
	 */
	public JLabel getAltoEntorno () {
		return altoEntorno;
	}

	/**
	 * @param altoEntorno the altoEntorno to set
	 */
	public JLabel setAltoEntorno (JLabel altoEntorno) {
		this.altoEntorno = altoEntorno;
		return altoEntorno;
	}

	/**
	 * @return the anchoEntorno
	 */
	public JLabel getAnchoEntorno () {
		return anchoEntorno;
	}

	/**
	 * @param anchoEntorno the anchoEntorno to set
	 */
	public JLabel setAnchoEntorno (JLabel anchoEntorno) {
		this.anchoEntorno = anchoEntorno;
		return anchoEntorno;
	}

	/**
	 * @return the reset
	 */
	public JButton getReset () {
		return reset;
	}

	/**
	 * @param reset the reset to set
	 */
	public JButton setReset (JButton reset) {
		this.reset = reset;
		return reset;
	}

}
