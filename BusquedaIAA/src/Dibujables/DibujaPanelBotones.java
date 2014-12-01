/**
 * 
 * AUTOR: VÍCTOR HERNÁNDEZ PÉREZ ASIGNATURA: PROGRAMACIÓN DE APLICACIONES
 * INTERACTIVAS E-MAIL: alu0100697032@ull.edu.es 20/11/2014
 * DibujaPanelBotones.java BusquedaIAA
 */
package Dibujables;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author Victor
 * 
 */
@SuppressWarnings("serial")
public class DibujaPanelBotones extends JPanel {

	/*
	 * ATRIBUTOS
	 */
	private int altoPanelBotones = 100;
	private int margenInferior = 35;
	private int margenSuperior = 15;
	private JButton crearEntorno;
	private JButton reset;
	private JButton moverRobot;
	private JButton modoAleatorio;
	private JButton modoSeleccion;
	private JButton generarObjetos;;
	private JLabel anchoEntorno;
	private JLabel altoEntorno;
	private JLabel numeroObjetos;
	private JTextField insertarAnchoEntorno;
	private JTextField insertarAltoEntorno;
	private JTextField insertarXDestino;
	private JTextField insertarYDestino;
	private JTextField insertarNumeroObjetos;

	public DibujaPanelBotones(int ancho, int alto) {
		setBounds(0, alto - altoPanelBotones + margenSuperior, ancho,
				altoPanelBotones - margenInferior);
		setLayout(new GridLayout(2, 0));
		add(setModoAleatorio(new JButton("Modo aleatorio")));
		add(setModoSeleccion(new JButton("Modo seleccion")));
		add(setCrearEntorno(new JButton("Crear Entorno")));
		add(setAnchoEntorno(new JLabel("Ancho")));
		add(setInsertarAnchoEntorno(new JTextField("10")));
		add(setAltoEntorno(new JLabel("Alto")));
		add(setInsertarAltoEntorno(new JTextField("10")));
		add(setGenerarObjetos(new JButton("Generar Objetos")));
		add(setNumeroObjetos(new JLabel("Objetos")));
		add(setInsertarNumeroObjetos(new JTextField("10")));
		add(setMoverRobot(new JButton("Mover Robot a:")));
		add(setInsertarXDestino(new JTextField("1")));
		add(setInsertarYDestino(new JTextField("1")));
		add(setReset(new JButton("Reset")));
		setVisible(true);
	}

	/*
	 * LISTENERS
	 */
	public void addCrearEntornoListener (ActionListener a) {
		crearEntorno.addActionListener(a);
	}

	public void addResetListener (ActionListener a) {
		reset.addActionListener(a);
	}

	public void addMoverRobotListener (ActionListener a) {
		moverRobot.addActionListener(a);
	}
	
	public void addModoSeleccion (ActionListener a) {
		modoSeleccion.addActionListener(a);
	}
	
	public void addModoAleatorio (ActionListener a) {
		modoAleatorio.addActionListener(a);
	}
	
	public void addGenerarObjetos (ActionListener a) {
		generarObjetos.addActionListener(a);
	}

	/*
	 * METODOS DE ACCESO A ATRIBUTOS
	 */
	/**
	 * @return the crearEntorno
	 */
	public JButton getCrearEntorno () {
		return crearEntorno;
	}

	/**
	 * @param crearEntorno
	 *            the crearEntorno to set
	 */
	public JButton setCrearEntorno (JButton crearEntorno) {
		this.crearEntorno = crearEntorno;
		this.crearEntorno.setEnabled(false);
		return crearEntorno;
	}

	/**
	 * @return the insertarAnchoEntorno
	 */
	public JTextField getInsertarAnchoEntorno () {
		return insertarAnchoEntorno;
	}

	/**
	 * @param insertarAnchoEntorno
	 *            the insertarAnchoEntorno to set
	 */
	public JTextField setInsertarAnchoEntorno (JTextField insertarAnchoEntorno) {
		this.insertarAnchoEntorno = insertarAnchoEntorno;
		this.insertarAnchoEntorno.setHorizontalAlignment(SwingConstants.CENTER);
		return insertarAnchoEntorno;
	}

	/**
	 * @return the insertarAltoEntorno
	 */
	public JTextField getInsertarAltoEntorno () {
		return insertarAltoEntorno;
	}

	/**
	 * @param insertarAltoEntorno
	 *            the insertarAltoEntorno to set
	 */
	public JTextField setInsertarAltoEntorno (JTextField insertarAltoEntorno) {
		this.insertarAltoEntorno = insertarAltoEntorno;
		this.insertarAltoEntorno.setHorizontalAlignment(SwingConstants.CENTER);
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
	 * @param altoEntorno
	 *            the altoEntorno to set
	 */
	public JLabel setAltoEntorno (JLabel altoEntorno) {
		this.altoEntorno = altoEntorno;
		this.altoEntorno.setOpaque(true);
		this.altoEntorno.setHorizontalAlignment(SwingConstants.CENTER);
		this.altoEntorno.setBackground(Color.CYAN);
		return altoEntorno;
	}

	/**
	 * @return the anchoEntorno
	 */
	public JLabel getAnchoEntorno () {
		return anchoEntorno;
	}

	/**
	 * @param anchoEntorno
	 *            the anchoEntorno to set
	 */
	public JLabel setAnchoEntorno (JLabel anchoEntorno) {
		this.anchoEntorno = anchoEntorno;
		this.anchoEntorno.setOpaque(true);
		this.anchoEntorno.setHorizontalAlignment(SwingConstants.CENTER);
		this.anchoEntorno.setBackground(Color.CYAN);
		return anchoEntorno;
	}

	/**
	 * @return the reset
	 */
	public JButton getReset () {
		return reset;
	}

	/**
	 * @param reset
	 *            the reset to set
	 */
	public JButton setReset (JButton reset) {
		this.reset = reset;
		this.reset.setEnabled(false);
		return reset;
	}

	/**
	 * @return the margenInferior
	 */
	public int getMargenInferior () {
		return margenInferior;
	}

	/**
	 * @param margenInferior
	 *            the margenInferior to set
	 */
	public void setMargenInferior (int margenInferior) {
		this.margenInferior = margenInferior;
	}

	/**
	 * @return the margenSuperior
	 */
	public int getMargenSuperior () {
		return margenSuperior;
	}

	/**
	 * @param margenSuperior
	 *            the margenSuperior to set
	 */
	public void setMargenSuperior (int margenSuperior) {
		this.margenSuperior = margenSuperior;
	}

	/**
	 * @return the moverRobot
	 */
	public JButton getMoverRobot () {
		return moverRobot;
	}

	/**
	 * @param moverRobot
	 *            the moverRobot to set
	 */
	public JButton setMoverRobot (JButton moverRobot) {
		this.moverRobot = moverRobot;
		this.moverRobot.setEnabled(false);
		return moverRobot;
	}

	/**
	 * @return the insertarXDestino
	 */
	public JTextField getInsertarXDestino () {
		return insertarXDestino;
	}

	/**
	 * @param insertarXDestino the insertarXDestino to set
	 */
	public JTextField setInsertarXDestino (JTextField insertarXDestino) {
		this.insertarXDestino = insertarXDestino;
		this.insertarXDestino.setHorizontalAlignment(SwingConstants.CENTER);
		return insertarXDestino;
	}

	/**
	 * @return the insertarYDestino
	 */
	public JTextField getInsertarYDestino () {
		return insertarYDestino;
	}

	/**
	 * @param insertarYDestino the insertarYDestino to set
	 */
	public JTextField setInsertarYDestino (JTextField insertarYDestino) {
		this.insertarYDestino = insertarYDestino;
		this.insertarYDestino.setHorizontalAlignment(SwingConstants.CENTER);
		return insertarYDestino;
	}

	/**
	 * @return the numeroObjetos
	 */
	public JLabel getNumeroObjetos () {
		return numeroObjetos;
	}

	/**
	 * @param numeroObjetos the numeroObjetos to set
	 */
	public JLabel setNumeroObjetos (JLabel numeroObjetos) {
		this.numeroObjetos = numeroObjetos;
		this.numeroObjetos.setOpaque(true);
		this.numeroObjetos.setHorizontalAlignment(SwingConstants.CENTER);
		this.numeroObjetos.setBackground(Color.CYAN);
		return numeroObjetos;
	}

	/**
	 * @return the insertarNumeroObjetos
	 */
	public JTextField getInsertarNumeroObjetos () {
		return insertarNumeroObjetos;
	}

	/**
	 * @param insertarNumeroObjetos the insertarNumeroObjetos to set
	 */
	public JTextField setInsertarNumeroObjetos (JTextField insertarNumeroObjetos) {
		this.insertarNumeroObjetos = insertarNumeroObjetos;
		this.insertarNumeroObjetos.setHorizontalAlignment(SwingConstants.CENTER);
		return insertarNumeroObjetos;
	}

	public JButton getModoSeleccion() {
		return modoSeleccion;
	}

	public JButton setModoSeleccion(JButton moverSeleccion) {
		this.modoSeleccion = moverSeleccion;
		return moverSeleccion;
	}

	public JButton getModoAleatorio() {
		return modoAleatorio;
	}

	public JButton setModoAleatorio(JButton modoAleatorio) {
		this.modoAleatorio = modoAleatorio;
		return modoAleatorio;
	}

	public JButton getGenerarObjetos() {
		return generarObjetos;
	}

	public JButton setGenerarObjetos(JButton generarObjetos) {
		this.generarObjetos = generarObjetos;
		this.generarObjetos.setEnabled(false);
		return generarObjetos;
	}

}
